package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
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

        assertIsValidAlcoholConcentration(alcoholConcentration);
        assertIsValidDrinkType(drinkType);

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
        assertIsValidAlcoholConcentration(alcoholConcentration);
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
        assertIsValidDrinkType(drinkType);
        this.drinkType = drinkType;
    }

    /**
     *
     * @methodtype assertion
     */
    public void assertIsValidAlcoholConcentration(double alcoholConcentration) {
        if(Double.isNaN(alcoholConcentration) || Double.isInfinite(alcoholConcentration) || alcoholConcentration < 0) {
            throw new IllegalArgumentException("value [" + alcoholConcentration + "] of alcohol concentration is invalid");
        }
    }

    /**
     *
     * @methodtype assertion
     */
    public void assertIsValidDrinkType(DrinkType drinkType) {
        if(drinkType == null) {
            throw new IllegalArgumentException("drink type must ot be null");
        }
    }
}
