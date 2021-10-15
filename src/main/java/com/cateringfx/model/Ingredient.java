package com.cateringfx.model;

public class Ingredient {

    private double quantity;
    private Aliment aliment;

    public Ingredient(double quantity, Aliment aliment) {
        this.quantity = quantity;
        this.aliment = aliment;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Aliment getAliment() {
        return aliment;
    }

    public void setAliment(Aliment aliment) {
        this.aliment = aliment;
    }

    @Override
    public String toString() {
        return +quantity + ";" + aliment.toString();
    }
}
