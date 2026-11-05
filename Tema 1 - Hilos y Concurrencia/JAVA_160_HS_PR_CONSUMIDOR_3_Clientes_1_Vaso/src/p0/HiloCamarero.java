package p0;

public class HiloCamarero extends Thread {
    // recurso compartido.
    private Vaso vaso;

    // constructor para cargar el recurso compartido.
    public HiloCamarero(Vaso vaso) {
        this.vaso = vaso;
    }

    // método run ... lo que debe hacer el hilo.
    @Override
    public void run() {

        // SINCRONIZACIÓN A NIVEL DE BLOQUE UTILIZANDO COMO LLAVE EL VASO.
        synchronized (vaso) {
            // hacerlo 3 veces.
            while (vaso.consultarVeces() < 9) {
                // si el vaso está lleno, el camareno no debe volverlo a llenar,
                // luego se está quieto, se espera (waiting), e indica al planificador,
                // el Scheduler, que ya no necesita usar el recurso compartido:
                if (vaso.estaLLeno()) {
                    System.out.println("\nEL CAMARERO DICE QUE EL VASO ESTA LLENO");
//                    vaso.notify(); // 1. invocar notify sobre vaso para avisar al planificador.
                    System.out.println("Consulta de veces con el vaso lleno: " + vaso.consultarVeces());
                    vaso.notifyAll();
                    try {
                        vaso.wait(); // 2. invocar wait sobre vaso para entrar en estado de espera.
                        // WAIT A DIFERENCIA DE SLEEP, SÍ SUELTA LA LLAVE.
                        // SE DEBE SIEMPRE NOTIFICAR PRIMERO Y HACER WAIT DESPUÉS.
                    } catch (InterruptedException ex) { // wait puede lanzar InterruptedException.
                        System.out.println(ex);
                    }
                } else {
                    // si el vaso está vacio:
                    System.out.println("Consulta de veces antes de llenar: " + vaso.consultarVeces());
                    System.out.println(" >>>> EL CAMARERO LLENA EL VASO ... PARA ALIVIAR LAS PENAS!!!");
                    vaso.retardar(); // provocar un retardo sleep (no suelta la llave mientras llena).
                    vaso.llenarVaso(); // cambiar el estado de la propiedad lleno de vaso.
                    // Sera el hilo cliente el que al vaciar el vaso incrementará el
                    // número de veces (podríamos haber elegido al camarero para hacerlo).

                }
            }
            System.out.println("\n>>>>>>>> EL CAMARERO LIMPIA, RECOGE TODO, APAGA LUCES Y CIERRA."
                    + " FIN DEL HILO CAMARERO.");
        }
    }
}