package com.example.application;

import com.example.controller.dto.FicheroInput;
import com.example.controller.dto.FicheroOutput;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface FicheroService {
    public FicheroOutput addFichero(FicheroInput ficheroInput);

    String uploadFichero(MultipartFile file);

    FicheroOutput getFicheroById(int id);

    public List<FicheroOutput> getAllFicheros(int pageNumber, int pageSize);
}