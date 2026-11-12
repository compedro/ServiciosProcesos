package testexamen;

import static java.lang.Thread.sleep;

class Hilo extends Thread {

    public Hilo(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("FIN! " + getName());

    }
}
