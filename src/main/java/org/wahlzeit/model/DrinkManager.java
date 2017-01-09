package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

public class DrinkManager {
    private Map<String, Drink> drinks = new HashMap<>();
    private Map<DrinkType.Name, DrinkType> drinkTypes = new HashMap<>();

    private static DrinkManager drinkManager;

    /**
     * @methodtype constructor
     */
    private DrinkManager() {
    }

    /**
     * @methodtype factory method
     */
    public static synchronized DrinkManager getInstance() {
        if (drinkManager == null) {
            drinkManager = new DrinkManager();
        }

        return drinkManager;
    }

    /**
     * @methodtype get
     */
    public DrinkType getDrinkType(DrinkType.Name drinkTypeName) {
        return drinkTypes.get(drinkTypeName);
    }

    /**
     * @methodtype get
     */
    public DrinkType createDrinkType(DrinkType.Name drinkTypeName, boolean alcoholic) {
        return addDrinkType(new DrinkType(drinkTypeName, alcoholic));
    }

    /**
     * @methodtype get
     */
    public Drink createDrink(String name, double alcoholConcentration, DrinkType drinkType) {
        Drink ret = new Drink(name, alcoholConcentration, drinkType);
        drinks.put(ret.toString(), ret);

        return ret;
    }

    /**
     * @methodtype get
     */
    public Drink createDrink(String name, double alcoholConcentration, DrinkType.Name drinkTypeName) {
        DrinkType dt = getDrinkType(drinkTypeName);
        Drink ret = dt.createInstance();
        ret.setName(name);
        ret.setAlcoholConcentration(alcoholConcentration);
        drinks.put(ret.toString(), ret);

        return ret;
    }

    /**
     * @methodtype get
     */
    public Drink createDrink(DrinkType.Name drinkTypeName) {
        DrinkType dt = getDrinkType(drinkTypeName);
        Drink result = dt.createInstance();
        drinks.put(result.toString(), result);
        return result;
    }

    /**
     * @methodtype set
     */
    private DrinkType addDrinkType(DrinkType drinkType) {
        if (!drinkTypes.containsKey(drinkType.getName())) {
            drinkTypes.put(drinkType.getName(), drinkType);
        }

        return drinkType;
    }
}
