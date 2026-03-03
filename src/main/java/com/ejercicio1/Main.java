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
    }

    public static void validateArgs(String[] args) {
        if (args.length == 0) {
            System.out.println("No se han proporcionado argumentos.");
            System.exit(1);
        }
    }
}