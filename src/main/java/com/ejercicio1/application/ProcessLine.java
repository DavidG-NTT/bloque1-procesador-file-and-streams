package com.ejercicio1.application;

import com.ejercicio1.domain.Person;
import com.ejercicio1.shared.exceptions.InvalidLineFormatException;

public class ProcessLine {

    public static Person processLine(String line, int numberLine) throws InvalidLineFormatException {
        String[] parts = line.split(":", -1);

        // Validation: there must be between 1 and 3 fields
        if (parts.length < 1 || parts.length > 3) {
            throw new InvalidLineFormatException(numberLine, "It must have between 1 and 3 fields separated by :");
        }

        String name = parts[0].trim();
        Validator.validateName(name, numberLine);

        String town = parts.length > 1 ? parts[1].trim() : ""; // Optional city
        int age = 0; // Default age
        if (parts.length > 2) {
            age = Integer.parseInt(parts[2].trim());
            Validator.validateAge(age, numberLine);
        }

        return new Person(name, town, age);
    }
}
