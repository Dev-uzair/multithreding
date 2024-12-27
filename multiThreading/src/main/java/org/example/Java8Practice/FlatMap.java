package org.example.Java8Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Book{
    public String name;
    public List<String> author;

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(List<String> author, String name) {
        this.author = author;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", name='" + name + '\'' +
                '}';
    }
}
public class FlatMap {
    public static void main(String[] args) {
        List<Book> books=new ArrayList<> ();
        books.add ( new Book ( Arrays.asList ( "uzair","ahad","meezan" ), "book1") );
        books.add ( new Book ( Arrays.asList ( "uzair","ahad1","meezan1" ), "book2") );
        books.add ( new Book ( Arrays.asList ( "uzair","ahad2","meezan2" ), "book3") );
        books.add ( new Book ( Arrays.asList ( "uzair","ahad3","meezan3" ), "book4") );
        List<String> listStream = books.stream ( ).map ( Book::getAuthor ).flatMap ( a->a.stream () ).distinct ().toList ();
        System.out.println ( "listStream = " + listStream );
//        List<String> authorList =  books.stream ( )
//                                        .map ( book -> book.getAuthor ( ) )
//                                        .flatMap ( authors -> authors.stream ( ) )
//                                        .distinct ()
//                                        .toList ( );
//        System.out.println ( "authorList = " + authorList );
    }


}
