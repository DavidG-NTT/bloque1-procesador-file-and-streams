package com.ejercicio1.application;

import com.ejercicio1.shared.exceptions.InvalidLineFormatException;

public class Validator {

    public static void validateName(String name, int numberLine) throws InvalidLineFormatException {
        if (name.trim().isEmpty()) {
            throw new InvalidLineFormatException(numberLine, "The name cannot be empty");
        }
    }

    public static void validateAge(int age, int numberLine) throws InvalidLineFormatException {
        try {
            if (age < 0) {
                throw new InvalidLineFormatException(numberLine, "Age cannot be negative");
            }
        } catch (NumberFormatException e) {
            throw new InvalidLineFormatException(numberLine, "The age must be an integer");
        }
    }
}
