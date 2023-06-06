package com.example.application;

import com.example.controller.dto.FicheroInput;
import com.example.controller.dto.FicheroOutput;

import java.util.List;


public interface FicheroService {
    public FicheroOutput addFichero(FicheroInput ficheroInput);
    public List<FicheroOutput> getAllFicheros(int pageNumber, int pageSize);
}