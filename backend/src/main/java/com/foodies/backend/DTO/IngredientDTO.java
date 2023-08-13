package com.foodies.backend.DTO;

import com.foodies.backend.data.UnitEnum;

public class IngredientDTO {

    private Long id;
    private double amount;
    private UnitEnum unit;
    private String name;

    public IngredientDTO(Long id, double amount, UnitEnum unit, String name) {
        this.id = id;
        this.amount = amount;
        this.unit = unit;
        this.name = name;
    }

    public IngredientDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
