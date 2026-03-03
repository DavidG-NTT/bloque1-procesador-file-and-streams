package com.ejercicio1.application;

import com.ejercicio1.domain.Person;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Data {

    private int lineasIncorrectas = 0;
    private int numeroLinea = 0;
    private final List<Person> personas = new ArrayList<>();

    public void agregarPersona(Person persona) {
        personas.add(persona);
    }

    public void incrementarLineasIncorrectas() {
        lineasIncorrectas++;
    }

    public void incrementarNumeroLinea() {
        numeroLinea++;
    }
}
