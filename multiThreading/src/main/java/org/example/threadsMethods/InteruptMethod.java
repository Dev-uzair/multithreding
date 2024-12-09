package org.example.threadsMethods;

public class InteruptMethod extends Thread {
    public static void main(String[] args) throws InterruptedException {
        InteruptMethod t1 = new InteruptMethod ( );
        System.out.println ( t1.getState ( ) );
        t1.start ( );
        System.out.println ( t1.getState ( ) );
        t1.interrupt ( );
        System.out.println ( t1.getState ( ) );
        t1.join ();
        System.out.println ( t1.getState ( ) );

    }

    @Override
    public void run() {
        try {
            Thread.sleep ( 2000 );
        }
        catch ( InterruptedException e ) {
            System.out.println ( "thread interupted" + e );
        }
    }
}
