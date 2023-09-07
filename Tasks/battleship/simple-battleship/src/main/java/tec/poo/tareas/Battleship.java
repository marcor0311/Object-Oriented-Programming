package tec.poo.tareas;

public class Battleship { //inicio de llaves clase
    //declaracion de variables, creamos la matriz
    int[][][] tableroBarco;
    boolean[][] pegado = {{true, true, true},{true, true, true},{true, true, true}};
    //contador para saber cuando el barco ha muerto
    int contGolpesCabista = 0;
    int contGolpesPoniez = 0;
    int contGolpesHacqui = 0;
    //definimos la comprobacion como miss ya que es el caso base
    public String comprobacion = "Miss";
    public Battleship() {
        tableroBarco = new int[3][3][2];
    }
    public void posicionarBarco(int[][]...barcos) {
        tableroBarco = barcos;
    }
    
 //se recibe un string pero se convierte a un entero para comprobacion
public String revisarSuposicion(String suposicion_string) {
    
    //comprobacion coordenada X
    int suposicionX = 0;
    //comprobacion coordenada Y
    int suposicionY = 0;
    try {
        //se hace la transicion de letra a entero
        suposicionX = suposicion_string.charAt(0) - 'A'; 
        //se pasa de char a entero
        suposicionY = Integer.valueOf(suposicion_string.charAt(1) - '0');
        //System.out.println(suposicionX);
        //System.out.println(suposicionY);

        //para que el codigo no se caiga
      } catch (Exception e) {
        System.err.println("error");
        return "error";
      }//imprime error si X esta fuera del dominio
      if (suposicionX > 6 || suposicionX < 0) {
        System.err.println("error");
        return "error";
      }//imprime error si Y esta fuera del dominio
      if (suposicionY > 6 || suposicionY < 0) {
        System.err.println("error");
        return "error";
      }

    //definimos la comprobacion como miss ya que es el caso base
    comprobacion = "Miss";
    //se declaran para recorrer los for
    int x = 0;
    int y = 0;
    //recorre el for en la posicion X
    for (x=0; x < tableroBarco.length; x++) {
        //recorre el for en la posicion y
        for (y=0; y < tableroBarco.length; y++) {
        //si la suposicion es igual a una posicion del barco entonces provoca un golpe
        if (suposicionX == tableroBarco[x][y][0] && pegado[x][y] && suposicionY == tableroBarco[x][y][1]){
            comprobacion = "Hit!";
            //si x es igual a 0 entonces corresponde a Cabista
            if (x==0) {
                contGolpesCabista++;
                if (contGolpesCabista==3){
                    comprobacion = "Kill!";
                    System.out.println("Ouch! You sunk Cabista :(");
                }
            }
            //si x es igual a 1 entonces corresponde a Poniez
            if (x==1) {
                contGolpesPoniez++;
                if (contGolpesPoniez==3){
                    comprobacion = "Kill!";
                    System.out.println("Ouch! You sunk Poniez :(");
                }
            }
            //si x es igual a 0 entonces corresponde a Cabista
            if (x==2){
                contGolpesHacqui++;
                if (contGolpesHacqui==3){
                    comprobacion = "Kill!";
                    System.out.println("Ouch! You sunk Hacqui :(");
                }
            }
            pegado[x][y]=false;
            //break para salir del ciclo
            break;
        }
    }
}
    //Aqui es donde vamos a imprimir cuando: "miss", "hit" o "kill"
    System.out.println(comprobacion);
        return comprobacion;
    } 
} 
