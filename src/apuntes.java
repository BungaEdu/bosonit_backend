import java.util.ArrayList;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class apuntes {
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
                    age = -1; // Mark as unknown age
                }
                people.add(new Person(name, town, age));
            } catch (Exception e) {
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

    public static void main(String[] args) {
        String filename = "block1-process-file-and-streams\\src\\main\\resources\\people.csv";
        try {
            List<Person> people = readCsv(filename);
            System.out.println("People younger than 25 years old:");
            filterPeople(people, p -> p.getAge() > 0 && p.getAge() < 25)
                    .forEach(p -> System.out.println("Name: " + p.getName() + ". Town: " + p.getTown() + ". Age: " + p.getAge()));
            System.out.println();

            System.out.println("People whose name does not start with A:");
            filterPeople(people, p -> !p.getName().startsWith("A"))
                    .forEach(p -> System.out.println("Name: " + p.getName() + ". Town: " + p.getTown() + ". Age: " + p.getAge()));
            System.out.println();

            System.out.println("First person from Madrid:");
            people.stream()
                    .filter(p -> p.getTown().equals("Madrid"))
                    .findFirst()
                    .ifPresent(p -> System.out.println("Name: " + p.getName() + ". Town: " + p.getTown() + ". Age: " + p.getAge()));
            System.out.println();

            System.out.println("First person from Barcelona:");
            people.stream()
                    .filter(p -> p.getTown().equals("Barcelona"))
                    .findFirst()
                    .ifPresent(p -> System.out.println("Name: " + p.getName() + ". Town: " + p.getTown() + ". Age: " + p.getAge()));
            System.out.println();

        } catch (IOException | InvalidLineFormatException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

class Person {

    private final String name;
    private final String town;
    private final int age;

    public Person(String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public Integer getAge() {
        return age;
    }
}

