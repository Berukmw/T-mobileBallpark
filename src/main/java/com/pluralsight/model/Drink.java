package com.pluralsight.model;

public class Drink implements Priceable {
    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public DrinkSize getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {
        if (flavor.equals("Water")) {
            return 2.00;
        }

        switch (size) {
            case SMALL:  return 3.00;
            case MEDIUM: return 4.00;
            case LARGE:  return 5.00;
            default:     return 0.00;
        }
    }

    @Override
    public String getDisplayName() {
        String sizeName = "";
        switch (size) {
            case SMALL:  sizeName = "Small"; break;
            case MEDIUM: sizeName = "Medium"; break;
            case LARGE:  sizeName = "Large"; break;
        }

        if (flavor.equals("Water")) {
            return "Water";
        }

        return sizeName + " " + flavor;
    }
}