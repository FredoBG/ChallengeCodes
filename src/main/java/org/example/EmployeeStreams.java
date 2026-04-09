package org.example;

import org.example.util.EmployeeDTO;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeStreams {
    List<EmployeeDTO> employees;

    public EmployeeStreams() {
        this.employees = List.of(
                new EmployeeDTO("1", "Juan", "Perez", LocalDate.of(1990, 5, 10), new BigDecimal("4500.50")),
                new EmployeeDTO("2", "Maria", "Gomez", LocalDate.of(1985, 3, 22), new BigDecimal("6200.00")),
                new EmployeeDTO("3", "Carlos", "Lopez", LocalDate.of(1992, 7, 15), new BigDecimal("3100.75")),
                new EmployeeDTO("4", "Ana", "Martinez", LocalDate.of(1988, 11, 30), new BigDecimal("7200.10")),
                new EmployeeDTO("5", "Luis", "Hernandez", LocalDate.of(1995, 1, 5), new BigDecimal("2800.00")),
                new EmployeeDTO("6", "Sofia", "Ramirez", LocalDate.of(1993, 9, 18), new BigDecimal("5400.60")),
                new EmployeeDTO("7", "Diego", "Torres", LocalDate.of(1980, 6, 25), new BigDecimal("8000.00")),
                new EmployeeDTO("8", "Elena", "Flores", LocalDate.of(1998, 4, 12), new BigDecimal("2600.40")),
                new EmployeeDTO("9", "Jorge", "Castro", LocalDate.of(1987, 12, 3), new BigDecimal("4700.00")),
                new EmployeeDTO("10", "Lucia", "Vargas", LocalDate.of(1991, 8, 27), new BigDecimal("5100.90"))
        );
    }

    public void StreamExamples() {
        System.out.println("Filter employees by salary > 5000");
        List<EmployeeDTO> result = employees.stream()
                .filter(e -> e.getSalary().compareTo(new BigDecimal("5000")) > 0)
                .toList();
        printListEmployees(result);

        System.out.println("Get a list of full names");
        List<String> names = employees.stream()
                .map(e -> e.getFirstName() + " " + e.getLastName())
                .toList();
        printListStrings(names);

        System.out.println("Find employee with highest salary");
        Optional<EmployeeDTO> maxSalary = employees.stream()
                .max(Comparator.comparing(EmployeeDTO::getSalary));
        printListEmployees(List.of(maxSalary.get()));

        System.out.println("Find average salary");
        double avg = employees.stream()
                .map(EmployeeDTO::getSalary)
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .orElse(0.0);
        System.out.println("Average salary: " + avg);

        System.out.println("Find number of employees above 3000 salary");
        long above3k = employees.stream()
                .filter(e -> e.getSalary().compareTo(new BigDecimal("3000")) > 0)
                .count();
        System.out.println("Employees above 3000 salary: " + above3k);

        System.out.println("Sort by salary (descending)");
        List<EmployeeDTO> sorted = employees.stream()
                .sorted(Comparator.comparing(EmployeeDTO::getSalary).reversed())
                .toList();
        printListEmployees(sorted);

        System.out.println("Group by something (Ex. birth year)");
        Map<Integer, List<EmployeeDTO>> grouped = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getBirthDate().getYear()));
        grouped.forEach((year, list) -> {
            System.out.println("Year: " + year);
            list.forEach(e -> System.out.println("  " + e));
        });

        System.out.println("Find the oldest employee");
        Optional<EmployeeDTO> oldest = employees.stream()
                .min(Comparator.comparing(EmployeeDTO::getBirthDate));
        printListEmployees(List.of(oldest.get()));

        System.out.println("Get total salary (reduce)");
        BigDecimal total = employees.stream()
                .map(EmployeeDTO::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total salary: " + total);
    }

    private void printListEmployees(List<EmployeeDTO> employees) {
        employees.stream().forEach(System.out::println);
        System.out.println("");
    }

    private void printListStrings(List<String> employees) {
        employees.stream().forEach(System.out::println);
        System.out.println("");
    }
}
