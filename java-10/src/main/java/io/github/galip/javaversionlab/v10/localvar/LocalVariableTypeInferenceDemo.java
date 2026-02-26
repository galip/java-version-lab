package io.github.galip.javaversionlab.v10.localvar;

import java.util.List;
import java.util.stream.Collectors;

// JEP 286: Local-Variable Type Inference
public class LocalVariableTypeInferenceDemo {
    public static void main(String args[]) {

        var message = "hello java 10"; // String
        var number = 23; // int
        var price = 23.12; // double

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

        for (var entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
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
