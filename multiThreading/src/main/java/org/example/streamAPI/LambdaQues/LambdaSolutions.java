package org.example.streamAPI.LambdaQues;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class LambdaSolutions {

    // 1. Predicate Interface Solutions
    public static void predicateSolutions() {
        // Check if string is empty
        Predicate<String> isEmpty = str -> str.isEmpty();
        System.out.println(isEmpty.test("")); // true

        // Check if length > 5
        Predicate<String> longerThanFive = str -> str.length() > 5;
        System.out.println(longerThanFive.test("Hello World")); // true

        // Check if contains 'a'
        Predicate<String> containsA = str -> str.contains("a");
        System.out.println(containsA.test("Java")); // true
    }

    // 2. Function Interface Solutions
    public static void functionSolutions() {
        // Integer to String
        Function<Integer, String> intToString = num -> String.valueOf(num);
        System.out.println(intToString.apply(123)); // "123"

        // Add prefix
        Function<Integer, String> addPrefix = num -> "Number: " + num;
        System.out.println(addPrefix.apply(42)); // "Number: 42"

        // Even/Odd checker
        Function<Integer, String> evenOddChecker = num -> num % 2 == 0 ? "Even" : "Odd";
        System.out.println(evenOddChecker.apply(7)); // "Odd"
    }

    // 3. Consumer Interface Solutions
    public static void consumerSolutions() {
        List<String> list = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));

        // Print all elements
        Consumer<List<String>> printAll = items -> items.forEach(System.out::println);

        // Convert to uppercase and print
        Consumer<List<String>> uppercasePrint = items ->
                items.forEach(str -> System.out.println(str.toUpperCase()));

        // Remove short elements
        Consumer<List<String>> removeShort = items ->
                items.removeIf(str -> str.length() < 4);
    }

    // 4. Supplier Interface Solutions
    public static void supplierSolutions() {
        // Random number generator
        Supplier<Integer> randomInt = () -> new Random().nextInt(100) + 1;
        System.out.println(randomInt.get());

        // Current date and time
        Supplier<LocalDateTime> currentTime = LocalDateTime::now;
        System.out.println(currentTime.get());

        // Random greeting
        Supplier<String> randomGreeting = () -> {
            List<String> greetings = Arrays.asList("Hello", "Hi", "Hey", "Greetings");
            return greetings.get(new Random().nextInt(greetings.size()));
        };
        System.out.println(randomGreeting.get());
    }

    // 5. Comparator Interface Solutions
    public static void comparatorSolutions() {
        List<Integer> numbers = Arrays.asList(1, 5, 3, 7, 2);
        List<String> words = Arrays.asList("Java", "Python", "C");

        // Sort integers descending
        Comparator<Integer> descendingOrder = (a, b) -> b.compareTo(a);
        numbers.sort(descendingOrder);

        // Sort by string length
        Comparator<String> byLength = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        words.sort(byLength);

        // Custom Person sorting
        class Person {
            String name;
            int age;
            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }

        Comparator<Person> personComparator =
                Comparator.comparing((Person p) -> p.name)
                        .thenComparingInt(p -> p.age);
    }

    // 6. Combining Functional Interfaces
    public static void combiningInterfaces() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Filter even numbers
        Predicate<Integer> isEven = num -> num % 2 == 0;

        // Double the numbers
        Function<Integer, Integer> doubleIt = num -> num * 2;

        // Print result
        Consumer<Integer> printNum = System.out::println;

        // Combine all operations
        numbers.stream()
                .filter(isEven)
                .map(doubleIt)
                .forEach(printNum);
    }

    // 7. Method Reference Solutions
    public static void methodReferenceSolutions() {
        // Convert to method references
        Function<String, String> toUpper = String::toUpperCase;
        BinaryOperator<Integer> findMax = Math::max;
        Consumer<List<?>> clearList = List::clear;
    }

    // 8. Custom Functional Interface Solutions
    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }

    public static void calculatorSolutions() {
        // Addition
        Calculator add = (a, b) -> a + b;

        // Subtraction
        Calculator subtract = (a, b) -> a - b;

        // Multiplication
        Calculator multiply = (a, b) -> a * b;

        // Division
        Calculator divide = (a, b) -> b != 0 ? a / b : 0;
    }

    // 9. Stream API Solutions
    public static void streamSolutions() {
        List<String> strings = Arrays.asList("Apple", "Banana", "Avocado", "Cherry");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Filter strings starting with 'A'
        List<String> aWords = strings.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());

        // Square numbers
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        // Sum of numbers
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        // First even number
        Optional<Integer> firstEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .findFirst();
    }

    // 10. Error Handling Solutions
    public static void errorHandlingSolutions() {
        // Safe integer parsing
        Function<String, Integer> safeParser = str -> {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return 0;
            }
        };

        // Safe division
        BinaryOperator<Double> safeDivide = (a, b) -> {
            try {
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            } catch (ArithmeticException e) {
                return 0.0;
            }
        };

        // Input validation
        Predicate<String> isValid = str -> str != null && !str.isEmpty();
        Function<String, String> processInput = str ->
                isValid.test(str) ? str.toUpperCase() : "";
    }

    // Bonus Challenge Solution
    public static void bonusChallenge() {
        List<String> data = Arrays.asList("Java", "Python", "", "C++", "JavaScript");

        // Define functional interfaces
        Predicate<String> isNotEmpty = str -> !str.isEmpty();
        Function<String, String> addPrefix = str -> "Language: " + str;
        Consumer<String> printResult = System.out::println;

        // Process data using multiple functional interfaces
        data.stream()
                .filter(isNotEmpty)
                .map(addPrefix)
                .forEach(printResult);
    }

    public static void main(String[] args) {
        // Run all solutions
        predicateSolutions();
        functionSolutions();
        consumerSolutions();
        supplierSolutions();
        comparatorSolutions();
        combiningInterfaces();
        methodReferenceSolutions();
        calculatorSolutions();
        streamSolutions();
        errorHandlingSolutions();
        bonusChallenge();
    }
}
