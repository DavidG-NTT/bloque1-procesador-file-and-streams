import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No se han proporcionado argumentos.");
            return;
        }

        List<Person> personas = new ArrayList<>();
        int lineasCorrectas = 0;
        int lineasIncorrectas = 0;
        int numeroLinea = 0;

        try {
            List<String> lineas = Files.readAllLines(Paths.get(args[0]));

            for (String linea : lineas) {
                numeroLinea++;

                // Saltar líneas vacías
                if (linea.trim().isEmpty()) {
                    continue;
                }

                try {
                    Person persona = procesarLinea(linea, numeroLinea);
                    personas.add(persona);
                    System.out.println("Línea " + numeroLinea + ": " + persona);
                    lineasCorrectas++;
                } catch (InvalidLineFormatException e) {
                    System.out.println(e.getMessage());
                    lineasIncorrectas++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Imprimir resultados
        System.out.println("\n--- Resumen ---");
        System.out.println("Total de personas cargadas correctamente: " + lineasCorrectas);
        System.out.println("Total de líneas incorrectas: " + lineasIncorrectas);
    }

    private static Person procesarLinea(String linea, int numeroLinea) throws InvalidLineFormatException {
        String[] partes = linea.split(":");

        // Validación: debe haber entre 1 y 3 campos
        if (partes.length < 1 || partes.length > 3) {
            throw new InvalidLineFormatException("Línea " + numeroLinea + ": Formato inválido. " +
                    "Esperado: name:town:age (Recibido: " + linea + ")");
        }

        // El primer campo (name) es obligatorio y no puede estar vacío
        String name = partes[0].trim();
        if (name.isEmpty()) {
            throw new InvalidLineFormatException("Línea " + numeroLinea + ": El campo 'name' es obligatorio y no puede estar vacío. " +
                    "(Recibido: " + linea + ")");
        }

        // El segundo campo (town) es opcional
        String town = "";
        if (partes.length > 1) {
            town = partes[1].trim();
        }

        // El tercer campo (age) es opcional, por defecto 0
        int age = 0;
        if (partes.length > 2) {
            String ageStr = partes[2].trim();
            if (!ageStr.isEmpty()) {
                try {
                    age = Integer.parseInt(ageStr);
                    if (age < 0) {
                        throw new InvalidLineFormatException("Línea " + numeroLinea + ": La edad no puede ser negativa. " +
                                "(Recibido: " + linea + ")");
                    }
                } catch (NumberFormatException _) {
                    throw new InvalidLineFormatException("Línea " + numeroLinea + ": La edad no es un número válido. " +
                            "(Recibido: " + linea + ")");
                }
            }
        }

        return new Person(name, town, age);
    }
}
