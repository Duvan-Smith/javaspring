package com.calculadora.prueba.calculadora.controllers;

import com.calculadora.prueba.calculadora.models.ColorDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ColorController {
    private static List<ColorDto> colorDtos = new ArrayList<>();

    public ColorController() {
        colorDtos.add(new ColorDto(1,"red","199, 0, 57"));
        colorDtos.add(new ColorDto(2,"blue","51, 113, 255"));
    }

    @GetMapping("/colores")
    public List<ColorDto> getAllColores(){
        return colorDtos;
    }

    @GetMapping("/colores/{id}")
    public ColorDto getAllColorById(@PathVariable("id") Integer id){
        return colorDtos.stream()
                .filter(c->c.getIdColor().equals(id))
                .findFirst()
                .get();
    }

    @PostMapping("/colores")
    public String saveColor(@RequestBody ColorDto colorDto){
        colorDtos.add(colorDto);
        return "Color guardado.";
    }

    @PutMapping("/colores/{id}")
    public String editColor(@PathVariable("id") Integer id, @RequestBody ColorDto colorDto){
        colorDtos.stream()
                .filter(c->c.getIdColor().equals(id))
                .findFirst()
                .get()
                .setColor(colorDto.getColor());

        return "Color editado.";
    }

    @DeleteMapping("/colores/{id}")
    public String deleteColor(@PathVariable("id") Integer id){
        ColorDto color = colorDtos.stream()
                .filter(c->c.getIdColor().equals(id))
                .findFirst()
                .get();

        colorDtos.remove(color);

        return "Color eliminado.";
    }

    @GetMapping("/colores/{id}/{name}")
    public String getRgbColor(@PathVariable("id") Integer id, @PathVariable("name") String name){
        return colorDtos.stream()
                .filter(c->c.getIdColor().equals(id))
                .filter(c->c.getColor().equals(name))
                .findFirst()
                .get()
                .getRgb();
    }

    @GetMapping("/coloresQuery")
    public String getRgbColor(@RequestParam("name") String name){
        return colorDtos.stream()
                .filter(c->c.getColor().equals(name))
                .findFirst()
                .get()
                .getRgb();
    }
}
