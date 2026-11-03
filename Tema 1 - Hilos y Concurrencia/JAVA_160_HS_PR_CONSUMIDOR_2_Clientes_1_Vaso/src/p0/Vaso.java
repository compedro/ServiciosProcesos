
package p0;

import java.util.HashMap;
import java.util.Map;

public class Vaso {
    private boolean         lleno;          // false.
    private int             veces;          // 0. 
    private final long      retardo = 3000; // en milisegundos.
    private Map<String, Integer> vasosPorCliente; //Mapa para registrar los vasos de cada cliente
    public Vaso() {
        veces = 0;
        vasosPorCliente = new HashMap<>();
    }
    // Métodos de consulta y asignación como los getters y setters:
    // ¿el vaso está lleno? ... devolver true equivale a sí.
    public boolean estaLLeno() {
        if(lleno)System.out.println("El vaso está lleno");return lleno;
    }
    // llenar el vaso ... asignar el valor true al atributo lleno.
    public void llenarVaso() {
        System.out.println("Llenando vaso...");lleno = true;
    }
    // vaciar el vaso ... asignar el valor false al atributo lleno.
    public void vaciarVaso() {
        System.out.println("Vaciando vaso...");lleno = false;
    }
    // incrementar el total de veces que se ha realizado el proceso.
    // se hará por un total de 3 veces.
    public void incrementarVeces() {
        veces++;
    }
    
    // consulta el número de veces que se le ha llenado el vaso al cliente.
    // el atributo es private, luego utilizamos un método puente.
    public int consultarVeces() {
        return veces;
    }
    
    // retardo de 3 segundos para ver "despacio" cómo se ejecuta el programa.
    public void retardar() {
        try {
            Thread.sleep(retardo); // retardo de X segundos.        
        } catch(InterruptedException ie) {
            System.out.println(ie);
        }
    }
    
    public void incrementarVasosCliente(String nombre){
    vasosPorCliente.put(nombre, vasosPorCliente.getOrDefault(nombre, 0)+1);
    }

    public int consultarVasosCliente(String nombre) {
    return vasosPorCliente.getOrDefault(nombre, 0);}
}