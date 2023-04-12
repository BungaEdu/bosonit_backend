package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
                '}'
                ;
    }

    public static void log(Object obj) {
        System.out.println(obj);
    }

    //He creado mi propia excepción pero al final no he sabido utilizarla correctamente al 100%
    public class InvalidLineFormatException extends Exception {
        public InvalidLineFormatException() {
            super("La línea es inválida");
        }

        public InvalidLineFormatException(String message) {
            super(message);
        }
    }

    //Método para leer un fichero CSV e imprimirlo por pantalla
    public static void readFichAll(String route) throws IOException {
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

    //Función para meter las filas de un fichero en un ArrayList
    public static ArrayList<String> readFichAllToList(String route) throws IOException {
        ArrayList<String> people = null;
        try {
            Path path = Paths.get(route);
            try {
                String read = "";
                int i = 0;
                people = new ArrayList<>();
                while (true) {
                    read = Files.readAllLines(path).get(i);
                    i++;
                    people.add(read);
                }
            } catch (Exception e) {
                System.out.println("Fin Fichero");
            }
        } catch (Exception InvalidLineFormatException) {
            System.out.println("Ruta incorrecta, recuerda que es una ruta relativa");
        }
        return people;
    }

    //Función para meter cada fila de un CSV en un objeto de tipo Persona
    public static ArrayList<Persona> createPersonList(ArrayList listPeopleText) {
        ArrayList<Persona> result = new ArrayList<>();
        ArrayList<Object> arrayEntero = new ArrayList<>();
        arrayEntero.add("");
        arrayEntero.add("unknow");
        arrayEntero.add(0);
        Persona pers;
        for (int i = 0; i < listPeopleText.size(); i++) {
            String[] parts = listPeopleText.get(i).toString().split(":");
            for (int j = 0; j < parts.length; j++) {
                arrayEntero.set(j, parts[j]);
            }
            if (arrayEntero.get(0).toString().equals("")) {
                log("Error en fila "+(i+1)+": el nombre es un campo obligatorio");
            }

            try {
                int edad = Integer.valueOf(arrayEntero.get(2).toString());
            } catch (NumberFormatException  e) {
                System.out.println("La edad tiene que ser un dato numérico");
            } finally {
                pers = new Persona(arrayEntero.get(0).toString(), arrayEntero.get(1).toString(), arrayEntero.get(2).toString());
                result.add(pers);
            }
        }
        return result;

    }

    public static void filtroMenor25 (ArrayList<Persona>people) {
        for (Persona p:people) {
            Stream<String> persona = Stream.<String>builder()
                    .add(p.name)
                    .add(p.town)
                    .add(p.age)
                    .build();
            Stream<Persona> persMenor25 = persona.stream()
        }

    }

}
