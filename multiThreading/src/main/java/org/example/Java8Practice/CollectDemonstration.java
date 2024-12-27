package org.example.Java8Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student{
    public String name;
    public String subject;

    public Student(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return
                "{ name='" + name + '\'' +
                ", subject='" + subject+" }" ;
    }
}
public class CollectDemonstration {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<> (  );
        list.add(new Student("Amaan","Math"));
        list.add(new Student("Ayaan","Math"));
        list.add(new Student("Anas","Math"));
        list.add(new Student("Ahad","Math"));
        list.add(new Student("Tayyab","Bio"));
        list.add(new Student("Toseef","Bio"));
        list.add(new Student("Naved","Bio"));
        list.add(new Student("Zaid","Com"));
        list.add(new Student("Bilal","Com"));
//    Create a program that demonstrates the use of collect() to group a list of
//objects (e.g., a list of books) by a specific property (e.g., genre).
        Map<String, List<Student>> collect = list.stream ( ).collect ( Collectors.groupingBy ( Student::getSubject ) );
        System.out.println ( "collect = " + collect );
//        Map<String, List<Student>> groupBySubject = list.stream ( ).collect ( Collectors.groupingBy ( a -> a.subject ) );
//        System.out.println ( "groupBySubject = " + groupBySubject );
    }


}
