package org.example.Java8Practice;

import java.util.ArrayList;
import java.util.List;

public class StreamApiTasks1 {
    //    Write a program that uses a Stream to filter and sort a list of strings.
    public static void main(String[] args) {
        List<String> words = new ArrayList<> ( );
        words.add ( "Uzair" );
        words.add ( "Arsalanssss" );
        words.add ( "Adeeb" );
        words.add ( "Ziya" );
        words.add ( "Ahtesham" );
        words.add ( "Mehran" );
        words.add ( "Ibrahim" );
        List<String> filteredAndSortedList = words.stream ( ).filter ( a -> a.length ( ) <= 6 )
                                            .sorted ( (a, b) -> a.compareToIgnoreCase ( b ) )
                                            .toList ( );
        System.out.println ( "filteredAndSortedList = " + filteredAndSortedList );
    }

}
