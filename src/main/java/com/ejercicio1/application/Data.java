package com.ejercicio1.application;

import com.ejercicio1.domain.Person;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Data {

    private int incorrectLine = 0;
    private int lineNumber = 0;
    private final List<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        people.add(person);
    }

    public void increaseIncorrectLines() {
        incorrectLine++;
    }

    public void increaseLineNumber() {
        lineNumber++;
    }
}
