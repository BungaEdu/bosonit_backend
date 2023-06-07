package com.example.application;

import com.example.controller.dto.FicheroInput;
import com.example.controller.dto.FicheroOutput;
import com.example.domain.Fichero;
import com.example.repository.FicheroRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
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
    public String uploadFichero(MultipartFile file) {
        Fichero fichero = ficheroRepository.save(
                Fichero.builder()
                        .name(file.getOriginalFilename())
                        .uploadDate(new Date())
                        .category(file.getContentType())
                        .build()
        );
        if (file != null && !StringUtils.isBlank(file.getOriginalFilename())) {
            return "Archivo subido correctamente: " + file.getOriginalFilename();
        }
        return null;
    }

    @Override
    public FicheroOutput getFicheroById(int id) {
        return ficheroRepository.findById(id).orElseThrow()
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
