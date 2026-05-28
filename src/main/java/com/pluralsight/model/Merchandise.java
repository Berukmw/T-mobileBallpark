package com.pluralsight.model;

public class Merchandise implements Priceable {
    private String name;
    private String size;
    private double price;

    public Merchandise(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDisplayName() {
        if (size.isEmpty()) {
            return name;
        }
        return size + " " + name;
    }
}