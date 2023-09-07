package tec.poo.proyectos;

import java.util.InputMismatchException;
import java.util.Scanner;

//class pare leer inputs
public class Simpletron {

    //Se crea un nuevo objeto de
    Memory memory = new Memory();

    //constructor de la class SimpletronRead
    public Simpletron(){
        //mensaje de simpletron + leer instrucciones
        System.out.println("Simpletron [version 1.0.0]");
        //Se llama al método para leer instrucciones
        readInstructions();
        //Se llama al método para ejecutar instrucciones
        executeInstructions();
    }

    private void readInstructions(){
        int input = 0; //para almacenar el ultimo input
        int memoryLocation = 0; //contador de localidad de memoria

        Scanner InputWords = new Scanner(System.in);

        //Si el input es -99999, se detiene la lectura, mientras no lo sea, se continua la lectura
        while (input != -99999) {
            //imprime memoryLocation en ese momento
            System.out.printf("%03d> ", memoryLocation);

            try{
                //recibe los inputs y continua con el proximo
                input = InputWords.nextInt();

                //Se verifica el rango para la lectura
                if (input < 99999 && -99998 <= input) {
                    //Se llama al método de añadir a memoria con input y la localidad como argumentos
                    memory.addMemory(input, memoryLocation);

                    //sumar 1 al contador de localidad
                    memoryLocation++;
                }

                else if(input == -99999){
                    break;
                }


                //Si la instrucción está fuera del rango, se imprime un error
                else {
                    System.out.println("Error 04: Instrucción fuera de rango");
                }
            }

            //Si el input no es un entero notifica del error
            catch(InputMismatchException e){
                System.out.println("Error 05: Instrucción inválida");
                break;
            }


        }
        //una vez sea -99999 la carga sera completada
        System.out.println("Carga completada, ejecutando");

    }

    //Método para ejecutar instrucciones
    private void executeInstructions(){
        //El contador de instruccion se inicializa en 0
        int instructionCounter = 0;
        //Variable para la instrucción actual
        int currentInstruction;


        do{
            System.out.println("Simple>");
            //Del objeto memory, se accede a memoryInstructions en la posición del contador
            currentInstruction = memory.memoryInstructions[instructionCounter];
            //Se llama al método loadInstructions con el objeto memory, con el contador como parámetro
            memory.loadInstructionMemory(instructionCounter);

            //Controla el flujo de saltos
            if(memory.branch > 0) {
                instructionCounter = memory.branch;
            }

            //Termina el programa, al fijar la instrucción actual como 44000
            else if(memory.branch == -1){
                currentInstruction = 44000;
            }

            //Aumenta el contador
            else {
                instructionCounter++;
            }

        }
        while(currentInstruction != 44000);

    }



}