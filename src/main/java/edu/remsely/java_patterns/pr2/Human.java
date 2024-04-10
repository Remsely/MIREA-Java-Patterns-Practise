package edu.remsely.java_patterns.pr2;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Human {
    private final int age;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final int weight;
}
