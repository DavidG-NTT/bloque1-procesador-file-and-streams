package com.ejercicio1;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Clase para representar a una persona con su nombre, ciudad y edad. Se utiliza Lombok para generar
 * el constructor y el método toString.
 */
@AllArgsConstructor
@ToString
public class Person {
    private String name;
    private String town;
    private int age;
}
