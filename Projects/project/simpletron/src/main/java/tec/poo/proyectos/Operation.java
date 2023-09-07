package tec.poo.proyectos;

import java.util.Scanner;
import java.lang.Math;

public class Operation {
    //Variable del operando
    private int operando;
    //Variable del código
    private int codigo;

    //Constructor que inicializa los valores de operando y codigo a partir de la instruccion
    public Operation(int instructionRegister){
        //Primeros dos dígitos corresponden al código
        codigo = instructionRegister / 1000;
        //Últimos tres dígitos corresponden al operando
        operando = instructionRegister % 1000;
    }

    //El método operations recibe el arreglo con las instrucciones en memoria, el accumulador y el registro especial, y retorna un arreglo
    public int[] operations(int[] memory, int accumulator, int specialRegister) {
        //Se define al arreglo que contiene al acumulador, salto y registro especial
        int[] accumulatorBranch = {accumulator, 0, specialRegister};
        //Swicth para manejar los diferentes casos
        switch (this.codigo) {

            //Lee
            case 10:
                Scanner Input = new Scanner(System.in);
                System.out.print("Variable: ");
                int inputNumber = Input.nextInt();
                //El input se guarda en la posición en memoria correspondiente al operando
                memory[operando] = inputNumber;

                break;

            //Escribe
            case 11:
                //Se imprime el valor que se encuentra en la memoria en la posición de operando
                System.out.println(memory[operando]);

                break;

            //Carga
            case 20:
                //Se guarda en el arreglo, en la posición correspondiente al acumulador, lo que esté en la memoria e la posición de operando
                accumulatorBranch[0] = memory[operando];
                //Se verifica desbordamiento del acumulador, el cual debe ser menor a 1000 y mayor a -1000
                if(accumulatorBranch[0] >= 999 || accumulatorBranch[0] <= -999){
                    System.out.println("Error 02: Desbordamiento del acumulador");
                    //El salto pasa a ser -1, lo cual terminará el programa
                    accumulatorBranch[1] = -1;
                }
                break;

            //Almacena
            case 21:
                //La posición en memoria de operando pasa a ser lo que se encuentre en el acumulador
                memory[operando] = accumulatorBranch[0];
                break;

            //Suma
            case 30:
                //Se le suma al acumulador la posición en memoria del operando
                accumulatorBranch[0] += memory[operando];
                //Se verifica desbordamiento del acumulador, el cual debe ser menor a 1000 y mayor a -1000
                if(accumulatorBranch[0]>999 || accumulatorBranch[0]<-999){
                    System.out.println("Error 02: Desbordamiento del acumulador");
                    accumulatorBranch[1] = -1;
                }
                break;

            //Resta
            case 31:
                //Se le resta al acumulador la posición en memoria del operando
                accumulatorBranch[0] = accumulatorBranch[0] - memory[operando];
                //Se verifica desbordamiento del acumulador, el cual debe ser menor a 1000 y mayor a -1000
                if(accumulatorBranch[0]>999 || accumulatorBranch[0]<-999){
                    System.out.println("Error 02: Desbordamiento del acumulador");
                    accumulatorBranch[1] = -1;
                }
                break;

            //Multiplica
            case 32:
                //Se multiplica el acumulador por lo de la posición en memoria del operando
                accumulatorBranch[0] *= memory[operando];
                //Se verifica desbordamiento del acumulador, el cual debe ser menor a 1000 y mayor a -1000
                if(accumulatorBranch[0]>999 || accumulatorBranch[0]<-999){
                    System.out.println("Error 02: Desbordamiento del acumulador");
                    accumulatorBranch[1] = -1;
                }
                break;

            //Divide
            case 33:
                //Se revisa si se intenta dividir entre 0
                if(memory[operando] == 0){
                    System.out.println("Error 03: Intento de división por cero");
                    //Termina el programa
                    accumulatorBranch[1] = -1;
                }

                else {
                    //Se divide el acumulador entre la posición en memoria del operando
                    accumulatorBranch[0] /= memory[operando];
                    //Se verifica desbordamiento del acumulador, el cual debe ser menor a 1000 y mayor a -1000
                    if(accumulatorBranch[0]>999 || accumulatorBranch[0]<-999){
                        System.out.println("Error 02: Desbordamiento del acumulador");
                        accumulatorBranch[1] = -1;
                    }
                }
                break;

            //Modulo
            case 34:
                //Se calcula el módulo del acumulador entre la posición en memoria dle operando
                accumulatorBranch[0] %= memory[operando];
                //Se verifica desbordamiento del acumulador, el cual debe ser menor a 1000 y mayor a -1000
                if(accumulatorBranch[0]>999 || accumulatorBranch[0]<-999){
                    System.out.println("Error 02: Desbordamiento del acumulador");
                    accumulatorBranch[1] = -1;
                }

                break;

            //Exponenciación
            case 35:
                //Se eleva el acumulador a la posición en memoria del operando, usando Math.pow
                accumulatorBranch[0] = (int) Math.pow(accumulatorBranch[0], memory[operando]);
                //Se verifica desbordamiento del acumulador, el cual debe ser menor a 1000 y mayor a -1000
                if(accumulatorBranch[0]>999 || accumulatorBranch[0]<-999){
                    System.out.println("Error 02: Desbordamiento del acumulador");
                    accumulatorBranch[1] = -1;
                }
                break;

            //Bifurca
            case 40:
                //En el arreglo, la posición correspondienteb a salto, pasa a ser el operando, lo que bifurcara a la instrucción en la localidad de memoria del operando
                accumulatorBranch[1] = operando;
                break;

            //Bifurca negativo
            case 41:
                //Modifica el salto si el acumulador es negativo
                if(accumulator < 0){
                    accumulatorBranch[1] = operando;
                }
                break;

            //Bifurca cero
            case 42:
                //Modifica el salto si el acumulador es 0
                if(accumulator == 0){
                    accumulatorBranch[1] = operando;
                }
                break;

            //Bifurca positivo
            case 43:
                //Modifica el salto si el acumulador es positivo
                if(accumulator > 0){
                    accumulatorBranch[1] = operando;
                }
                break;

            //Parar
            case 44:
                //Modifica el salto a -1, lo que indica que el programa finalice
                accumulatorBranch[1] = -1;
                break;

            //Limpiador acumulador
            case 45:
                //El acumulador se pone en 0
                accumulatorBranch[0] = 0;
                break;

            //Bifurca hasta
            case 50:
                //Si el registro especial es mayor a 0, se modifica el salto al valor de operando
                if(specialRegister > 0){
                    accumulatorBranch[1] = operando;
                }
                break;

            //Inicializa el controlador de ciclos
            case 51:
                //En el arreglo, la posición del registro especial pasa a ser el operando
                accumulatorBranch[2] = operando;
                break;

            //Si el código no es ninguno de los anteriores, se imprime un mensaje de error, el salto pasa a ser -1 y finaliza el programa
            default:
                System.out.println("Error 01: El código de operación no es válido");
                accumulatorBranch[1] = -1;
                break;
        }

        //Se retorna el arreglo con el acumulador, salto y registro especial
        return accumulatorBranch;
    }

}