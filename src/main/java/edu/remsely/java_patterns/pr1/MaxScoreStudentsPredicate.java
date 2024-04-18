package edu.remsely.java_patterns.pr1;

import lombok.Data;

import java.util.Arrays;
import java.util.function.Predicate;

public class MaxScoreStudentsPredicate implements Predicate<Student[]> {
    public static void main(String[] args) {
        Student[] students1 = {
                new Student(90),
                new Student(70),
                new Student(100)
        };

        Student[] students2 = {
                new Student(90),
                new Student(70),
                new Student(50)
        };

        Predicate<Student[]> predicate = new MaxScoreStudentsPredicate();
        System.out.println(predicate.test(students1));
        System.out.println(predicate.test(students2));
    }

    @Override
    public boolean test(Student[] students) {
        return Arrays.stream(students)
                .anyMatch(student -> student.getScore() == 100);
    }
}

@Data
class Student {
    private final int score;
}