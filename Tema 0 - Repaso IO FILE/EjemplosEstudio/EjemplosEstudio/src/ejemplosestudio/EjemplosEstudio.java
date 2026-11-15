/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplosestudio;

import java.util.ArrayList;

public class EjemplosEstudio {

   // 1. TIPO EXACTO <Gato>: Exige estrictamente ArrayList<Gato> (invarianza)
    public static void metodoExacto(ArrayList<Gato> alGato) {
        System.out.println("Tipo exacto <Gato>: " + alGato);
    }
       
    // 2. COMODÍN INFERIOR <? super GatoPersa>: Acepta GatoPersa y sus supertipos (Gato, Object)
    public static void metodoSuper(ArrayList<? super GatoPersa> alGato) {
        alGato.add(new GatoPersa()); // OK: 'super' SÍ permite añadir el tipo o sus subtipos
        System.out.println("Uso de '? super GatoPersa': " + alGato);  
    }
    
    // 3. COMODÍN SUPERIOR <? extends Gato>: Acepta Gato y todas sus subclases (GatoPersa)
    public static void metodoExtends(ArrayList<? extends Gato> alGato) {
        // alGato.add(new Gato()); // ERROR: 'extends' convierte la lista en SOLO LECTURA para add()
        System.out.println("Uso de '? extends Gato': " + alGato);  
    }
    
    // 4. COMODÍN UNBOUNDED <?>: Acepta cualquier ArrayList sin importar el tipo
    public static void metodoComodin(ArrayList<?> alGato) {
        // alGato.add(new Gato()); // ERROR: '?' tampoco permite añadir ningún elemento
        System.out.println("Uso de '?': " + alGato); 
    }

    public static void main(String[] args) {
           
        // =========================================================================
         System.out.println(" CASO 1: Lista declarada como ArrayList<Gato> ");
        // =========================================================================
        ArrayList<Gato> al1 = new ArrayList<Gato>();

        al1.add(new Gato());       // OK: Objeto Gato en lista <Gato>
        al1.add(new GatoPersa());  // OK: Polimorfismo clásico (GatoPersa ES UN Gato)

        metodoExacto(al1);   // OK: Coincide exactamente con género <Gato>
        metodoExtends(al1);  // OK: Gato satisface <? extends Gato>
        metodoSuper(al1);    // OK: Gato es superclase de GatoPersa (satisface ? super)
        metodoComodin(al1);  // OK: '?' acepta cualquier tipo de lista
        
         

        // =========================================================================
        System.out.println(" CASO 2: Lista declarada como ArrayList<GatoPersa>");
        // =========================================================================
        ArrayList<GatoPersa> al2 = new ArrayList<GatoPersa>();

        al2.add(new GatoPersa());  // OK: Objeto GatoPersa en lista <GatoPersa>
        // al2.add(new Gato());    // ERROR: Un Gato (madre) no se puede meter en lista de Persas (hija)

        // metodoExacto(al2);      // ERROR: ArrayList<GatoPersa> NO es convertible a ArrayList<Gato>
        metodoExtends(al2);        // OK: GatoPersa es subclase de Gato (satisface ? extends Gato)
        metodoSuper(al2);          // OK: GatoPersa coincide con el tipo límite de super
        metodoComodin(al2);        // OK: '?' acepta cualquier tipo de lista
    }
    }
    

