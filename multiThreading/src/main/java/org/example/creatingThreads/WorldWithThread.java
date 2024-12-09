package org.example.creatingThreads;

public class WorldWithThread extends Thread {

    @Override
    public void run() {
        for (; ; ) {
            System.out.println ( "world by " + Thread.currentThread ().getName ());
        }
    }
}
