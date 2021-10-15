package com.cateringfx.model;

public class Aliment extends MenuElement{

    private String frequency;
    private double calories;
    private double carbohydrates;
    private double fat;
    private boolean milk;
    private boolean nuts;
    private boolean egg;
    private boolean gluten;


    public Aliment(String name, String description, String frequency, boolean gluten,boolean milk,
                   boolean nuts, boolean egg, double calories, double carbohydrates, double fat) {
        super(name, description);
        this.frequency = frequency;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
        this.milk = milk;
        this.nuts = nuts;
        this.egg = egg;
        this.gluten = gluten;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public void setNuts(boolean nuts) {
        this.nuts = nuts;
    }

    public void setEgg(boolean egg) {
        this.egg = egg;
    }

    public void setGluten(boolean gluten) {
        this.gluten = gluten;
    }

    @Override
    public double getCalories() {
        return calories;
    }

    @Override
    public double getCarbohydrates() {
        return carbohydrates;
    }

    @Override
    public double getFat() {
        return fat;
    }

    @Override
    public boolean isMilk() {
        return milk;
    }

    @Override
    public boolean isNuts() {
        return nuts;
    }

    @Override
    public boolean isEgg() {
        return egg;
    }

    @Override
    public boolean isGluten() {
        return gluten;
    }

    @Override
    public String toString() {
        return getDescription()+";"+getName()+";"
                +frequency+";"+isGluten()+";"+isMilk()+";"
                +isNuts()+";"+isEgg()+";"+calories+";"+carbohydrates+";"+fat;
    }
}
