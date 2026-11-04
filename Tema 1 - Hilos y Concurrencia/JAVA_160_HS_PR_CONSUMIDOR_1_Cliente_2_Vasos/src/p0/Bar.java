package p0;

public class Bar {
   public static void main(String[] args) {
        Vaso vaso1 = new Vaso();
        Vaso vaso2 = new Vaso();

        HiloCamarero camarero = new HiloCamarero(vaso1,vaso2);
        HiloCliente cliente = new HiloCliente(vaso1, vaso2, camarero);
        cliente.start();
        camarero.start();

        try {
            cliente.join();
            camarero.join();
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main dice que se termino");
    }
    
}