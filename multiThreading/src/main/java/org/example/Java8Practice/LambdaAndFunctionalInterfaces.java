package org.example.Java8Practice;

import java.util.Arrays;
import java.util.List;

public class LambdaAndFunctionalInterfaces {
//sort list of integer

    public static void main(String[] args) {
    List<Integer> integerList= Arrays.asList ( 1,4,5,73,23,45,67,87,64,35 );
//easy approach
//          creating a new list not modifying orignal
//        List<Integer> list = integerList.stream ( ).sorted ( ).toList ( );
//        System.out.println ( "list = " + list );
        //   medium
        //modifying original data
//        Collections.sort(integerList);
//        System.out.println ( "asc  integerList = " + integerList );
//        Collections.reverse (integerList);
//        System.out.println ( "desc  integerList = " + integerList );

         //with comparator
        //we are using it directly on List so the sort method is from List interface
//        which accept a Comparator which is a functional interface
//        integerList.sort ( (a,b)-> b.compareTo ( a ) );
//        System.out.println ( "asc  integerList = " + integerList );

        List<Integer> list = integerList.stream ( ).sorted ( (a, b) -> a.compareTo ( b ) ).toList ( );
        System.out.println ( "list = " + list );
//        Create a custom functional interface and implement
//        it using lambda expressions.

//        AddFunc addFunc=(a, b) -> a+b;
//        System.out.println (addFunc.apply ( 3,6 ) );

    }

}
