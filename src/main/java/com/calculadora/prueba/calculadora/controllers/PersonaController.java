package com.calculadora.prueba.calculadora.controllers;

import com.calculadora.prueba.calculadora.models.ColorDto;
import com.calculadora.prueba.calculadora.models.PersonaDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class PersonaController {
    private static List<PersonaDto> personaDtos = new ArrayList<>();

    public PersonaController() {
        personaDtos.add(new PersonaDto("123456","CC","Juan","Bendicion","123789"));
        personaDtos.add(new PersonaDto("654321","CE","Lenny","Bendicion","987123"));
        personaDtos.add(new PersonaDto("123456","CO","Michael","Bendicion","123787"));
        personaDtos.add(new PersonaDto("654322","CE","Lenny","Bendicion","987122"));
    }

    @GetMapping("/personaQuery")
    public List<PersonaDto> getPersonaByParameters(@RequestParam("identification") String identification,
                              @RequestParam(value = "identificationType",required = false) String identificationType,
                              @RequestParam(value = "name",required = false) String name,
                              @RequestParam(value = "lastName",required = false) String lastName,
                              @RequestParam(value = "phone",required = false) String phone
        ){
        return personaDtos.stream()
                .filter(p->identification==null || p.getIdentification().equals(identification))
                .filter(p->identificationType==null || p.getIdentificationType().equals(identificationType))
                .filter(p->name==null || p.getName().equals(name))
                .filter(p->lastName==null || p.getLastName().equals(lastName))
                .filter(p->phone==null || p.getPhone().equals(phone))
                .collect(Collectors.toList());
    }

    @GetMapping("/personaQueryUnico")
    public List<PersonaDto> getPersonaByParameter(@RequestParam Map<String,String> parameters
                                        ){
        return personaDtos.stream()
                .filter(p->parameters.get("identification") == null || p.getIdentification().equals(parameters.get("identification")))
                .filter(p->parameters.get("identificationType") == null || p.getIdentificationType().equals(parameters.get("identificationType")))
                .filter(p->parameters.get("name") == null || p.getName().equals(parameters.get("name")))
                .filter(p->parameters.get("lastName") == null || p.getLastName().equals(parameters.get("lastName")))
                .filter(p->parameters.get("phone") == null || p.getPhone().equals(parameters.get("phone")))
                .collect(Collectors.toList());
    }
}
