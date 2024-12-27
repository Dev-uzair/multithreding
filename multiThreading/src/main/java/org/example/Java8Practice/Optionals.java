package org.example.Java8Practice;

import java.util.Optional;

public class Optionals {
//    Implement a method that returns an Optional<String> and handles null
//values gracefully using orElse() and ifPresent().

    public static void main(String[] args) {
        // Test cases
        printGreeting("Ajay");
        printGreeting(null);

    }

    // Method that returns an Optional<String>
    public static Optional<String> getGreeting(String name) {
        return Optional.ofNullable(name).map(n -> "Hello, " + n + "!");
    }

    // Method that handles the Optional gracefully
    public static void printGreeting(String name) {
        Optional<String> greeting = getGreeting(name);

        // Use ifPresent to perform an action if the value is present
        greeting.ifPresent(System.out::println);

        // Use orElse to provide a fallback if the value is absent
        String fallbackMessage = greeting.orElse("Hello, Guest!");
        System.out.println(fallbackMessage);



    }
}
