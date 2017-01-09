package org.wahlzeit.model;

public class Drink {
    private String name;
    private double alcoholConcentration;
    private DrinkType drinkType;

    /**
     * @methodtype constructor
     */
    public Drink(DrinkType drinkType) {
        this(null, 0.0d, drinkType);
    }

    /**
     * @methodtype constructor
     */
    public Drink(String name, double alcoholConcentration, DrinkType drinkType) {
        this.name = name;
        this.alcoholConcentration = alcoholConcentration;
        this.drinkType = drinkType;
    }

    /**
     * @methodtype get
     */
    public String getName() {
        return name;
    }

    /**
     * @methodtype set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @methodtype get
     */
    public double getAlcoholConcentration() {
        return alcoholConcentration;
    }

    /**
     * @methodtype set
     */
    public void setAlcoholConcentration(double alcoholConcentration) {
        this.alcoholConcentration = alcoholConcentration;
    }

    /**
     * @methodtype get
     */
    public DrinkType getDrinkType() {
        return drinkType;
    }

    /**
     * @methodtype set
     */
    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public String toString() {
        return name + alcoholConcentration + drinkType;
    }
}
