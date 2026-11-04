package p0;

public class HiloCamarero extends Thread {
    private Vaso vaso1;
    private Vaso vaso2;

    public HiloCamarero(Vaso vaso1, Vaso vaso2) {
        this.vaso1 = vaso1;
        this.vaso2 = vaso2;
    }

    @Override
    public void run() {
        while ((vaso1.consultarVeces() + vaso2.consultarVeces()) < 4) {

//Lógica que no me funciona
//                if (vaso1.consultarVeces()<2) {
//                    synchronized (vaso1) {
//                        if (vaso1.estaLleno()) {
//                            System.out.println("El camarero espera, vaso1 está lleno");
//                            vaso1.notify();
//
//                            try {
//                                vaso1.wait();
//                            } catch (java.lang.Exception e) {
//                                throw new RuntimeException(e);
//                            }
//
//                        } else {
//                            System.out.println("El camarero llena el vaso1");
//                            vaso1.llenarVaso();
//                        }
//                    }
//                }
//
//                if (vaso2.consultarVeces() < 2) {
//                    synchronized (vaso2) {
//                    if (vaso2.estaLleno()) {
//                        System.out.println("El camarero espera, vaso2 está lleno");
//                        vaso2.notify();
//                        try {
//                            vaso2.wait();
//                        } catch (java.lang.Exception e) {
//                            throw new RuntimeException(e);
//                        }
//                    } else {
//                        System.out.println("El camarero llena el vaso2");
//                        vaso2.llenarVaso();
//                    }
//                }
//            }

            synchronized (this) { // Lock en el camarero, no en los vasos
                if (vaso1.consultarVeces() < 2 && !vaso1.estaLleno()) {
                    System.out.println("El camarero llena el vaso1");
                    vaso1.llenarVaso();
                    synchronized (vaso1){
                        vaso1.notify();
                    }
                } else if (vaso2.consultarVeces() < 2 && !vaso2.estaLleno()) {
                    System.out.println("El camarero llena el vaso2");
                    vaso2.llenarVaso();
                    synchronized (vaso2){
                        vaso2.notify();
                    }
                } else {
                    System.out.println("El camarero espera");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
//            }

        }
        System.out.println("El camarero cierra el bar");
    }
}