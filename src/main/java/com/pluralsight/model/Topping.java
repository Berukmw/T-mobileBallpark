package com.pluralsight.model;

public class Topping {
    private String name;
    private ToppingCategory category;
    private boolean isExtra;

    public Topping(String name, ToppingCategory category, boolean isExtra) {
        this.name = name;
        this.category = category;
        this.isExtra = isExtra;
    }

    public double getPrice(HotDogSize size) {
        if (category == ToppingCategory.REGULAR || category == ToppingCategory.SAUCE) {
            return 0.00;
        }

        if (isExtra) {
            if (category == ToppingCategory.MEAT) {
                switch (size) {
                    case REGULAR:  return 1.00;
                    case FOOTLONG: return 1.50;
                    case JUMBO:    return 2.00;
                }
            } else if (category == ToppingCategory.CHEESE) {
                switch (size) {
                    case REGULAR:  return 0.50;
                    case FOOTLONG: return 1.00;
                    case JUMBO:    return 1.50;
                }
            }
        }

        switch (size) {
            case REGULAR:  return 1.00;
            case FOOTLONG: return 1.50;
            case JUMBO:    return 2.00;
            default:       return 0.00;
        }
    }

    public String getName() {
        return name;
    }

    public ToppingCategory getCategory() {
        return category;
    }

    public boolean isExtra() {
        return isExtra;
    }
}