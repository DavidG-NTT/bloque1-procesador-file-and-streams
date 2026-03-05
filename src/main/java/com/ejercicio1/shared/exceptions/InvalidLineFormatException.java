package com.ejercicio1.shared.exceptions;

/**
 * Exception for when a line of the CSV does not comply with the format (name:town:age)
 */
public class InvalidLineFormatException extends Exception {
    public InvalidLineFormatException(int numberLine, String reason) {
        super(STR."Line \{numberLine}: \{reason}");
    }
}