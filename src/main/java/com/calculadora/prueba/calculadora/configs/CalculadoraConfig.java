package com.calculadora.prueba.calculadora.configs;

import com.calculadora.prueba.calculadora.services.Calculadora;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculadoraConfig {
    @Bean
    public Calculadora configCalculadora() {
        System.out.println("Init bean configCalculadora");
        return new Calculadora();
    }
}
