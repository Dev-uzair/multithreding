package org.example.ThreadLifeCycle;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println ("RUNNING" );
        try {
            Thread.sleep ( 5000 );
        System.out.println ("state"+ Thread.currentThread ().getState () );
        }
        catch ( InterruptedException e ) {
            throw new RuntimeException ( e );
        }
    }

    public static void main(String[] args) {
        MyThread t1=new MyThread ();
        System.out.println (t1.getState () );
        t1.start ();
        System.out.println (t1.getState () );
        try {
            System.out.println (Thread.currentThread ().getName ());
            Thread.sleep ( 5000 );
        }
        catch ( InterruptedException e ) {
            throw new RuntimeException ( e );
        }
        System.out.println (t1.getState () );
        try {
            t1.join ();
        }
        catch ( InterruptedException e ) {
            throw new RuntimeException ( e );
        }
        System.out.println (t1.getState () );

    }
}
