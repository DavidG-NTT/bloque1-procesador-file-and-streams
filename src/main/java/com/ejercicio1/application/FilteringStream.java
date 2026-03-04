package com.ejercicio1.application;

import com.ejercicio1.domain.Person;

public class FilteringStream {

    public static void formatoImpresion(Person p) {
        System.out.println("Name: " + p.getName() +
                ". Town: " + (p.getTown().trim().isEmpty() ? "unknown" : p.getTown().trim()) +
                ". Age: " + (p.getAge() == 0 ? "unknown" : p.getAge()));
    }

    public static void filtrosStreams(Data datos) {
        System.out.println("\n--- Personas menores de 25 años ---");
        datos.getPersonas().stream()
                .filter(p -> p.getAge() < 25 && p.getAge() != 0)
                .forEach(FilteringStream::formatoImpresion);

        System.out.println("\n--- Eliminar personas cuyo nombre empieza por “A” ---");
        datos.getPersonas().stream()
                .filter(p -> !p.getName().startsWith("A"))
                .forEach(FilteringStream::formatoImpresion);

        System.out.println("\n --- Buscar la primera persona con ciudad “Madrid” ---");
        datos.getPersonas().stream()
                .filter(p -> p.getAge() < 25 && p.getAge() != 0)
                .filter(p -> p.getTown().equalsIgnoreCase("Madrid"))
                .findFirst()
                .ifPresentOrElse(
                        FilteringStream::formatoImpresion,
                        () -> System.out.println("No se encontró ninguna persona menor de 25 años en Madrid")
                );

        System.out.println("\n --- Buscar la primera persona con ciudad “Barcelona” ---");
        datos.getPersonas().stream()
                .filter(p -> p.getAge() < 25 && p.getAge() != 0)
                .filter(p -> p.getTown().equalsIgnoreCase("Barcelona"))
                .findFirst()
                .ifPresentOrElse(
                        FilteringStream::formatoImpresion,
                        () -> System.out.println("No se encontró ninguna persona menor de 25 años en Madrid")
                );
    }
}