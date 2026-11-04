package p0;

public class HiloCliente extends Thread {
    private Vaso vaso1;
    private Vaso vaso2;
    private HiloCamarero camarero;

    public HiloCliente(Vaso vaso1, Vaso vaso2, HiloCamarero camarero) {
        this.vaso1 = vaso1;
        this.vaso2 = vaso2;
        this.camarero = camarero;
    }

    @Override
    public void run() {

            while (vaso1.consultarVeces() < 2) {
                synchronized (vaso1) {
                if (!vaso1.estaLleno()) {
                    System.out.println("El cliente espera, vaso1 está vacio");
//                    vaso1.notify();
                    try {
                        vaso1.wait();
                    } catch (java.lang.Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("El vaso1 esta lleno y el cliente bebe y vacia el vaso1");
                    vaso1.vaciarVaso();
                    vaso1.incrementarVeces();
                    synchronized (camarero){
                        camarero.notify();
                    }
                }
            }
        }

            while (vaso2.consultarVeces() < 2) {
                synchronized (vaso2) {
                if (!vaso2.estaLleno()) {
                    System.out.println("El cliente espera, vaso2 está vacio");
//                    vaso2.notify();
                    try {
                        vaso2.wait();
                    } catch (java.lang.Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("El vaso2 esta lleno y el cliente bebe y vacia el vaso2");
                    vaso2.vaciarVaso();
                    vaso2.incrementarVeces();
                    synchronized (camarero){
                        camarero.notify();
                    }
                }
            }
        }
        System.out.println("El cliente se va a casa");
        synchronized (camarero){
            camarero.notify();
        }
    }
}
