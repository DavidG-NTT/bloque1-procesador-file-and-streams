package com.ejercicio1.infrastructure;

import com.ejercicio1.application.Data;
import com.ejercicio1.application.FiltersMain;
import com.ejercicio1.application.ProcessFile;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nREADING THE CSV FILE");
        validateArgs(args);
        Data data = new Data();
        ProcessFile.processFile(args[0], data);

        // Print results
        System.out.println("\n--- Summary ---");
        System.out.println(STR."Total number of people loaded correctly: \{data.getPeople().size()}");
        System.out.println(STR."Total incorrect lines: \{data.getIncorrectLine()}");

        // Filter and display results using
        System.out.println("\n\nFILTERS WITH STREAMS");
        FiltersMain.filtersStream(data);
    }

    public static void validateArgs(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments have been provided.");
            System.exit(1);
        }
    }
}