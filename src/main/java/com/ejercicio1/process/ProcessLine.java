package com.ejercicio1.process;

import com.ejercicio1.Person;
import com.ejercicio1.exceptions.InvalidLineFormatException;

import static com.ejercicio1.validations.Validator.validarEdad;
import static com.ejercicio1.validations.Validator.validarNombre;

public class ProcessLine {

    public static Person procesarLinea(String linea, int numeroLinea) throws InvalidLineFormatException {
        String[] partes = linea.split(":");

        // Validación: debe haber entre 1 y 3 campos
        if (partes.length < 1 || partes.length > 3) {
            throw new InvalidLineFormatException(numeroLinea, "Debe tener entre 1 y 3 campos separados por :");
        }

        String name = partes[0].trim();
        validarNombre(name, numeroLinea);

        String town = partes.length > 1 ? partes[1].trim() : ""; // Ciudad opcional
        int age = 0; // Edad por defecto
        if (partes.length > 2) {
            age = Integer.parseInt(partes[2].trim());
            validarEdad(age, numeroLinea);
        }

        return new Person(name, town, age);
    }
}
