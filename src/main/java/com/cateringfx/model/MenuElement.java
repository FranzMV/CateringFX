package com.cateringfx.model;

public abstract class MenuElement {

    private String name;
    private String description;

   // public MenuElement(){}

    public MenuElement(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract double getCalories();

    public abstract double getCarbohydrates();

    public abstract double getFat();

    public abstract boolean isMilk();

    public abstract boolean isNuts();

    public abstract boolean isEgg();

    public abstract boolean isGluten();


   // @Override
   // public String toString() { return name +";"+description + ";";  }
}
