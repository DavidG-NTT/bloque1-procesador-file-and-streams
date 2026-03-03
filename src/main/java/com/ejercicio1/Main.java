package com.ejercicio1;

import static com.ejercicio1.process.ProcessFile.procesarArchivo;

public class Main {

    public static void main(String[] args) {
        validateArgs(args);

        procesarArchivo(args[0]);

        // Imprimir resultados
        System.out.println("\n--- Resumen ---");
        System.out.println("Total de personas cargadas correctamente: " + Datos.getPersonas().size());
        System.out.println("Total de líneas incorrectas: " + Datos.getLineasIncorrectas());
    }

    public static void validateArgs(String[] args) {
        if (args.length == 0) {
            System.out.println("No se han proporcionado argumentos.");
            System.exit(1);
        }
    }
}