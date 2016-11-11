package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class DrinksPhotoFactory extends PhotoFactory {
    private static final Logger logger = Logger.getLogger(DrinksPhotoFactory.class.getName());

    /**
     * singleton instance
     */
    private static DrinksPhotoFactory instance = null;

    /**
     *
     * @methodtype constructor
     */
    public DrinksPhotoFactory() {
    }

    /**
     * @methodtype factory
     */
    public DrinksPhoto createPhoto() {
        return new DrinksPhoto();
    }

    /**
     * @methodtype factory
     */
    public DrinksPhoto createPhoto(PhotoId id) {
        return new DrinksPhoto(id);
    }

    /**
     * @methodtype factory
     */
    public DrinksPhoto createPhoto(PhotoId id, double alcoholConcentration, DrinkType drinkType) {
        return new DrinksPhoto(id, alcoholConcentration, drinkType);
    }

    /**
     * methodtype set
     */
    protected static synchronized void setInstance(DrinksPhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initialize DrinksPhotoFactory twice");
        }

        instance = photoFactory;
    }

    /**
     * methodtype get
     */
    public static synchronized DrinksPhotoFactory getInstance() {
        if (instance == null) {
            logger.config(LogBuilder.createSystemMessage().addAction("setting DrinksPhotoFactory").toString());
            setInstance(new DrinksPhotoFactory());
        }

        return instance;
    }
}
