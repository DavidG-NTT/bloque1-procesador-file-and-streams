package com.ejercicio1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Datos {

    private Datos() {}

    @Getter
    private static int lineasIncorrectas = 0;
    @Getter
    private static final List<Person> personas = new ArrayList<>();
    @Getter
    private static int numeroLinea = 0;

    public static void agregarPersona(Person persona) {
        personas.add(persona);
    }

    public static void incrementarLineasIncorrectas() {
        lineasIncorrectas++;
    }

    public static void incrementarNumeroLineas() {
        numeroLinea++;
    }
}
