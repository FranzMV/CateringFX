package com.cateringfx.model;

import java.util.ArrayList;
import java.util.List;

public class Dish extends MenuElement{
    //Implementar los métodos que hay MenuELement
    private List<Ingredient> ingredients;

    public Dish(String name, String description) {
        super(name, description);
        this.ingredients = new ArrayList<>();
    }

    @Override
    public double getCalories() { return ingredients.stream().mapToDouble(p-> p.getAliment().getCalories()).sum(); }

    @Override
    public double getCarbohydrates() { return ingredients.stream().mapToDouble(p-> p.getAliment().getCarbohydrates()).sum(); }

    @Override
    public double getFat() {
        return ingredients.stream().mapToDouble(p-> p.getAliment().getFat()).sum();
    }

    @Override
    public boolean isMilk() {
        return ingredients.stream().anyMatch(p-> p.getAliment().isMilk());
    }

    @Override
    public boolean isNuts() {
        return ingredients.stream().anyMatch(p-> p.getAliment().isNuts());
    }

    @Override
    public boolean isEgg() {
        return ingredients.stream().anyMatch(p-> p.getAliment().isEgg());
    }

    @Override
    public boolean isGluten() {
        return ingredients.stream().anyMatch(p-> p.getAliment().isGluten());
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    public List<Ingredient> getIngredients(){
        return ingredients;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getName() + ";" + getDescription()+";");
        for (Ingredient ingredient: ingredients) {
            result.append(ingredient.toString());
        }
        return result.toString();
    }
}
