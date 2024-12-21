package org.example.streamAPI.LambdaQues;



import java.util.function.Function;

public class FunctionQues {

    public static void main(String[] args) {
//    Convert an integer to its string representation
    Function<Integer,String> intToString=num-> num.toString ();
        System.out.println (intToString.apply ( 34 ) );

//    Create a function that adds "Number: " prefix to the integer
//        Function<Integer,String> addPrefix=n-> {
//            String num = n.toString ( );
//            num.isEmpty ();
//        }


    }


}
