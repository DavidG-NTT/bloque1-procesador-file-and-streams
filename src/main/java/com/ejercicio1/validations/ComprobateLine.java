package com.ejercicio1.validations;

import static com.ejercicio1.process.ProcessLine.procesarLinea;

import com.ejercicio1.Datos;
import com.ejercicio1.Person;
import com.ejercicio1.exceptions.InvalidLineFormatException;
import java.util.List;

public class ComprobateLine {

    public static void comprobarLinea(String linea, List<Person> personas) {
        try {
            Person persona = procesarLinea(linea, Datos.getNumeroLinea());
            Datos.agregarPersona(persona);
            System.out.println("Linea " + Datos.getNumeroLinea() + ": " + persona);

        } catch (InvalidLineFormatException e) {
            System.out.println(e.getMessage());
            Datos.incrementarLineasIncorrectas();
        }
    }
}
