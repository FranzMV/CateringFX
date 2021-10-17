package com.cateringfx.model;

/**
 *<p>Abstract class to define a basic elements needed to represent a food Menu by its
 *{@link MenuElement#name}, {@link MenuElement#description} and abstract methods:
 * {@link MenuElement#getCalories()}, {@link MenuElement#getCarbohydrates()},
 * {@link MenuElement#getFat()}, {@link MenuElement#isMilk()}, {@link MenuElement#isNuts()},
 * {@link MenuElement#isEgg()} and {@link MenuElement#isGluten()} to be implemented by its subclasses.</p>
 * @author Francisco David Manzanedo Valle.
 * @version 1.0.
 */
public abstract class MenuElement {

    /**The name of the element*/
    private String name;
    /**The description of the element*/
    private String description;

    /**
     * Creates a subclass of the menu element with his name and description.
     * @param name The name of the element.
     * @param description The description of the element.
     */
    public MenuElement(String name, String description){
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the element's name.
     * @return A String containing the name of the element.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the element's name.
     * @param name A String representing the name of the element.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the element's description.
     * @return A String containing the element description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the element's description.
     * @param description A String representing the element's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Abstract method: Gets the element's calories.
     * @return A double containing the element's calories.
     */
    public abstract double getCalories();

    /**
     * Abstract method: Gets the element's carbohydrates,
     * @return A double containing the element's carbohydrates.
     */

    public abstract double getCarbohydrates();

    /**
     * Abstract method: Gets the element's fat.
     * @return A double containing the element's fat.
     */
    public abstract double getFat();


    /**
     * Abstract method: Gets if the element contains milk.
     * @return A boolean, true if the aliment contains milk, false if not.
     */
    public abstract boolean isMilk();

    /**
     * Abstract method: Gets if the element contains nuts.
     * @return A boolean, true if the aliment contains nuts, false if not.
     */
    public abstract boolean isNuts();

    /**
     * Abstract method: Gets if the element contains milk.
     * @return A boolean, true if the aliment contains egg, false if not.
     */
    public abstract boolean isEgg();

    /**
     * Abstract method: Gets if the element contains gluten.
     * @return A boolean, true if the aliment contains gluten, false if not.
     */
    public abstract boolean isGluten();


}
