package com.cateringfx.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private LocalDate date;
    private List<MenuElement> elements;

    public Menu(LocalDate date) {

        this.date = date;
        this.elements = new ArrayList<>();
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<MenuElement> getElements() {
        return elements;
    }

    public void setElements(List<MenuElement> elements) {
        this.elements = elements;
    }

    public void addNewElement(MenuElement newMenuElement){
        elements.add(newMenuElement);
    }

    public double getCalories() { return elements.stream().mapToDouble(MenuElement::getCalories).sum(); }

    public double getCarbohydrates() { return elements.stream().mapToDouble(MenuElement::getCarbohydrates).sum(); }

    public double getFat() { return elements.stream().mapToDouble(MenuElement::getFat).sum(); }

    public boolean isMilk() { return elements.stream().anyMatch(MenuElement::isMilk); }

    public boolean isNuts() { return elements.stream().anyMatch(MenuElement::isNuts); }

    public boolean isEgg() {  return elements.stream().anyMatch(MenuElement::isEgg); }

    public boolean isGluten() {  return elements.stream().anyMatch(MenuElement::isGluten); }

    @Override
    public String toString() {

        StringBuilder result= new StringBuilder(date.toString()+";");
        for (MenuElement m: elements) {
            result.append(m.toString());
        }
        return result.toString();
    }
}
