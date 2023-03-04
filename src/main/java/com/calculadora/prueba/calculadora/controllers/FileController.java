package com.calculadora.prueba.calculadora.controllers;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class FileController {
    @PostMapping("/uploadFile")
    public String upload(@RequestParam("file")MultipartFile file){
        try {
            String fileName= StringUtils.cleanPath(file.getOriginalFilename());
            Path targetLocation = Paths.get("C:\\Users\\duvan\\OneDrive\\Documentos\\"+fileName);

            Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "Archivo cargado";
    }
}
