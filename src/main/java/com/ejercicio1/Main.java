package com.ejercicio1;

import com.ejercicio1.application.Data;
import com.ejercicio1.application.FilteringStream;
import com.ejercicio1.infrastructure.ProcessFile;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nLECTURA DEL FICHERO CSV");
        validateArgs(args);
        Data datos = new Data();
        ProcessFile.procesarArchivo(args[0], datos);

        // Imprimir resultados
        System.out.println("\n--- Resumen ---");
        System.out.println("Total de personas cargadas correctamente: " + datos.getPersonas().size());
        System.out.println("Total de líneas incorrectas: " + datos.getLineasIncorrectas());

        // Filtrar y mostrar resultados usando
        System.out.println("\n\nFILTROS CON STREAMS");
        FilteringStream.filtrosStreams(datos);
    }

    public static void validateArgs(String[] args) {
        if (args.length == 0) {
            System.out.println("No se han proporcionado argumentos.");
            System.exit(1);
        }
    }
}