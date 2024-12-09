package org.example.syncronization;

public class Counter {
    private int count=0;
    private int count1=0;


//    public synchronized   void increment(){
//
//            count++;
//
//
//    }
    public void increment(){
        synchronized (this){
        count++;
        }
        count1++;
    }

    public int getCount() {
        return count;
    }

    public int getCount1() {
        return count1;
    }
}
