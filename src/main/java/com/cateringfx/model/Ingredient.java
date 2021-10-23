package com.cateringfx.model;

/**
 * <p>Represents an Ingredient by its attributes  {@link Ingredient#quantity} and aliments.</p>
 * @see Aliment
 *
 * @author Francisco David Manzanedo Valle.
 * @version 1.0.
 */
public class Ingredient {

    /**The ingredient's <b>quantity</b> */
    private double quantity;
    /**The <b>{@link Aliment}</b> data corresponding to the ingredient
     * @see Aliment
     * */
    private Aliment aliment;

    /**
     *Creates an Ingredient which its attributes.
     * @param quantity The ingredient's quantity.
     * @param aliment The ingredient's aliment.
     * @see Aliment
     */
    public Ingredient(double quantity, Aliment aliment) {
        this.quantity = quantity;
        this.aliment = aliment;
    }

    /**
     * Gets the ingredient's quantity.
     * @return A double representing the ingredient's quantity.
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Sets the ingredient's quantity.
     * @param quantity A double containing the ingredient's quantity.
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets an aliment's  ingredient.
     * @return An Aliment representing the ingredient's aliment.
     * @see Aliment
     */
    public Aliment getAliment() {
        return aliment;
    }

    /**
     * Gets the aliment's name.
     * @return A String corresponding to the aliment's name.
     * @see Aliment
     */
    public String getName(){return  aliment.getName();}

    /**
     * Gets the aliment's description.
     * @return A String corresponding to the aliment's description.
     * @see Aliment
     */
    public String getDescription(){return  aliment.getDescription();}

    /**
     * Sets the ingredient's aliment.
     * @param aliment An Aliment containing the aliment data.
     * @see Aliment
     */
    public void setAliment(Aliment aliment) {
        this.aliment = aliment;
    }

    /**
     * Gets the aliment's calories.
     * @return double representing the total of the aliment's calories.
     */
    public double getCalories(){ return aliment.getCalories() * quantity;}

    /**
     * Gets the aliment's carbohydrates.
     * @return double representing the total of the aliment's carbohydrates.
     */
    public double getCarbohydrates(){return aliment.getCarbohydrates() * quantity; }

    /**
     * Gets the aliment's fat
     * @return double representing the total of the aliment's fats.
     */
    public double getFat(){ return aliment.getFat() * quantity ; }


    /**
     * Gets all the Ingredient's attributes.
     * @return A String containing all the ingredient's attributes.
     * @see Aliment
     */
    @Override
    public String toString() {
        return +quantity + ";" + aliment.toString();
    }
}
