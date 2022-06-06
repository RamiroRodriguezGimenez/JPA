
package jpa;

import java.util.Scanner;
import libreria.servicios.AutorServicio;


public class JPA {
    public static void main(String[] args) {
       
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AutorServicio as = new AutorServicio();
        
        System.out.println("Ingrese el nombre del autor");
        String nombre=leer.nextLine();
        Boolean alta = true;
        
        as.crear(nombre, alta);
    }
    
}
