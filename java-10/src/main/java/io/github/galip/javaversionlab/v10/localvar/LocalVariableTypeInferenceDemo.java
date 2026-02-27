package io.github.galip.javaversionlab.v10.localvar;

import java.util.List;
import java.util.stream.Collectors;

// JEP 286: Local-Variable Type Inference
public class LocalVariableTypeInferenceDemo {
    public static void main(String args[]) {

        var message = "hello java 10"; // String
        var number = 23; // int
        var price = 23.12; // double

        var upperMessage = message.toUpperCase();
        var doubledNumber = number * 2.0; // double (int * double = double)
        var totalPrice = price * number;

        System.out.println("message class name: " + message.getClass().getName());
        System.out.println("number class name: " + ((Object) number).getClass().getName()); // Primitive types have no runtime class, boxing happens here.
        System.out.println("price class name: " + ((Object) price).getClass().getName()); // Primitive types have no runtime class, boxing happens here.

        System.out.println("Message: " + message + " -> Upper: " + upperMessage);
        System.out.println("Number: " + number + " -> Doubled: " + doubledNumber);
        System.out.println("Price: " + price + " -> Total: " + totalPrice);

        // primitive types & wrapper types
        var primitiveInt = 10;      // int
        var wrapperInt = Integer.valueOf(10); // Integer

        // System.out.println("primitiveInt class name: " + primitiveInt.getClass().getName()); // primitive int has no class
        System.out.println("wrapperInt class name: " + wrapperInt.getClass().getName());

        System.out.println(primitiveInt);
        System.out.println(wrapperInt);

        // Collection + Stream
        var students = List.of(
                new User(1L, "Ahmet", 28, true),
                new User(2L, "Ayşe", 17, true),
                new User(3L, "Mehmet", 21, false),
                new User(4L, "Zeynep", 22, true)
        ); // List<User>

        var activeStudents = students.stream()
                .filter(u -> u.isActive() && u.getAge() >= 18)
                .collect(Collectors.toList());

        for (var student : activeStudents) {
            System.out.println("Student: " + student.getName());
        }

        var studentMap = students.stream()
                .collect(Collectors.toMap(
                        User::getId,
                        User::getName
                )); // Map<Long, String>

        // Map.Entry loop
        for (var entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Optional<User>
        var oneActiveStudent = students.stream()
                .filter(User::isActive)
                .findFirst();

        oneActiveStudent.ifPresent(
                s -> System.out.println("Active Student: " + s)
        );

    }

    static class User {
        private Long id;
        private String name;
        private int age;
        private boolean active;

        public User(Long id, String name, int age, boolean active) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.active = active;
        }

        public Long getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public boolean isActive() { return active; }

        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
}

/*
message class name: java.lang.String
number class name: java.lang.Integer
price class name: java.lang.Double
Message: hello java 10 -> Upper: HELLO JAVA 10
Number: 23 -> Doubled: 46.0
Price: 23.12 -> Total: 531.76
wrapperInt class name: java.lang.Integer
10
10
Student: Ahmet
Student: Zeynep
1 -> Ahmet
2 -> Ayşe
3 -> Mehmet
4 -> Zeynep
Active Student: Ahmet(28)
 */
