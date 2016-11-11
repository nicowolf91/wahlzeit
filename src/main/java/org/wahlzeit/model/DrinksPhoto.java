package org.wahlzeit.model;

public class DrinksPhoto extends Photo {

    public static final String DRINK_TYPE = "drink_type";

    private double alcoholConcentration;
    private DrinkType drinkType;

    /**
     *
     * @methodtype constructor
     */
    public DrinksPhoto() {
    }

    /**
     *
     * @methodtype constructor
     */
    public DrinksPhoto(PhotoId myId) {
        super(myId);
    }

    /**
     *
     * @methodtype constructor
     */
    public DrinksPhoto(PhotoId myId, double alcoholConcentration, DrinkType drinkType) {
        super(myId);
        this.alcoholConcentration = alcoholConcentration;
        this.drinkType = drinkType;
    }

    /**
     *
     * @methodtype get
     */
    public double getAlcoholConcentration() {
        return alcoholConcentration;
    }

    /**
     *
     * @methodtype set
     */
    public void setAlcoholConcentration(double alcoholConcentration) {
        this.alcoholConcentration = alcoholConcentration;
    }

    /**
     *
     * @methodtype get
     */
    public DrinkType getDrinkType() {
        return drinkType;
    }

    /**
     *
     * @methodtype set
     */
    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }
}
