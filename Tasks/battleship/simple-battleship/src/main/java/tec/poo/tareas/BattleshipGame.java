package tec.poo.tareas;

public class BattleshipGame {
    public static void main(String[] args) 
    { 
        System.out.println("Welcome to Battleship");
        System.out.println("Your mission: eliminate cabista, poniez and hacqui");
        int contIntentos = 1; 
        //es la encargada de inicar el juego
        Battleship tableroJuego = new Battleship(); 
        //se llama a LectorTerminal encargado de leer los inputs
        LectorTerminal funcionAuxiliar = new LectorTerminal(); 

        //------Plantillas para colocacion del barco------//
        int max=2, min=0;
        int numeroPseudoRandom = (int) (Math.random()*(max-min+1)+min); 
        if (numeroPseudoRandom==0){
            //Posiciones de cabista, poniez y hacqui Version 1
            System.out.println("Plantilla de juego 1");
            int[][] cabista = {{1, 0}, {2, 0}, {3, 0}}; //B0,C0,D0
            int[][] poniez = {{3, 2}, {3, 3}, {3, 4}};  //D2,D3,D4
            int[][] hacqui = {{6, 3}, {6, 4}, {6, 5}};  //G3,G4,G5
            tableroJuego.posicionarBarco(cabista,poniez,hacqui);
        }
        if (numeroPseudoRandom==1){
            //Posiciones de cabista, poniez y hacqui Version 2
            System.out.println("Plantilla de juego 2");
            int[][] cabista = {{4, 0}, {5, 0}, {6, 0}}; //E0,F0,G0
            int[][] poniez = {{4, 2}, {4, 3}, {4, 4}};  //E2,E3,E4
            int[][] hacqui = {{5, 3}, {5, 4}, {5, 5}};  //F3,F4,F5
            //colocamos los barcos
            tableroJuego.posicionarBarco(cabista,poniez,hacqui);
        }
        if (numeroPseudoRandom==2){
            //Posiciones de cabista, poniez y hacqui Version 3
            System.out.println("Plantilla de juego 3");
            int[][] cabista = {{1, 5}, {2, 5}, {3, 5}}; //B5,C5,D5
            int[][] poniez = {{5, 0}, {5, 1}, {5, 2}};  //F0,F1,F2
            int[][] hacqui = {{6, 4}, {6, 5}, {6, 6}};  //G4,G5,G6
            //colocamos los barcos
            tableroJuego.posicionarBarco(cabista,poniez,hacqui);
        }
        //          fin de la plantilla        //;
        
        //Declaracion de variables necesarias para el ciclo while
        //se declara un valor booleano para despues revisar si el barco sigue en pie  
        boolean sigueVivo = true;
        //Ciclo while, funciona siempre y cuando el barco siga con vida
        while(sigueVivo == true) 
        { 
            String suposicion = funcionAuxiliar.Terminal_input("String");
            //Se recibe la coordenada con la que el usuario quiere probar su "suerte"

            String resultadoSuposicion = tableroJuego.revisarSuposicion(suposicion);
            //comprobamos si el usuario adivina la coordenada en el juego

            //en caso de que el barco haya muerto
            if (tableroJuego.contGolpesCabista == 3 && tableroJuego.contGolpesHacqui == 3 && tableroJuego.contGolpesPoniez == 3)
            { 
                //declaramos la variable de sigue con vida como falsa, ya que el barco ha muerto
                sigueVivo = false;
                //Se toma el contador de intentos para mostrarle al jugador su desempenno
                System.out.println("All Startups are dead! Your stock is now worthless");
                System.out.println("Took you " + contIntentos + " guesses, well done!");
            } 
            contIntentos++;
            //llevamos un contador de intentos para imprimir una vez que el juego termine la cantidad intentos del jugador
        } 
    } 
} 