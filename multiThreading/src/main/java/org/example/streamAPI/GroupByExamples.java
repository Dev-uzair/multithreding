package org.example.streamAPI;

import java.util.*;
import java.util.stream.*;


class Employee {
    private String name;
    private String department;
    private int age;
    private double salary;

    public Employee(String name, String department, int age, double salary) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (" + department + ", " + age + ", $" + salary + ")";
    }
}

public class GroupByExamples {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList (
                new Employee ( "John", "IT", 30, 70000 ),
                new Employee ( "Alice", "HR", 25, 55000 ),
                new Employee ( "Bob", "IT", 35, 70000 ),
                new Employee ( "Carol", "HR", 28, 70000 ),
                new Employee ( "David", "Finance", 40, 80000 ),
                new Employee ( "Eve", "Finance", 32, 65000 )
        );

        // 1. Simple GroupBy by Department
//            Map<String, List<Employee>> byDepartment = employees.stream()
//                    .collect(Collectors.groupingBy(Employee::getDepartment));
//            System.out.println("Grouped by Department: " + byDepartment);

//            // 2. GroupBy with Counting
//            Map<String, Long> departmentCount = employees.stream()
//                    .collect(Collectors.groupingBy(
//                            Employee::getDepartment,
//                            Collectors.counting()
//                    ));
//            System.out.println("Department Count: " + departmentCount);

//            // 3. GroupBy with Average Salary
//            Map<String, Double> avgSalaryByDept = employees.stream()
//                    .collect(Collectors.groupingBy(
//                            Employee::getDepartment,
//                            Collectors.averagingDouble(Employee::getSalary)
//                    ));
//            System.out.println("Average Salary by Department: " + avgSalaryByDept);
//
//            // 4. GroupBy with Multiple Levels
//            Map<String, Map<Integer, List<Employee>>> deptAndAge = employees.stream()
//                    .collect(Collectors.groupingBy(
//                            Employee::getDepartment,
//                            Collectors.groupingBy(e -> e.getAge() / 10 * 10) // Group by age decades
//                    ));
//            System.out.println("Grouped by Department and Age Decade: " + deptAndAge);
////
//            // 5. GroupBy with Custom Collector
//            Map<String, String> employeeNamesByDept = employees.stream()
//                    .collect(Collectors.groupingBy(
//                            Employee::getDepartment,
//                            Collectors.mapping(
//                                    Employee::getName,
//                                    Collectors.joining(", ")
//                            )
//                    ));
//            System.out.println("Employee Names by Department: " + employeeNamesByDept);
//
        // 6. GroupBy with Max Salary
//            Map<String, Optional<Employee>> maxSalaryByDept = employees.stream()
//                    .collect(Collectors.groupingBy(
//                            Employee::getDepartment,
//                            Collectors.maxBy(Comparator.comparing(Employee::getSalary))
//                    ));
//            System.out.println("Highest Paid Employee by Department: " + maxSalaryByDept);
//
//            // 7. GroupBy with Salary Ranges
//            Map<String, Map<String, List<Employee>>> salaryRangeByDept = employees.stream()
//                    .collect(Collectors.groupingBy(
//                            Employee::getDepartment,
//                            Collectors.groupingBy(e -> {
//                                if (e.getSalary() < 60000) return "Low";
//                                else if (e.getSalary() < 75000) return "Medium";
//                                else return "High";
//                            })
//                    ));
//            System.out.println("Salary Ranges by Department: " + salaryRangeByDept);

//            Map<Double, List<Employee>> collect = employees.stream ( ).collect ( Collectors.groupingBy ( Employee::getSalary ) );
//            System.out.println (collect );

//            // 8. GroupBy with Statistics
//            Map<String, DoubleSummaryStatistics> salaryStatsByDept = employees.stream()
//                    .collect(Collectors.groupingBy(
//                            Employee::getDepartment,
//                            Collectors.summarizingDouble(Employee::getSalary)
//                    ));
//            System.out.println("Salary Statistics by Department: " + salaryStatsByDept);
//
//            // 9. GroupBy with Partitioning
        Map<Boolean, List<Employee>> seniorsByDept = employees.stream ( )
                .collect ( Collectors.partitioningBy ( e -> e.getAge ( ) > 30 ) );
        System.out.println ( "Seniors by Department: " + seniorsByDept );
    }
}

