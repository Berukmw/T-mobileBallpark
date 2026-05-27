package com.pluralsight.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Priceable> items;
    private LocalDateTime orderDateTime;

    public Order() {
        this.items = new ArrayList<>();
        this.orderDateTime = LocalDateTime.now();
    }

    public void addItem(Priceable item) {
        items.add(item);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public List<Priceable> getItems() {
        return items;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public double getTotal() {
        double total = 0.00;
        for (Priceable item : items) {
            total += item.getPrice();
        }
        return total;
    }
}