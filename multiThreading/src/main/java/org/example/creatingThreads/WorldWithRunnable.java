package org.example.creatingThreads;

public class WorldWithRunnable implements Runnable {

    @Override
    public void run() {
        for (; ; ) {
            System.out.println ( "world  by " + Thread.currentThread ().getName ());
        }
    }
}
