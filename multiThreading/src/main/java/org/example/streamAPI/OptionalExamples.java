package org.example.streamAPI;

import java.util.*;

class User {
    private String name;
    private String email;
    private Address address;

    public User(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public Optional<Address> getAddress() { return Optional.ofNullable(address); }
}

class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
}

public class OptionalExamples {
    public static void main(String[] args) {
        // 1. Creating Optionals
        Optional<String> empty = Optional.empty ( );
        Optional<String> nonEmpty = Optional.of ( "Hello" );
        Optional<String> nullable = Optional.ofNullable ( null );

        // 2. Checking if value is present
//        System.out.println("Is value present: " + nonEmpty.isPresent());  // true
//        System.out.println("Is value empty: " + empty.isEmpty());         // true

        // 3. Getting value with default
        //when our database return no result
//        String value = nonEmpty.orElse("Default");
//        System.out.println("Value or default: " + value);
//
        // 4. Getting value with supplier
        //example cash payment option
//        String valueFromSupplier = nonEmpty.orElseGet(() -> "Computed Default");
//        System.out.println("Value from supplier: " + valueFromSupplier);

//        // 5. Throwing exception if empty
//        try {
//            String optionalIsEmpty = nonEmpty.orElseThrow ( () -> new IllegalStateException ( "Optional is empty" ) );
//            System.out.println ( "optionalIsEmpty = " + optionalIsEmpty );
//        } catch (IllegalStateException e) {
//            System.out.println("Exception caught: " + e.getMessage());
//        }

////        // 6. Filtering values
//        Optional<String> filtered = nonEmpty.filter(s -> s.length() >= 5);
//        System.out.println("Filtered value present: " + filtered.isPresent());

//        // 7. Mapping values
//        Optional<Integer> mapped = empty.map(String::length);
//        System.out.println("Mapped value: " + mapped.orElse(0));
////
////        // 8. Flat mapping
//        Optional<String> flatMapped = nonEmpty.flatMap(s -> Optional.of(s.toUpperCase()));
//        System.out.println("Flat mapped value: " + flatMapped.orElse(""));
////
//        // 9. If Present example
//        nonEmpty.ifPresent(s -> System.out.println("Value is present: " + s));
//
//        // 10. If Present or Else example
//      nonEmpty.ifPresentOrElse(
//                s -> System.out.println("Value: " + s),
//                () -> System.out.println("Value is empty")
//        );
//
//        // 11. Complex example with chaining
//        User user = new User("John", "john@example.com", new Address("123 Main St", "Boston"));
//        User userNoAddress = new User("Jane", "jane@example.com", null);
//
//////        // Getting city safely
//        String city = user.getAddress()
//                .map(Address::getCity)
//                .orElse("Unknown");
//        System.out.println("City: " + city);

//        // 12. Multiple Optional handling
//        Optional<String> opt1 = Optional.of("First");
//        Optional<String> opt2 = Optional.empty();
////
//        String result = opt1.or(() -> opt2).orElse("Default");
//        System.out.println("Result from multiple optionals: " + result);

//        // 13. Stream from Optional
//        Optional<String> optionalString = Optional.of("Hello");
//        List<String> resultList = optionalString.stream()
//                .map(String::toUpperCase)
//                .toList();
//        System.out.println("Stream result: " + resultList);

//        // 14. Combining multiple optionals
//        Optional<String> combinedOptional = Optional.of("Hello")
//                .flatMap(s1 -> Optional.of("World")
//                        .map(s2 -> s1 + " " + s2));
//        System.out.println("Combined optional: " + combinedOptional.orElse(""));
        Optional<User> userById = findUserById ( String.valueOf ( 1 ) );
        System.out.println ( "userById = " + userById.toString () );
    }

        // 15. Optional as method return type
        public static Optional<User> findUserById (String id){
            // Simulating database lookup
            if ( "1" .equals ( id ) ) {
                return Optional.of ( new User ( "John", "john@example.com", null ) );
            }
            return Optional.empty ( );
//        }
    }
}