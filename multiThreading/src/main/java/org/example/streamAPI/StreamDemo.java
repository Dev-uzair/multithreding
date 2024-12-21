package org.example.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> words= Arrays.asList (  "this ","is",""," for"," demo" );

        List<String> i = words.stream ( ).filter ( s-> s.contains ( "i" ) ).collect ( Collectors.toList ( ) );
        System.out.println (i );
        List<String> collect = words.stream ( ).map ( String::toUpperCase ).collect ( Collectors.toList ( ) );
        System.out.println (words );
        System.out.println (collect );
        words.stream ().reduce ( (s, s2) ->s +s2  );

    }
}
