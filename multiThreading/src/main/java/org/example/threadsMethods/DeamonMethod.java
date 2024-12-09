package org.example.threadsMethods;

public class DeamonMethod extends Thread{
    public DeamonMethod(String name) {
        super ( name );
    }

    @Override
    public void run() {
        while (true) {
            System.out.println (Thread.currentThread ().getName () );
        }
    }

    public static void main(String[] args) {
        DeamonMethod t1=new DeamonMethod ( "t1" );
        t1.setDaemon ( true );
        t1.start ();
    }

}
