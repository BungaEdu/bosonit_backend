import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class block1_pruebas2 {

    public class InvalidLineFormatException extends Exception {
        public InvalidLineFormatException() {
            super("La línea es inválida");
        }

        public InvalidLineFormatException(String line, Exception e) {
            super(line);
        }

    }

    public List<Person> readCsv(String filename) throws IOException, InvalidLineFormatException {
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
                throw new InvalidLineFormatException(line, e);
            }
        }
        return people;
    }

    public void main(String[] args) {
        String filename = "block1-process-file-and-streams\\src\\main\\resources\\people.csv";
        try {
            List<Person> people = null;
            people = readCsv(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidLineFormatException e) {
            throw new RuntimeException(e);
        }
    }
        /*System.out.println("People age > 25:");
            filterPeople(people, p -> p.getAge() > 0 && p.getAge() < 25)
                    .forEach(p -> System.out.println("Name: " + p.getName() + ". Town: " + p.getTown() + ". Age: " + p.getAge()));
            System.out.println();*/
}

