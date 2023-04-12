package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static <InvalidLineFormatException extends Throwable> void main(String[] args) throws IOException, URISyntaxException, Persona.InvalidLineFormatException {
        System.out.println("hello world");
        //La ruta a utilizar es: "block1-process-file-and-streams\src\main\resources\people.csv"
        //TODO lectura por pantalla con scanner seguramente
        //
        //

        String route = "block1-process-file-and-streams\\src\\main\\resources\\people.csv";

        ArrayList resultado = Persona.createPersonList(Persona.readFichAllToList(route));
        for (Object p : resultado) {
            System.out.println(p);
        }


    }

}