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
        // Sincronizar en base al recurso compartido. De no utilizarse un contexto
        // sincrono o de utilizarse algo que no sea el recurso compartido, se 
        // producirá un error en ejecución.
        synchronized (vaso) {
            while (vaso.consultarVasosCliente(nombre) < 3) {
                if (!vaso.estaLLeno()) { // cuando el vaso está VACIO:
                    System.out.println("\nEL CLIENTE " + nombre + " DICE QUE EL VASO ESTA VACIO");
                    vaso.notify(); // notificar al Scheduler que levante al hilo camarero.
                    try {
                        vaso.wait(); // el hilo cliente se pone en espera.
//                        // Añado el if...continue como Verificación: si desperta pero el vaso ya está vacío, volver a esperar
//                        //para tratar de conseguir que el que notifica que vaso está vacio se lo beba
//                        if (!vaso.estaLLeno()) {
//                            continue; // Volver al inicio del while
//                        }
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                } else { // cuando el vaso está LLENO: 
                    System.out.println("\n>>>> " + vaso.consultarVeces() + " >>>> EL CLIENTE " + nombre + " SE BEBE EL VASO ... GLU-GLU-GLU .. HIP!!!");
                    vaso.vaciarVaso();
                    vaso.incrementarVeces();
                    vaso.incrementarVasosCliente(nombre); // ES EL CLIENTE EL QUE INCREMENTA LAS VECES.
//                    vaso.retardar();
                }
            }

            System.out.println("\n>>>>>>>> EL CLIENTE ESTA TROMPA, PAGA Y SE VA A CASA."
                    + " FIN DEL HILO CLIENTE.");

            // NO OLVIDAR ESTE NOTIFY O EL CAMARERO NO TERMINARÁ.
            vaso.notify();

            // Probar no obstante a comentarlo para ver cómo el hilo camarero NO TERMINA NÚNCA.
        }
    }

}
