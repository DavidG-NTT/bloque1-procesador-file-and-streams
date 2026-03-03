package com.ejercicio1.infrastructure;

import com.ejercicio1.application.Data;
import com.ejercicio1.domain.Person;
import com.ejercicio1.domain.exceptions.InvalidLineFormatException;

public class ComprobateLine {

    public static void comprobarLinea(String linea, Data datos) {
        try {
            Person persona = ProcessLine.procesarLinea(linea, datos.getNumeroLinea());
            datos.agregarPersona(persona);
            System.out.println("Linea " + datos.getNumeroLinea() + ": " + persona);

        } catch (InvalidLineFormatException e) {
            System.out.println(e.getMessage());
            datos.incrementarLineasIncorrectas();
        }
    }
}
