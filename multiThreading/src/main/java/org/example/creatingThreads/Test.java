package org.example.creatingThreads;

public class Test {


public static void main(String[] args) {
//    WorldWithThread world =new WorldWithThread ();
//    world.start ();

   WorldWithRunnable withRunnable=new WorldWithRunnable ();

   Thread t1=new Thread ( withRunnable );//New state
   t1.start ();//Runnable state

//    for (; ; ) {
//        System.out.println ( "hello by " + Thread.currentThread ().getName ());
//    }
//


}

}
