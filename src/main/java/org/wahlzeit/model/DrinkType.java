package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DrinkType extends DataObject {
    public enum Name {
        ALCOHOLIC, NON_ALCOHOLIC, COFFEE, SMOOTHIE, TEA, COCKTAIL, SOFT_DRINK, BEER, SCHNAPS, FRUIT_JUICE
    }

    private Name name;
    private boolean alcoholic;

    private DrinkType superType;
    private Set<DrinkType> subTypes = new HashSet<>();

    /**
     * @methodtype constructor
     */
    public DrinkType(Name name, boolean alcoholic) {
        this(name, alcoholic, null, null);
    }

    /**
     * @methodtype constructor
     */
    public DrinkType(Name name, boolean alcoholic, DrinkType superType) {
        this(name, alcoholic, superType, null);
    }

    /**
     * @methodtype constructor
     */
    public DrinkType(Name name, boolean alcoholic, DrinkType superType, Set<DrinkType> subTypes) {
        this.name = name;
        this.alcoholic = alcoholic;
        this.superType = superType;
        this.subTypes = subTypes;
    }

    /**
     * @methodtype get
     */
    public Name getName() {
        return name;
    }

    /**
     * @methodtype set
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @methodtype get
     */
    public boolean isAlcoholic() {
        return alcoholic;
    }

    /**
     * @methodtype set
     */
    public void setAlcoholic(boolean alcoholic) {
        this.alcoholic = alcoholic;
    }

    /**
     * @methodtype get
     */
    public DrinkType getSuperType() {
        return superType;
    }

    /**
     * @methodtype set
     */
    public void setSuperType(DrinkType superType) {
        this.superType = superType;
    }

    /**
     * @methodtype get
     */
    public Iterator<DrinkType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    /**
     * @methodtype set
     */
    public void addSubType(DrinkType drinkType) {
        assert (drinkType != null) : "tried to set null sub-type";
        drinkType.setSuperType(this);
        subTypes.add(drinkType);
    }

    /**
     * @methodtype query
     */
    public boolean hasInstance(Drink drink) {
        assert (drink != null) : "asked about null object";
        if (drink.getDrinkType() == this) {
            return true;
        }
        for (DrinkType type : subTypes) {
            if (type.hasInstance(drink)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @methodtype query
     */
    public boolean isSubtype(DrinkType drinkType) {
        assert (drinkType != null) : "asked about null object";
        for(DrinkType dt : subTypes) {
            if(dt == drinkType) {
                return true;
            }
        }

        return false;
    }

    public Drink createInstance() {
        return new Drink(this);
    }

    public String toString() {
        String tmp = alcoholic ? "X" : " ";
        return name + tmp;
    }
}
