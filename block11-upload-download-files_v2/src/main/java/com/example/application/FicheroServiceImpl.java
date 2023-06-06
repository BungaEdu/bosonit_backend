package com.example.application;

import com.example.controller.dto.FicheroInput;
import com.example.controller.dto.FicheroOutput;
import com.example.domain.Fichero;
import com.example.repository.FicheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FicheroServiceImpl implements FicheroService{
    @Autowired
    FicheroRepository ficheroRepository;

    @Override
    public FicheroOutput addFichero(FicheroInput ficheroInput) {
        return ficheroRepository.save(new Fichero(ficheroInput))
                .ficheroToFicheroOutput();
    }

    @Override
    public List<FicheroOutput> getAllFicheros(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return ficheroRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Fichero::ficheroToFicheroOutput).toList();
    }

}
