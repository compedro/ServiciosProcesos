package testexamen;

class HiloRunnable implements Runnable {
private String nombre;
    public HiloRunnable(String str) {
   this.nombre = str;
    }
    

    @Override
    public void run() {
      for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + this.nombre);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("FIN! " + this.nombre);
    
    }

}