package testexamen;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        Hilo uno, dos;

        uno = new Hilo("Jamaica");
        dos = new Hilo("Fiji");
    
        uno.start();
        dos.start();
     
        /*al no usar el join() se ejecuta de manera secuencial el programa y
           luego el planificador baraja los procesos*/
        System.out.println("main no hace nada");

    }
//    
//        public static void main(String[] args) throws InterruptedException {
//
//        Hilo uno, dos;
//
//        uno = new Hilo("Jamaica");
//        dos = new Hilo("Fiji");
//
//        uno.run();
//        dos.run();
//
//        /*  //pueba
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
    
    
//    public static void main(String[] args) {
//
//        Hilo uno, dos;
//
//        uno = new Hilo("Jamaica");
//        dos = new Hilo("Fiji");
//
//        uno.start();
//        dos.start();
// 
//        try {
//            uno.join();
//        } catch (InterruptedException ex) {
//            System.getLogger(Demo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
//        }
//        try {
//            dos.join();
//        } catch (InterruptedException ex) {
//            System.getLogger(Demo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
//        }
//
//        System.out.println("main no hace nada");
//
//    }

}
