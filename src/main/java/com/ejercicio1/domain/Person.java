package com.ejercicio1.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Class to represent a person with their name, city, and age. Lombok is used to generate
 * the constructor, the toString method and Getter.
 */
@AllArgsConstructor
@ToString
@Getter
public class Person {
    private String name;
    private String town;
    private int age;
}
