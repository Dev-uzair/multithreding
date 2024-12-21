package org.example.streamAPI;

import org.example.functionalInterface.AddFunc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args) {
//
//        AddFunc addFunc=(a,b)->{
//            int i = a * 5;
//            return a+b+i;
//        };
//
//        System.out.println (addFunc.apply ( 5,6 ) );
//        Predicate<String> add =( a )-> a.equalsIgnoreCase ( "hello" );
//        System.out.println (add.test ( "helLo" ));
////
//        Function<String,Integer> function=(a)-> {
//            int i = a.length ( ) + 5;
//                      return  i;
//        };
//        System.out.println (function.apply ( "qwertyuiop" ) );
//
//        Supplier<Integer> supplier=()-> Integer.MAX_VALUE;
//        System.out.println (supplier.get () );

        Consumer<Integer> consumer = integer -> {
            System.out.println ( integer );
        };
        consumer.accept ( 8943 );
//        AddFunc addFunc=(c,d)-> c+d;
//        System.out.println (addFunc.apply ( 4,7 ) );
//
//        AddFunc subtract=(c,d)-> c-d;
//        System.out.println (subtract.apply ( 7,4 ) );

//        Predicate<String> add =( a )-> a.equalsIgnoreCase ( "hello" );
//        System.out.println (add.test ( "helLo" ));
        List<String> words = new ArrayList<> ( );
        words.add ( "one" );
        words.add ( "two" );
        words.add ( "three" );
        words.add ( "four" );
        words.add ( "five" );
        Function<String, String> toUppercase = String::toUpperCase;

        System.out.println ( words.stream ( ).map ( toUppercase ).toList ( ) );
////
    }


//  lambda function has no name ,no return type
//  even if your doing simple operation you can
//  avoid writing return keyword also
//  for complex operation you have to add {} curly braces

}
