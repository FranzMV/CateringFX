package com.cateringfx.model;

/**
 * <p>Define an Aliment by its attributes {@link Aliment#frequency},
 * {@link Aliment#calories}, {@link Aliment#carbohydrates}, {@link Aliment#fat},
 * {@link Aliment#milk}, {@link Aliment#nuts}, {@link Aliment#egg} and {@link Aliment#gluten}.</p>
 * <p>Extends from the abstract class {@link MenuElement} and implement its abstract methods:
 * {@link MenuElement#getCalories()}, {@link MenuElement#getCarbohydrates()} , {@link MenuElement#getFat()},
 *  {@link MenuElement#isMilk()}, {@link MenuElement#isNuts()}, {@link MenuElement#isEgg()} and
 *  {@link MenuElement#isGluten()}.</p>
 * @see MenuElement
 * @author Francisco David Manzanedo Valle.
 * @version 1.0.
 */
public class Aliment extends MenuElement{

    /**The frequency of the aliment on the menu.*/
    private String frequency;
    /**The amount of calories of the aliment.*/
    private double calories;
    /**The amount of carbohydrates of the aliment.*/
    private double carbohydrates;
    /**The amount of fats of the aliment.*/
    private double fat;
    /**If the aliment contains milk .*/
    private boolean milk;
    /**If the aliment contains nuts .*/
    private boolean nuts;
    /**If the aliment contains egg< .*/
    private boolean egg;
    /**If the aliment contains gluten .*/
    private boolean gluten;

    /**
     * Creates an aliment with all of its attributes.
     * @param name The aliment's name.
     * @param description The aliment's description.
     * @param frequency The aliment's frequency.
     * @param gluten If the aliment contains gluten.
     * @param milk If the aliment contains milk.
     * @param nuts If the aliment contains nuts.
     * @param egg If the aliment contains egg.
     * @param calories The amount aliment's calories.
     * @param carbohydrates The amount aliment's carbohydrates.
     * @param fat The amount aliment's fats.
     */
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

    /**
     * Gets the aliment's frequency.
     * @return A String representing an aliment's frequency.
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * Sets the aliment's frequency.
     * @param frequency A String containing the aliment's frequency.
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    /**
     * Sets the aliment's calories.
     * @param calories A double containing the aliment's calories.
     */
    public void setCalories(double calories) {
        this.calories = calories;
    }

    /**
     * Sets the aliment's carbohydrates.
     * @param carbohydrates A double containing the aliment's carbohydrates.
     */
    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    /**
     * Sets the aliment's fat.
     * @param fat A double containing the aliment's fat.
     */
    public void setFat(double fat) {
        this.fat = fat;
    }

    /**
     * Sets if the aliment contains milk.
     * @param milk A boolean containing if the aliment contains milk.
     */
    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    /**
     * Sets if aliment contains nuts.
     * @param nuts A boolean containing if the aliment contain nuts.
     */
    public void setNuts(boolean nuts) {
        this.nuts = nuts;
    }

    /**
     * Sets if the aliment contains egg.
     * @param egg A boolean containing if the aliment contains egg.
     */
    public void setEgg(boolean egg) {
        this.egg = egg;
    }

    /**
     * Sets if the aliment contains egg.
     * @param gluten A boolean containing if the aliment contains gluten.
     */
    public void setGluten(boolean gluten) {
        this.gluten = gluten;
    }

    /**
     * Gets the aliment's calories.
     * @return A double representing the aliment's calories.
     */
    @Override
    public double getCalories() {
        return calories;
    }

    /**
     * Gets the aliment's carbohydrates.
     * @return A double representing the aliment's carbohydrates.
     */
    @Override
    public double getCarbohydrates() {
        return carbohydrates;
    }

    /**
     * Gets the aliment's fat.
     * @return A double representing the aliment's fat.
     */
    @Override
    public double getFat() {
        return fat;
    }

    /**
     * Gets if the aliment contains milk.
     * @return A boolean representing if an aliment contains milk.
     */
    @Override
    public boolean isMilk() {
        return milk;
    }

    /**
     * Gets if the aliment contains nuts.
     * @return A boolean representing if an aliment contains nuts.
     */
    @Override
    public boolean isNuts() {
        return nuts;
    }

    /**
     * Gets if the aliment contains egg.
     * @return A boolean representing if an aliment contains egg.
     */
    @Override
    public boolean isEgg() {
        return egg;
    }

    /**
     * Gets if the aliment contains gluten.
     * @return A boolean representing if an aliment contains gluten.
     */
    @Override
    public boolean isGluten() {
        return gluten;
    }

    /**
     * Gets all the aliment's attributes.
     * @return A String representing all the aliment's attributes.
     */
    @Override
    public String toString() {
        return getName()+";"+getDescription()+";"
                +frequency+";"+isGluten()+";"+isMilk()+";"
                +isNuts()+";"+isEgg()+";"+calories+";"+carbohydrates+";"+fat+";";
    }
}
