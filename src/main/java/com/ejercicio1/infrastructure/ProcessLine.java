package com.ejercicio1.infrastructure;

import com.ejercicio1.application.Validator;
import com.ejercicio1.domain.Person;
import com.ejercicio1.domain.exceptions.InvalidLineFormatException;

public class ProcessLine {

    public static Person procesarLinea(String linea, int numeroLinea) throws InvalidLineFormatException {
        String[] partes = linea.split(":", -1); // -1 para incluir campos vacíos

        // Validación: debe haber entre 1 y 3 campos
        if (partes.length < 1 || partes.length > 3) {
            throw new InvalidLineFormatException(numeroLinea, "Debe tener entre 1 y 3 campos separados por :");
        }

        String name = partes[0].trim();
        Validator.validarNombre(name, numeroLinea);

        String town = partes.length > 1 ? partes[1].trim() : ""; // Ciudad opcional
        int age = 0; // Edad por defecto
        if (partes.length > 2) {
            age = Integer.parseInt(partes[2].trim());
            Validator.validarEdad(age, numeroLinea);
        }

        return new Person(name, town, age);
    }
}
