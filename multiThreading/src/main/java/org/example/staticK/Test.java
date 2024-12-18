package org.example.staticK;

public class Test {
    static{
        System.out.println ("static block running" );
    }
    //instance
    {
        System.out.println ("instance block running" );
    }
    void something(){
        System.out.println ("method" );
    }

    public static void main(String[] args) {
        System.out.println ("main method running" );
        Test test=new Test ();
        test.something ();
    }

}