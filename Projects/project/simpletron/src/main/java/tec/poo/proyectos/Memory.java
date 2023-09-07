package tec.poo.proyectos;

public class Memory {
    //Memoria de palabras
    public int[] memoryInstructions = new int[1000];

    //Variable para el acumulador
    public int accumulator;
    //Variable para salto
    public int branch;
    //Registro especial
    public int specialRegister;

    //Este método toma el input y la localidad como parámetros, y en el arreglo de enteros, en la posición de la localidad, pone al input
    public void addMemory(int input, int memoryLocation){
        memoryInstructions[memoryLocation] = input;
    }

    //Este método se encarga de cargar una instrucción desde la memoria y ejecutarla, con un contador como parámetro
    public void loadInstructionMemory(int count){
        //Proxima instruccion a ejecutar
        int instructionRegister = memoryInstructions[count];

        //Se crea un objeto de tipo operacion, con la instrucción como parámetro incial para determinar el código y operando
        Operation operacion = new Operation(instructionRegister);

        //El acumulador, los saltos y el registro especial se manejan con un arreglo, el cual se define con el método operations usado con el objeto creado
        int[] accumulatorBranch = operacion.operations(memoryInstructions, accumulator, specialRegister);

        //Se modifican los valores de acumulador, salto y registro especial, a partir del arreglo
        accumulator = accumulatorBranch[0];
        branch = accumulatorBranch[1];
        specialRegister = accumulatorBranch[2];


    }


}
