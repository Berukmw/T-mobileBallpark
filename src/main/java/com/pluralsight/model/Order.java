package com.pluralsight.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Priceable> items;
    private List<String> vendors;
    private LocalDateTime orderDateTime;

    public Order() {
        this.items = new ArrayList<>();
        this.vendors = new ArrayList<>();
        this.orderDateTime = LocalDateTime.now();
    }

    public void addItem(Priceable item, String vendor) {
        items.add(item);
        vendors.add(vendor);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            vendors.remove(index);
        }
    }

    public List<Priceable> getItems() {
        return items;
    }

    public List<String> getVendors() {
        return vendors;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public String getCaseNumber() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return "TMB-" + orderDateTime.format(formatter);
    }

    public double getTotal() {
        double total = 0.00;
        for (Priceable item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public String getOrderDetails() {
        String details = "";
        details += "===== T-Mobile Park Receipt =====\n";

        for (int i = 0; i < items.size(); i++) {
            Priceable item = items.get(i);
            details += vendors.get(i) + "\n";
            details += "  " + item.getDisplayName();
            details += " - $" + String.format("%.2f", item.getPrice()) + "\n";
        }

        details += "=================================\n";
        details += "Total Spent: $" + String.format("%.2f", getTotal()) + "\n";
        return details;
    }
}