package com.calculadora.prueba.calculadora.models;

public class ColorDto {
    private Integer idColor;
    private String color;

    public ColorDto() {
        super();
    }

    public ColorDto(Integer idColor, String color) {
        this.idColor = idColor;
        this.color = color;
    }

    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
