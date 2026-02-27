package com.ejercicio1.exceptions;

/**
 * Excepción para cuando una línea del CSV no cumple con el formato (name:town:age)
 */
public class InvalidLineFormatException extends Exception {
    public InvalidLineFormatException(int numeroLinea, String motivo) {
        super("Linea " + numeroLinea + ": " + motivo);
    }
}