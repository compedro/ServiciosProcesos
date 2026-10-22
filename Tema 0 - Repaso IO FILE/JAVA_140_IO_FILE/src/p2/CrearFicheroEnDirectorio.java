// Diseñar una clase capaz de crear un fichero dentro de un determinado 
// directorio. Utilizar la versión sobrecargada de File que pide el
// directorio (requiere de otro File ya existente).


package p2;

import java.io.File;
import java.io.IOException;


public class CrearFicheroEnDirectorio {

    public static void main(String[] args) throws IOException {
        
        // File apuntando al directorio.
        File directorio = new File("DIRECTORIO_CARTAS");
        
        // Orden para que crear el directorio.
        directorio.mkdir();
        
        // File apuntando al fichero. Se creará dentro del directorio.
        File carta = new File(directorio,"MICARTA.TXT");
        
        // Orden de creación del fichero.
        carta.createNewFile();
        
        System.out.println("\nFIN DE IMPRESION\n");
    }

}