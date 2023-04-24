package com.example.block6personcontrollers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadService {
    private List<Ciudad> ciudades = new ArrayList<>();

    public Ciudad addCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
        return ciudad;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }
}