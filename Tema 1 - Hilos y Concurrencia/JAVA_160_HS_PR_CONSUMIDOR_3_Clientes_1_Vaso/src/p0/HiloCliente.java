package p0;

public class HiloCliente extends Thread {

    // recurso compartido.
    private Vaso vaso;
    private String nombre;

    public HiloCliente(Vaso vaso, String nombre) {
        this.vaso = vaso;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (vaso.consultarVasosCliente(nombre) < 3) {
            synchronized (vaso) {
                if (!vaso.estaLLeno()) { // cuando el vaso está VACIO:
                    System.out.println("\nEL CLIENTE " + nombre + " DICE QUE EL VASO ESTA VACIO");
                    vaso.notify(); // notificar al Scheduler que levante al hilo camarero.
                    try {
                        vaso.wait();
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                } else { // cuando el vaso está LLENO: 
                    System.out.println("\n>>>> " + vaso.consultarVeces() + " >>>> EL CLIENTE " + nombre + " SE BEBE EL VASO ... GLU-GLU-GLU .. HIP!!!");
                    vaso.vaciarVaso();
                    vaso.incrementarVeces();
                    vaso.incrementarVasosCliente(nombre); // ES EL CLIENTE EL QUE INCREMENTA LAS VECES.
                    vaso.notify();
                }
            }
        }

        synchronized (vaso) {
            System.out.println("\n>>>>>>>> EL CLIENTE" + nombre + " ESTA TROMPA, PAGA Y SE VA A CASA."
                    + " FIN DEL HILO CLIENTE.");

            // NO OLVIDAR ESTE NOTIFY O EL CAMARERO NO TERMINARÁ.
            vaso.notify();
        }

        // Probar no obstante a comentarlo para ver cómo el hilo camarero NO TERMINA NÚNCA.

    }

}
