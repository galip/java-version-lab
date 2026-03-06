package io.github.galip.javaversionlab.v10.immutablecollections;

import java.util.*;
import java.util.stream.Collectors;

public class UnmodifiableCollectionsDemo {
    public static void main(String args[]) {

        List<String> originalList = new ArrayList<>();
        originalList.add("Java");
        originalList.add("Go");

        List<String> immutableCopyList = List.copyOf(originalList);
        System.out.println("Immutable copy list: " + immutableCopyList);

        // immutableCopyList.add("C++"); // UnsupportedOperationException

        List<String> users = Arrays.asList("Mehmet", "Zeynep", "Ayşe")
                        .stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toUnmodifiableList());

        System.out.println("Unmodifiable stream: " + users);

        // users.add("XYZ"); // UnsupportedOperationException

        Map<String, String> bookMap = Map.of(
                "Fathers And Sons","Turgenyev",
                "The Lily Of The Valley", "Balzac"
        );

        // bookMap.put("book3", "author3"); // UnsupportedOperationException

        Map<String, String> immutablemap = Map.copyOf(bookMap);
        System.out.println("Immutable map: " + immutablemap);

        // immutablemap.put("book3", "author3"); // UnsupportedOperationException


        Map<String, String> modifiable = new HashMap<>();
        modifiable.put("A", "X");

        Map<String, String> unmodifiableView = Collections.unmodifiableMap(modifiable);
        System.out.println("Before change: " + unmodifiableView);

        modifiable.put("B", "Y");
        System.out.println("After change: " + unmodifiableView);


        // unmodifiableView.put("C", "V"); // UnsupportedOperationException

    }
}

/*
Immutable copy list: [Java, Go]
Unmodifiable stream: [MEHMET, ZEYNEP, AYŞE]
Immutable map: {The Lily Of The Valley=Balzac, Fathers And Sons=Turgenyev}
Before change: {A=X}
After change: {A=X, B=Y}
*/