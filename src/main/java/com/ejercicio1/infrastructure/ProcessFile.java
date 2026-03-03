package com.ejercicio1.infrastructure;

import com.ejercicio1.application.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ProcessFile {

    public static void procesarArchivo(String rutaArchivo, Data datos) {
        try (Stream<String> lineas = Files.lines(Paths.get(rutaArchivo))) {
            for (String linea : lineas.toList()) {
                datos.incrementarNumeroLinea();

                // Saltar líneas vacías
                if (linea.trim().isEmpty()) {
                    continue;
                }

                ComprobateLine.comprobarLinea(linea, datos);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
