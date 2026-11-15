package testexamen;

public class Demo {

//    public static void main(String[] args) throws InterruptedException {
//
//       
//
//        HiloThread uno = new HiloThread("Jamaica");
//        Thread dos = new Thread(new HiloRunnable("Fiji"));
//    
//        uno.start();
//        dos.start();
//     
//        /*al no usar el join() se ejecuta de manera secuencial el programa y
//           luego el planificador baraja los procesos*/
//        System.out.println("main no hace nada");
//
//    }
//        public static void main(String[] args) throws InterruptedException {
//
//        HiloThread uno = new HiloThread("Jamaica");
//        Thread dos = new Thread(new HiloRunnable("Fiji"));
//
    ////        uno.run();
////        dos.run();
//
//        /* //pueba
//        uno.run();
//        dos.start();
//        uno.join();
//        dos.join();
//*/ 
//
//
//        System.out.println("main no hace nada");
//
//    }
    
    
    public static void main(String[] args) throws InterruptedException {

        HiloThread uno = new HiloThread("Jamaica");
        Thread dos = new Thread(new HiloRunnable("Fiji"));

        uno.start();
        dos.start();

        uno.join();
        dos.join();

        System.out.println("main no hace nada");

    }

}
