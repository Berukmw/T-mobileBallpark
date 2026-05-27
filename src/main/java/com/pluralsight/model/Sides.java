package com.pluralsight.model;

public class Sides implements Priceable {
    private String name;
    private double price;

    public Sides(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDisplayName() {
        return name;
    }
}