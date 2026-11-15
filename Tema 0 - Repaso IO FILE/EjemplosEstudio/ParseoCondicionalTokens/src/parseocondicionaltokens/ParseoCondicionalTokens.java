/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parseocondicionaltokens;

import java.util.Scanner;

public class ParseoCondicionalTokens {

    public static void main(String[] args) {
        String texto = "HOLA 123 \n 555 CÓMO TRUE ESTAS false TrUe 22";
//        Ejemplo de usando delimitador (-) 
//        String texto = "HOLA-123-555-CÓMO-TRUE-ESTAS-false-TrUe 22";
        System.out.println("Cadena utilizada: " + texto + "\n");
        Scanner escaner = new Scanner(texto);
        
        // El delimitador por defecto es el espacio en blanco
        // por lo que no haría faltas utilizar useDelimiter(" ");
//        escaner.useDelimiter("-"); 

// 1. USO DE next(): Lee únicamente el PRIMER TOKEN (hasta el espacio)
        System.out.println("USO DE next(): Lee únicamente el PRIMER TOKEN (hasta el espacio)");
        String primerToken = escaner.next(); 
        System.out.println("next()     -> Extrae solo un token: " + primerToken);
        
 // 2. USO DE nextLine(): Lee el RESTO DE LA LÍNEA 1 (con sus espacios)
        System.out.println("USO DE nextLine(): Lee el RESTO DE LA LÍNEA 1 (con sus espacios)");
        String restoLinea1 = escaner.nextLine();  //No extrae la línea 1 completa porque la llamada previa escaner.next() ya había consumido la primera palabra ("HOLA").
        System.out.println("nextLine() -> Extrae el resto de la linea 1: " + restoLinea1);
        
  // 3. USO DE nextLine(): Lee la LÍNEA 2 COMPLETA
        System.out.println("USO DE nextLine(): Lee la LÍNEA 2 COMPLETA");
        String linea2 = escaner.nextLine(); 
        System.out.println("nextLine() -> Extrae la linea 2 entera: " + linea2);      
        

        while (escaner.hasNext()) {
            if (escaner.hasNextInt()) {
                int numero = escaner.nextInt();       // Procesa enteros
                System.out.println("Entero detectado: " + numero);
            } else if (escaner.hasNextBoolean()) {
                boolean flag = escaner.nextBoolean(); // Procesa booleanos (insensible a mayúsculas)
                System.out.println("Booleano detectado: " + flag);
            } else {
                String palabra = escaner.next();      // Procesa el resto como String
                System.out.println("Texto (String) detectado: " + palabra);
            }
        }

        escaner.close(); // Buena práctica: cerrar el flujo
    }
}
