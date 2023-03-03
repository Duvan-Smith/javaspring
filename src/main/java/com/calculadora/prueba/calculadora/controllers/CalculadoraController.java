package com.calculadora.prueba.calculadora.controllers;

import com.calculadora.prueba.calculadora.services.Calculadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
    @Autowired
    private Calculadora calculadora;

    public CalculadoraController(){
        System.out.println("CalculadoraController");
    }

    @GetMapping("/sumar")
    public String sumar(){
        int a=2;
        int b=2;
        //Calculadora calsuladora=new Calculadora();
        return "Resultado: " + calculadora.add(a,b);
    }
}
