package com.calculadora.prueba.calculadora.models;

public class ColorDto {
    private Integer idColor;
    private String color;
    private String rgb;

    public ColorDto() {
        super();
    }

    public ColorDto(Integer idColor, String color, String rgb) {
        this.idColor = idColor;
        this.color = color;
        this.rgb = rgb;
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

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }
}
