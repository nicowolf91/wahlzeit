package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Container;
import com.googlecode.objectify.annotation.Subclass;

@PatternInstance(
        patternName = "Abstract Factory",
        participants = {"Concrete Product"}
)
@Subclass
public class DrinksPhoto extends Photo {

    public static final String DRINK_TYPE = "drink_type";

    @Container
    private Drink drink;

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
    public DrinksPhoto(PhotoId myId, Drink drink) {
        super(myId);

        this.drink = drink;
    }

    /**
     *
     * @methodtype get
     */
    public Drink getDrink() {
        return drink;
    }

    /**
     *
     * @methodtype set
     */
    public void setDrink(Drink drink) {
        this.drink = drink;
    }
}
