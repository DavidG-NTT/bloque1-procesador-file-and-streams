package com.ejercicio1;

import com.ejercicio1.application.Data;
import com.ejercicio1.infrastructure.ProcessFile;

public class Main {

    public static void main(String[] args) {
        validateArgs(args);
        Data datos = new Data();
        ProcessFile.procesarArchivo(args[0], datos);

        // Imprimir resultados
        System.out.println("\n--- Resumen ---");
        System.out.println("Total de personas cargadas correctamente: " + datos.getPersonas().size());
        System.out.println("Total de líneas incorrectas: " + datos.getLineasIncorrectas());

        filtrosStreams(datos);
    }

    public static void validateArgs(String[] args) {
        if (args.length == 0) {
            System.out.println("No se han proporcionado argumentos.");
            System.exit(1);
        }
    }

    public static void filtrosStreams(Data datos) {
        System.out.println("\n--- Personas menores de 25 años ---");
         datos.getPersonas().stream()
                .filter(p -> p.getAge() < 25 && p.getAge() != 0)
                .forEach(p ->
                        System.out.println("Name: " + p.getName() +
                                ". Town: " + (p.getTown().trim().isEmpty() ? "unknown" : p.getTown().trim()) +
                                ". Age: " + p.getAge())
                );

        System.out.println("\n--- Eliminar personas cuyo nombre empieza por “A” ---");
        datos.getPersonas().stream()
                .filter(p -> !p.getName().startsWith("A"))
                .forEach(p ->
                        System.out.println("Name: " + p.getName() +
                                ". Town: " + (p.getTown().trim().isEmpty() ? "unknown" : p.getTown().trim()) +
                                ". Age: " + (p.getAge() == 0 ? "unknown" : p.getAge()))
                );

        System.out.println("\n --- Buscar la primera persona con ciudad “Madrid” ---");
        datos.getPersonas().stream()
                .filter(p -> p.getAge() < 25 && p.getAge() != 0)
                .filter(p -> p.getTown().equalsIgnoreCase("Madrid"))
                .findFirst()
                .ifPresentOrElse(p ->
                        System.out.println("Name: " + p.getName() +
                                ". Town: " + (p.getTown().trim().isEmpty() ? "unknown" : p.getTown().trim()) +
                                ". Age: " + p.getAge()),
                        () -> System.out.println("No se encontró ninguna persona menor de 25 años en Madrid")
                );

        System.out.println("\n --- Buscar la primera persona con ciudad “Barcelona” ---");
        datos.getPersonas().stream()
                .filter(p -> p.getAge() < 25 && p.getAge() != 0)
                .filter(p -> p.getTown().equalsIgnoreCase("Barcelona"))
                .findFirst()
                .ifPresentOrElse(p ->
                                System.out.println("Name: " + p.getName() +
                                        ". Town: " + (p.getTown().trim().isEmpty() ? "unknown" : p.getTown().trim()) +
                                        ". Age: " + p.getAge()),
                        () -> System.out.println("No se encontró ninguna persona menor de 25 años en Barcelona")
                );
    }
}