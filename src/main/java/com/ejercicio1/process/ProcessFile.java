package com.ejercicio1.process;

import static com.ejercicio1.validations.ComprobateLine.comprobarLinea;

import com.ejercicio1.Datos;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ProcessFile {

    public static void procesarArchivo(String rutaArchivo) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));
            for (String linea : lineas) {
                Datos.incrementarNumeroLineas();

                // Saltar líneas vacías
                if (linea.trim().isEmpty()) {
                    continue;
                }

                comprobarLinea(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
