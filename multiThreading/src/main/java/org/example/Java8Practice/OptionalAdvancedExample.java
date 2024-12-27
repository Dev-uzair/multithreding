package org.example.Java8Practice;

import java.util.Optional;

public class OptionalAdvancedExample {
    public static void main(String[] args) {

        User userWithValidEmail = new User("Ajay", new Profile("ajay@example.com"));
        processUser(userWithValidEmail);


        User userWithNullEmail = new User("Ajay", new Profile(null));
        processUser(userWithNullEmail);


        User userWithNullProfile = new User("Ajay", null);
        processUser(userWithNullProfile);


        processUser(null);
    }

    public static void processUser(User user) {

        Optional<User> optionalUser = Optional.ofNullable(user);


        Optional<String> email = optionalUser
                .map(User::getProfile)                // Extract the profile
                .flatMap(Profile::getEmail)          // Extract the email, handling nulls
                .filter(e -> e.endsWith("@example.com")); // Filter for valid domain


        email.ifPresentOrElse(
                e -> System.out.println("Valid email: " + e),
                () -> System.out.println("No valid email found.")
        );
    }
}

// User class
class User {
    private String name;
    private Profile profile;

    public User(String name, Profile profile) {
        this.name = name;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public Profile getProfile() {
        return profile;
    }
}

// Profile class
class Profile {
    private String email;

    public Profile(String email) {
        this.email = email;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}
