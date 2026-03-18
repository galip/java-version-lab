package io.github.galip.javaversionlab.v11.singlefilesource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class SingleFileSourceDemo {

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("Usage: java SingleFileSourceDemo.java <log-file>");
            return;
        }

        Path logPath = Path.of(args[0]);

        if (!Files.exists(logPath)) {
            System.out.println("File not found: " + logPath);
            return;
        }

        List<String> lines = Files.readAllLines(logPath);

        System.out.println("Total lines: " + lines.size());

        long errorCount = lines.stream()
                .filter(line -> line.contains("ERROR"))
                .count();

        System.out.println("ERROR count: " + errorCount);

        long warnCount = lines.stream()
                .filter(line -> line.contains("WARN"))
                .count();

        System.out.println("WARN count: " + warnCount);

        Map<String, Long> errorMessages =
                lines.stream()
                        .filter(line -> line.contains("ERROR"))
                        .map(SingleFileSourceDemo::extractMessage)
                        .collect(Collectors.groupingBy(
                                msg -> msg,
                                Collectors.counting()
                        ));

        System.out.println("\nTop ERROR messages:");
        errorMessages.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry ->
                        System.out.println(entry.getKey() + " -> " + entry.getValue())
                );

        Set<String> ips = lines.stream()
                .map(SingleFileSourceDemo::extractIp)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        System.out.println("\nUnique IP count: " + ips.size());

    }


    private static String extractMessage(String line) {
        int index = line.indexOf("ERROR");
        return index != -1 ? line.substring(index) : "UNKNOWN";
    }

    private static String extractIp(String line) {
        String[] parts = line.split(" ");
        for (String part : parts) {
            if (part.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) {
                return part;
            }
        }
        return null;
    }
}