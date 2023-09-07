package tec.poo.tareas;
import java.util.*;  

public class LectorTerminal {
    /*
     * Dominio en x: {A,B,C,D,E,F,G}
     * Dominio en y: {0,1,2,3,4,5,6}
     * Formando una matriz de 7x7
     */
    public String Terminal_input(String input_entrada)  {
        Scanner lector = new Scanner(System.in); 
        System.out.print("Enter a coordenate: ");  
        String suposicion = lector.nextLine();                       
        return suposicion;
    }  
}