//La ruta a utilizar es: "block1-process-file-and-streams\src\main\resources\people.csv"

package org.example;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String nameCsv = "block1-process-file-and-streams\\src\\main\\resources\\people.csv";
        try {
            List<Person> people = readCsv(nameCsv);
            System.out.println("People age > 25:");
            filterPeople(people, p -> p.getAge() > 0 && p.getAge() < 25)
                    .forEach(p -> System.out.println("Name: " + p.getName() + ". Town: " + p.getTown() + ". Age: " + p.getAge()));
            System.out.println();

            System.out.println("People nombre empieza por A:");
            filterPeople(people, p -> !p.getName().startsWith("A"))
                    .forEach(p -> System.out.println("Name: " + p.getName() + ". Town: " + p.getTown() + ". Age: " + p.getAge()));
            System.out.println();

            System.out.println("People town = Madrid:");
            people.stream()
                    .filter(p -> p.getTown().equals("Madrid"))
                    .findFirst()
                    .ifPresent(p -> System.out.println("Name: " + p.getName() + ". Town: " + p.getTown() + ". Age: " + p.getAge()));
            System.out.println();

            System.out.println("Primera persona de People con Town = Barcelona:");
            people.stream()
                    .filter(p -> p.getTown().equals("Barcelona"))
                    .findFirst()
                    .ifPresent(p -> System.out.println("Name: " + p.getName() + ". Town: " + p.getTown() + ". Age: " + p.getAge()));
            System.out.println();

        } catch (IOException | InvalidLineFormatException e) {
            System.err.println("Error del documento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public class InvalidLineFormatException extends Exception {
        public InvalidLineFormatException() {
            super("La línea es inválida");
        }

        public InvalidLineFormatException(String line, Exception e) {
            super(line);
        }

    }

    public static List<Person> readCsv(String filename) throws IOException, InvalidLineFormatException {
        List<Person> people = new ArrayList<>();
        BufferedReader reader = Files.newBufferedReader(Paths.get(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                String[] fields = line.split(":");
                String name = fields[0].trim();
                String town = fields.length > 1 ? fields[1].trim() : "unknown";
                int age = fields.length > 2 && !fields[2].trim().isEmpty() ? Integer.parseInt(fields[2].trim()) : 0;
                if (age == 0) {
                    age = -1;
                }
                people.add(new Person(name, town, age));
            } catch (Exception e) {
                // No he conseguido trabajar con la excepción
                //throw new InvalidLineFormatException(line, e);
                System.out.println("prueba");
            }
        }
        return people;
    }

    public interface PersonFilter {
        boolean test(Person p);
    }

    public static List<Person> filterPeople(List<Person> people, PersonFilter filter) {
        return people.stream()
                .filter(filter::test)
                .toList();
    }


}