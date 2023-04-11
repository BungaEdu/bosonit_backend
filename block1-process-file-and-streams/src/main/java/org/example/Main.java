package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //block1-process-file-and-streams\src\main\resources\people.csv
        Persona.readFich("block1-process-file-and-streams\\src\\main\\resources\\people.csv");

    }
}