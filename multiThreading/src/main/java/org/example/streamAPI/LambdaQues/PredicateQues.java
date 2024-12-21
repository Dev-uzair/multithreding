package org.example.streamAPI.LambdaQues;

import java.util.function.Predicate;

public class PredicateQues {
    public static void main(String[] args) {
//        Check if a string is empty
        Predicate<String> isEmpty = s -> s.isEmpty ( );
        System.out.println (isEmpty.test ( "" ) );

//        Verify if a string's length is greater than 5
         isEmpty=s->s.length ()>5;
        System.out.println (isEmpty.test ( "ksjdi" ) );

//        Determine if a string contains the letter 'a'

        isEmpty=s -> s.contains ( "a" );
        System.out.println (isEmpty.test ( "ksjdia" ) );



    }
}
