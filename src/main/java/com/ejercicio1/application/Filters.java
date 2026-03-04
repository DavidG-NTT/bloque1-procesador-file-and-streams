package com.ejercicio1.application;


public class Filters {

    public static void filtroMenores25(Data datos) {
        System.out.println("\n--- Personas menores de 25 años ---");
        datos.getPersonas().stream()
                .filter(p -> p.getAge() < 25 && p.getAge() != 0)
                .forEach(p -> FiltersMain.formatoImpresion(p)); // Se puede usar tambien: .forEach(FiltersMain::formatoImpresion);
    }

    public static void eliminarPersonasConNombreA(Data datos) {
        System.out.println("\n--- Eliminar personas cuyo nombre empieza por 'A' ---");
        datos.getPersonas().stream()
                .filter(p -> !p.getName().startsWith("A"))
                .forEach(p -> FiltersMain.formatoImpresion(p));
    }

    public static void primeraPersonaConCiudadMadrid(Data datos) {
        System.out.println("\n--- Buscar la primera persona con ciudad 'Madrid' ---");
        datos.getPersonas().stream()
                .filter(p -> p.getAge() < 25 && p.getAge() != 0)
                .filter(p -> p.getTown().equalsIgnoreCase("Madrid"))
                .findFirst()
                .ifPresentOrElse(
                        p -> FiltersMain.formatoImpresion(p),
                        () -> System.out.println("No se encontró ninguna persona menor de 25 años en Madrid.")
                );
    }

    public static void primeraPersonaConCiudadBarcelona(Data datos) {
        System.out.println("\n--- Buscar la primera persona con ciudad 'Barcelona' ---");
        datos.getPersonas().stream()
                .filter(p -> p.getAge() < 25 && p.getAge() != 0)
                .filter(p -> p.getTown().equalsIgnoreCase("Barcelona"))
                .findFirst()
                .ifPresentOrElse(
                        p -> FiltersMain.formatoImpresion(p),
                        () -> System.out.println("No se encontró ninguna persona menor de 25 años en Barcelona.")
                );
    }
}
