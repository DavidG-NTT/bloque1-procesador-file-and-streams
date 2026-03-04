package com.ejercicio1.application;

import com.ejercicio1.domain.Person;

public class FiltersMain {

    public static void filtrosStreams(Data datos) {
        Filters.filtroMenores25(datos);
        Filters.eliminarPersonasConNombreA(datos);
        Filters.primeraPersonaConCiudadMadrid(datos);
        Filters.primeraPersonaConCiudadBarcelona(datos);
    }

    public static void formatoImpresion(Person p) {
        System.out.println("Name: " + p.getName() +
                ". Town: " + (p.getTown().trim().isEmpty() ? "unknown" : p.getTown().trim()) +
                ". Age: " + (p.getAge() == 0 ? "unknown" : p.getAge()));
    }
}