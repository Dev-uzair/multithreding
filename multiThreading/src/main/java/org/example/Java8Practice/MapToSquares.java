package org.example.Java8Practice;

import java.util.List;

public class MapToSquares {
//     Use the map function to convert a list of integers to their squared values
public static void main(String[] args) {
    List<Integer> list=List.of ( 1,3,4,56,7,8,9,32,43 );
    List<Integer> list1 = list.stream ( ).map ( (a) -> a * a ).toList ( );
    System.out.println ( "list1 = " + list1 );
}

}
