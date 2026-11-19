package org.example;


public class BucleInterrumpido {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                // Tarea en bucle
            }
            System.out.print("FinBucle ");
            System.out.print(Thread.interrupted() + " ");
            System.out.print(Thread.currentThread().isInterrupted() + " ");
        });

        t.start();
        Thread.sleep(100);
        t.interrupt();
        t.join();
    }
}