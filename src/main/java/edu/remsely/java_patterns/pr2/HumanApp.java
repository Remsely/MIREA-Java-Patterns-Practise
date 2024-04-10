package edu.remsely.java_patterns.pr2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HumanApp {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human(65, "Alice", "Young", LocalDate.of(1955, 2, 3), 60),
                new Human(100, "Bob", "King", LocalDate.of(1924, 5, 15), 80),
                new Human(22, "Charlie", "Arnold", LocalDate.of(1998, 3, 12), 75),
                new Human(28, "Dave", "Brown", LocalDate.of(1992, 8, 23), 85)
        );

        List<Human> sortedByLastSecondNameLetter = sortByLastSecondNameLetter(humans);
        printList(sortedByLastSecondNameLetter);

        List<Human> filteredByAgeMoreThanWeight = filterByAgeMoreThanWeight(sortedByLastSecondNameLetter);
        printList(filteredByAgeMoreThanWeight);

        List<Human> sortedByBirthday = sortByBirthday(filteredByAgeMoreThanWeight);
        printList(sortedByBirthday);

        System.out.println(multiplicationAge(sortedByBirthday));
    }

    public static List<Human> sortByLastSecondNameLetter(List<Human> humans) {
        return humans.stream()
                .sorted(Comparator.comparing(h -> {
                    String lastName = h.getLastName();
                    return lastName.substring(lastName.length() - 1);
                }))
                .collect(Collectors.toList());
    }

    public static List<Human> filterByAgeMoreThanWeight(List<Human> humans) {
        return humans.stream()
                .filter(h -> h.getAge() > h.getWeight())
                .collect(Collectors.toList());
    }

    public static List<Human> sortByBirthday(List<Human> humans) {
        return humans.stream()
                .sorted(Comparator.comparing(Human::getBirthDate))
                .collect(Collectors.toList());
    }

    public static int multiplicationAge(List<Human> humans) {
        return humans.stream().map(Human::getAge).reduce(1, (a, b) -> a * b);
    }

    public static void printList(List<Human> humans) {
        humans.forEach(System.out::println);
        System.out.println();
    }
}
