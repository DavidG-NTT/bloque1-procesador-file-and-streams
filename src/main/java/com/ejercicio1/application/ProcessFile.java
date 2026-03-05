package com.ejercicio1.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ProcessFile {

    public static void processFile(String filePath, Data data) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            for (String line : lines.toList()) {
                data.increaseLineNumber();

                // Skip línes empty
                if (line.trim().isEmpty()) {
                    continue;
                }

                ComprobateLine.comprobateLine(line, data);
            }
        } catch (IOException e) {
            System.out.println(STR."Error reading the file: \{e.getMessage()}");
        }
    }
}
