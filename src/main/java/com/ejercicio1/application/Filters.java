package com.ejercicio1.application;


public class Filters {

    public static void filterMinors25(Data data) {
        System.out.println("\n--- People under 25 years old ---");
        data.getPeople().stream()
                .filter(p -> p.getAge() < 25 && p.getAge() != 0)
                .forEach(p -> FiltersMain.formatImpression(p)); // It can also be with: .forEach(FiltersMain::formatImpression);
    }

    public static void eliminatePersonWithStartNameA(Data data) {
        System.out.println("\n--- Remove people whose name starts with 'A' ---");
        data.getPeople().stream()
                .filter(p -> !p.getName().startsWith("A"))
                .forEach(p -> FiltersMain.formatImpression(p));
    }

    public static void firstPersonWithCity(Data data, String town) {
        System.out.println("\n--- Search for the first person with city ---");
        data.getPeople().stream()
                .filter(p -> p.getAge() < 25 && p.getAge() != 0)
                .filter(p -> p.getTown().equalsIgnoreCase(town))
                .findFirst()
                .ifPresentOrElse(
                        p -> FiltersMain.formatImpression(p),
                        () -> System.out.println(STR."No person under 25 years old was found in \{town}.")
                );
    }
}
