package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class block11UploadDownloadFiles {
    public static String directorioDescargas;
    public static void main(String[] args) {
        SpringApplication.run(block11UploadDownloadFiles.class, args);

        if (args.length > 0) {
            directorioDescargas = args[0];
        } else {
            directorioDescargas = "C:\\tmp\\";
        }
    }

    public static String getDirectorioGuardado() {
        return directorioDescargas;
    }

    //El comando para el jar es: java -jar .\block11-upload-download-files_v2-0.0.1-SNAPSHOT.jar C:/tmp/
}