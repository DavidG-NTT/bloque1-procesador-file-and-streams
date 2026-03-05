package com.ejercicio1.application;

import com.ejercicio1.domain.Person;

public class FiltersMain {

    public static void filtersStream(Data data) {
        Filters.filterMinors25(data);
        Filters.eliminatePersonWithStartNameA(data);
        Filters.firstPersonWithCity(data, "Barcelona");
    }

    public static void formatImpression(Person p) {
        System.out.println(STR."Name: \{p.getName()}. Town: \{p.getTown().trim().isEmpty() ? "unknown" : p.getTown().trim()}. Age: \{p.getAge() == 0 ? "unknown" : p.getAge()}");
    }
}