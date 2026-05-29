package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class HotDog implements Priceable {
    private HotDogSize size;
    private HotDogType type;
    private List<Topping> toppings;
    private boolean loaded;
    private String customName;

    public HotDog(HotDogSize size, HotDogType type) {
        this.size = size;
        this.type = type;
        this.toppings = new ArrayList<>();
        this.loaded = false;
        this.customName = null;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public HotDogSize getSize() {
        return size;
    }

    public HotDogType getType() {
        return type;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    @Override
    public double getPrice() {
        double total = 0.00;

        switch (size) {
            case REGULAR:  total = 5.00; break;
            case FOOTLONG: total = 7.00; break;
            case JUMBO:    total = 9.00; break;
        }

        for (Topping topping : toppings) {
            total += topping.getPrice(size);
        }

        return total;
    }

    @Override
    public String getDisplayName() {
        String sizeName = "";
        switch (size) {
            case REGULAR:  sizeName = "Regular"; break;
            case FOOTLONG: sizeName = "Footlong"; break;
            case JUMBO:    sizeName = "Jumbo"; break;
        }

        if (customName != null) {
            return sizeName + " " + customName;
        }

        String typeName = "";
        switch (type) {
            case CLASSIC: typeName = "Classic"; break;
            case BEEF:    typeName = "Beef"; break;
            case TURKEY:  typeName = "Turkey"; break;
            case VEGGIE:  typeName = "Veggie"; break;
        }

        return sizeName + " " + typeName + " Hot Dog" + (loaded ? " (Loaded)" : "");
    }
}