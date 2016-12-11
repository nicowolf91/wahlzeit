package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DrinksPhotoManager extends PhotoManager {
    /**
     * singleton instance
     */
    private static final DrinksPhotoManager instance = new DrinksPhotoManager();

    /**
     * @methodtype command
     */
    public Set<DrinksPhoto> findPhotosByDrinkType(DrinkType drinkType) throws IllegalArgumentException {
        if (drinkType == null) {
            throw new IllegalArgumentException("drink type must not be null");
        }

        Set<DrinksPhoto> result = new HashSet<DrinksPhoto>();
        readObjects(result, DrinksPhoto.class, DrinksPhoto.DRINK_TYPE, drinkType);

        for (Iterator<DrinksPhoto> i = result.iterator(); i.hasNext(); ) {
            doAddPhoto(i.next());
        }

        return result;
    }
}
