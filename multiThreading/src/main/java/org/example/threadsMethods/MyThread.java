package org.example.threadsMethods;

public class MyThread extends Thread {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread ( );
        t1.start ( );
        t1.join ();
        System.out.println ( "hello in main" +Thread.currentThread ().getName () );
    }

    @Override
    public void run() {
        System.out.println ( "thread is Running...." +Thread.currentThread ().getName ());

            try {
                Thread.sleep ( 5000 );
            }
            catch ( InterruptedException e ) {
                throw new RuntimeException ( e );

        }
    }
}
