package com.ejercicio1.application;

import com.ejercicio1.domain.Person;
import com.ejercicio1.shared.exceptions.InvalidLineFormatException;

public class ComprobateLine {

    public static void comprobateLine(String line, Data data) {
        try {
            Person person = ProcessLine.processLine(line, data.getLineNumber());
            data.addPerson(person);
            System.out.println(STR."Line \{data.getLineNumber()}: \{person}");

        } catch (InvalidLineFormatException e) {
            System.out.println(e.getMessage());
            data.increaseIncorrectLines();
        }
    }
}
