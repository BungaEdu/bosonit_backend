package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Persona {
    String name;
    String town;
    String age;

    public Persona(String name, String town, String age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", town='" + town + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static void readFich(String route) throws IOException {
        try {
            Path path = Paths.get(route);
            try {
                String read = "";
                int i = 0;
                while (true) {
                    read = Files.readAllLines(path).get(i);
                    i++;
                    System.out.println(read);
                }
            } catch (Exception e) {
                System.out.println("Fin Fichero");
            }
        } catch (Exception InvalidLineFormatException) {
            System.out.println("Ruta incorrecta, recuerda que es una ruta relativa");
        }
    }

}
