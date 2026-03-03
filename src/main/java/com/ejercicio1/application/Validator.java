package com.ejercicio1.application;

import com.ejercicio1.domain.exceptions.InvalidLineFormatException;

public class Validator {

    public static void validarNombre(String name, int numeroLinea) throws InvalidLineFormatException {
        if (name.trim().isEmpty()) {
            throw new InvalidLineFormatException(numeroLinea, "El nombre no puede estar vacío");
        }
    }

    public static void validarEdad(int age, int numeroLinea) throws InvalidLineFormatException {
        try {
            if (age < 0) {
                throw new InvalidLineFormatException(numeroLinea, "La edad no puede ser negativa");
            }
        } catch (NumberFormatException e) {
            throw new InvalidLineFormatException(numeroLinea, "La edad debe ser un número entero");
        }
    }
}
