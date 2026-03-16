package io.github.galip.javaversionlab.v11.lambdavar;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaVarDemo {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1L, "John"),
                new User(2L, "Jane"),
                new User(3L, "Bob")
        );

        // Using lambda with var
        users.forEach((var user) ->
                 System.out.println("User name: " + user.getName())
        );


        // Using lambda with var in stream
        List<String> names =
                users.stream()
                        .map((var user) -> user.getName().toUpperCase())
                        .collect(Collectors.toList());

        System.out.println("Uppercase names: " + names);

        // Using lambda with var and annotation
        List<String> invalidNames = Arrays.asList("Zeynep", null, "Ahmet");

        invalidNames.forEach((@NotNull var name) -> {
            validateNotNull(name);
            System.out.println("Name: " + name);
        });
    }

    public static void validateNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Parameter cannot be null");
        }
    }

    static class User {

        private Long id;
        private String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NotNull {
    }
}

/*
User name: John
User name: Jane
User name: Bob
Uppercase names: [JOHN, JANE, BOB]
Name: Zeynep
Exception in thread "main" java.lang.IllegalArgumentException: Parameter cannot be null
 */