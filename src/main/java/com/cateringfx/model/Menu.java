package com.cateringfx.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Represents a Menu data by its attributes {@link Menu#date} and a {@link List<MenuElement>} of
 * {@link Menu#elements}</p>.
 * @see MenuElement
 *
 * @author Francisco David Manzanedo Valle.
 * @version 1.0
 */
public class Menu {

    /**The menu creation date */
    private LocalDate date;
    /**A List of elements.
     * @see MenuElement
     * @see List
     * @see ArrayList
     */
    private List<MenuElement> elements;

    /**
     * Creates a Menu with its date.
     * @param date The menu creation date.
     * @see LocalDate
     */
    public Menu(LocalDate date) {
        this.date = date;
        this.elements = new ArrayList<>();
    }

    /**
     * Gets the menu creation date.
     * @see LocalDate
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the menu creation date.
     * @param date LocalDate containing the menu creation date.
     * @see LocalDate
     */
    public void setDate(LocalDate date) { this.date = date;}

    /**
     * Gets the menu elements.
     * @return List containing the menu elements.
     * @see MenuElement
     * @see List
     * @see ArrayList
     */
    public List<MenuElement> getElements() {
        return elements;
    }

    /**
     * Sets the menu elements list.
     * @param elements List of elements.
     * @see MenuElement
     * @see List
     * @see ArrayList
     */
    public void setElements(List<MenuElement> elements) {
        this.elements = elements;
    }

    /**
     * Add a new element to the menu.
     * @param newMenuElement representing the element of the menu.
     * @see MenuElement
     */
    public void addNewElement(MenuElement newMenuElement){
        elements.add(newMenuElement);
    }

    /**
     * Gets the sum of the element's calories in the ingredient list.
     * @return A double corresponding to the sum of the element's calories.
     */
    public double getCalories() { return elements.stream().mapToDouble(MenuElement::getCalories).sum(); }

    /**
     * Gets the sum of the element's carbohydrates in the list.
     * @return A double corresponding to the sum of the ingredient's carbohydrates.
     */
    public double getCarbohydrates() { return elements.stream().mapToDouble(MenuElement::getCarbohydrates).sum(); }

    /**
     * Gets the sum of the element's fat in the list.
     * @return A double corresponding to the sum of the ingredient's fat.
     */
    public double getFat() { return elements.stream().mapToDouble(MenuElement::getFat).sum(); }

    /**
     * Gets if the element stored in the list contains milk.
     * @return boolean if the element contains milk true, if not, false.
     */
    public boolean isMilk() { return elements.stream().anyMatch(MenuElement::isMilk); }

    /**
     * Gets if the element stored in the list contains nuts.
     * @return A boolean if the element contains nuts true, if not, false.
     */
    public boolean isNuts() { return elements.stream().anyMatch(MenuElement::isNuts); }

    /**
     * Gets if the element stored in the list contains egg.
     * @return A boolean if the element contains egg true, if not, false.
     */
    public boolean isEgg() {  return elements.stream().anyMatch(MenuElement::isEgg); }

    /**
     * Gets if the element stored in the list contains gluten.
     * @return A boolean if the element contains milk true, if not, false.
     */
    public boolean isGluten() {  return elements.stream().anyMatch(MenuElement::isGluten); }

    /**
     * Gets all the Menu attributes.
     * @return A String corresponding to all values of the menu attributes.
     */
    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        StringBuilder result= new StringBuilder(date.format(formatter)+";");
        for (MenuElement m: elements) {
            result.append(m.toString());
        }
        return result.toString();
    }
}
