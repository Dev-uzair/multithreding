package org.example.Java8Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Employee {
    public Long id;
    public String name;
    public Double salary;

     public Employee(Long id, String name, Double salary) {
         this.id = id;
         this.name = name;
         this.salary = salary;
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
//Use Comparator with lambda to sort a list of employees by name and salary.

public class SortingByLambda  {
    public static void main(String[] args) {
     List<Employee> employeeList=new ArrayList<> ();
             employeeList.add(new Employee ( 1L,"Uzair", 10000D ));
             employeeList.add (new Employee ( 2L,"bilal", 30000D ));
             employeeList.add (new Employee ( 3L,"Bilal", 20000D ));
             employeeList.add (new Employee ( 4L,"Toseef", 40000D ));
             employeeList.add (new Employee ( 5L,"Arbaz", 50000D ));
//a=500,b=200,b=300,t=400,u=100


//         Collections.sort ( employeeList,(a, b) -> a.getName ( ).compareToIgnoreCase ( b.getName ( ) ) );
        Comparator<Employee> sortNameWithIgnoringCases=(o1, o2) -> o1.getName ().compareToIgnoreCase ( o2.getName () );
//        Comparator<Double> doubleComparator=(a,b)->b.compareTo ( a );
        List<Employee> list = employeeList.stream ( )
                                .sorted( sortNameWithIgnoringCases
                                .thenComparing ( Employee::getSalary )
                                )
                                .toList ();
        System.out.println ( "list = " + list );
//        System.out.println ( "sortedByNames = " + employeeList );
////         employeeList.sort ( (a, b) -> b.getSalary ( ).compareTo ( a.getSalary ( ) ) );
//        System.out.println ( "sortedBySalary = " + employeeList );
    }
}