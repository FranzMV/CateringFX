package com.cateringfx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Define a Dish with ist attributes {@link MenuElement#getName()}, {@link MenuElement#getDescription()}
 * extends from de parent class {@link MenuElement} and a {@link List<Ingredient>}</p>.
 * @see MenuElement
 * @see Ingredient
 * @see List
 *
 * @author Francisco David Manzanedo Valle.
 * @version 1.0
 *
 */
public class Dish extends MenuElement{

    /**A list of ingredients that contains the dish
     * @see Ingredient
     * @see List
     * */
    private final List<Ingredient> ingredients;

    /**
     * Creates a Dish with its attributes.
     * @param name representing the dish's name.
     * @param description representing the dish's description.
     */
    public Dish(String name, String description) {
        super(name, description);
        this.ingredients = new ArrayList<>();
    }

    /**
     * Gets the sum of the ingredient's calories in the ingredient list.
     * @return A double corresponding to the sum of the ingredient's calories.
     */

    @Override
    public double getCalories() { return ingredients.stream().mapToDouble(p-> p.getAliment().getCalories()).sum(); }

    /**
     * Gets the sum of the ingredient's carbohydrates in the list.
     * @return A double corresponding to the sum of the ingredient's carbohydrates.
     */
    @Override
    public double getCarbohydrates() { return ingredients.stream().mapToDouble(p-> p.getAliment().getCarbohydrates()).sum(); }

    /**
     * Gets the sum of the ingredient's fat in the list.
     * @return A double corresponding to the sum of the ingredient's fat.
     */
    @Override
    public double getFat() {return ingredients.stream().mapToDouble(p-> p.getAliment().getFat()).sum();}

    /**
     * Gets if the ingredient stored in the list contains milk.
     * @return boolean if the element contains milk true, if not, false.
     */
    @Override
    public boolean isMilk() { return ingredients.stream().anyMatch(p-> p.getAliment().isMilk());}

    /**
     * Gets if the ingredient stored in the list contains nuts.
     * @return A boolean if the element contains nuts true, if not, false.
     */
    @Override
    public boolean isNuts() { return ingredients.stream().anyMatch(p-> p.getAliment().isNuts());}

    /**
     * Gets if the ingredient stored in the list contains egg.
     * @return A boolean if the element contains egg true, if not, false.
     */
    @Override
    public boolean isEgg() { return ingredients.stream().anyMatch(p-> p.getAliment().isEgg()); }

    /**
     * Gets if the element stored in the list contains gluten.
     * @return A boolean if the element contains milk true, if not, false.
     */
    @Override
    public boolean isGluten() { return ingredients.stream().anyMatch(p-> p.getAliment().isGluten()); }

    /**
     * Add a new Ingredient to the ingredient's list.
     * @param ingredient representing the ingredient of the list.
     * @see Ingredient
     */
    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    /**
     * Gets the ingredients stored in the ingredient's list.
     * @return List of ingredients.
     * @see Ingredient
     */
    public List<Ingredient> getIngredients(){
        return ingredients;
    }

    /**
     * Gets all the dish attributes.
     * @return A String containing all the dish attribute values.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getName() + ";" + getDescription()+";");
        for (Ingredient ingredient: ingredients) {
            result.append(ingredient.toString());
        }
        return result.toString();
    }
}
