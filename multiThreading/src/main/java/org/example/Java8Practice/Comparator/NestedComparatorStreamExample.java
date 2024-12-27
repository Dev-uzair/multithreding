package org.example.Java8Practice.Comparator;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

// Complex domain models for demonstration
class Department {
    private String name;
    private List<Employee> employees;
    private Manager manager;

    public Department(String name, List<Employee> employees, Manager manager) {
        this.name = name;
        this.employees = employees;
        this.manager = manager;
    }

    // Getters
    public String getName() { return name; }
    public List<Employee> getEmployees() { return employees; }
    public Manager getManager() { return manager; }
}

class Employee {
    private String name;
    private double salary;
    private LocalDate joiningDate;
    private List<Project> projects;
    private Performance performance;

    public Employee(String name, double salary, LocalDate joiningDate,
                    List<Project> projects, Performance performance) {
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.projects = projects;
        this.performance = performance;
    }

    // Getters
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public LocalDate getJoiningDate() { return joiningDate; }
    public List<Project> getProjects() { return projects; }
    public Performance getPerformance() { return performance; }
}

class Manager extends Employee {
    private int teamSize;
    private double budget;

    public Manager(String name, double salary, LocalDate joiningDate,
                   List<Project> projects, Performance performance,
                   int teamSize, double budget) {
        super(name, salary, joiningDate, projects, performance);
        this.teamSize = teamSize;
        this.budget = budget;
    }

    public int getTeamSize() { return teamSize; }
    public double getBudget() { return budget; }
}

class Project {
    private String name;
    private double budget;
    private LocalDate deadline;
    private Status status;

    public Project(String name, double budget, LocalDate deadline, Status status) {
        this.name = name;
        this.budget = budget;
        this.deadline = deadline;
        this.status = status;
    }

    // Getters
    public String getName() { return name; }
    public double getBudget() { return budget; }
    public LocalDate getDeadline() { return deadline; }
    public Status getStatus() { return status; }
}

enum Status { ACTIVE, COMPLETED, ON_HOLD }
enum Performance { EXCELLENT, GOOD, AVERAGE, POOR }

public class NestedComparatorStreamExample {
    public static void main(String[] args) {
        List<Department> departments = createSampleData();

        // 1. Complex sorting of departments based on multiple nested criteria
        List<Department> sortedDepartments = departments.stream()
                .sorted(Comparator
                        .comparing((Department d) -> d.getEmployees().size()) // First by team size
                        .thenComparing(d -> d.getManager().getPerformance()) // Then by manager performance
                        .thenComparing(d -> d.getEmployees().stream() // Then by avg employee salary
                                .mapToDouble(Employee::getSalary)
                                .average()
                                .orElse(0.0))
                        .reversed()) // Reverse the entire ordering
                .collect(Collectors.toList());

        // 2. Find departments with high-performing teams
        List<Department> highPerformingDepts = departments.stream()
                .sorted(Comparator
                        .comparing((Department d) -> d.getEmployees().stream()
                                .filter(e -> e.getPerformance() == Performance.EXCELLENT)
                                .count())
                        .thenComparing(d -> d.getEmployees().stream()
                                .mapToDouble(Employee::getSalary)
                                .average()
                                .orElse(0.0))
                        .reversed())
                .collect(Collectors.toList());

        // 3. Sort employees across all departments by complex criteria
        List<Employee> sortedEmployees = departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .sorted(Comparator
                        .comparing(Employee::getPerformance)
                        .thenComparing(e -> e.getProjects().size())
                        .thenComparing(Employee::getSalary)
                        .reversed())
                .collect(Collectors.toList());

        // 4. Find departments with most successful projects
        List<Department> successfulDepts = departments.stream()
                .sorted(Comparator
                        .comparing((Department d) -> d.getEmployees().stream()
                                .flatMap(e -> e.getProjects().stream())
                                .filter(p -> p.getStatus() == Status.COMPLETED)
                                .count())
                        .thenComparing(d -> d.getEmployees().stream()
                                .flatMap(e -> e.getProjects().stream())
                                .mapToDouble(Project::getBudget)
                                .sum())
                        .reversed())
                .collect(Collectors.toList());

        // 5. Complex project prioritization
        List<Project> prioritizedProjects = departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .flatMap(e -> e.getProjects().stream())
                .sorted(Comparator
                        .comparing(Project::getStatus)
                        .thenComparing(Project::getDeadline)
                        .thenComparing(Project::getBudget, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        // 6. Department ranking by composite score
        List<Department> rankedDepartments = departments.stream()
                .sorted(Comparator
                        .comparing((Department d) -> calculateDepartmentScore(d))
                        .reversed())
                .collect(Collectors.toList());
    }

    // Helper method to calculate department score
    private static double calculateDepartmentScore(Department dept) {
        double performanceScore = dept.getEmployees().stream()
                .mapToDouble(e -> scorePerformance(e.getPerformance()))
                .average()
                .orElse(0.0);

        double projectScore = dept.getEmployees().stream()
                .flatMap(e -> e.getProjects().stream())
                .mapToDouble(p -> p.getStatus() == Status.COMPLETED ? p.getBudget() : 0)
                .sum();

        return performanceScore * 0.6 + projectScore * 0.4;
    }

    private static double scorePerformance(Performance performance) {
        return switch (performance) {
            case EXCELLENT -> 4.0;
            case GOOD -> 3.0;
            case AVERAGE -> 2.0;
            case POOR -> 1.0;
        };
    }

    // Helper method to create sample data
    private static List<Department> createSampleData() {
        // Create sample data implementation
        return new ArrayList<>();
    }
}
