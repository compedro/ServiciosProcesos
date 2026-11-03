
package p0;
public class Bar {
    public static void main(String[] args) {
        // Creación del recurso compartido.
        Vaso vaso = new Vaso();
        // Creación de los hilos:
//        // EL PRODUCTOR.
        HiloCamarero camarero = new HiloCamarero(vaso);
        // EL CONSUMIDOR.
        HiloCliente cliente = new HiloCliente(vaso, "Cliente 1");
        HiloCliente cliente2 = new HiloCliente(vaso, "Cliente 2");
        // Arranque de los hilos (no importa el orden).
        cliente.start();
        cliente2.start();
        camarero.start();        
        
        // Encolamiento de ambos con respecto al main.
        try {
            cliente.join();
            cliente2.join();
            camarero.join();
        } catch(InterruptedException ie) {
            System.out.println("ERROR DE ENCOLAMIENTO");
            ie.printStackTrace();
        }
                
        System.out.println("\n\n --- MAIN DICE QUE SE TERMINO --- \n");
    }    

}