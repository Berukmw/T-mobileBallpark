package com.pluralsight.ui;

import com.pluralsight.model.*;
import java.util.Scanner;

public class DippinDotsScreen extends TemplateScreen {

    public DippinDotsScreen(Scanner scanner) {
        super(scanner);
    }

    public Sides buildDippinDots() {
        System.out.println("\n--- Dippin' Dots ---");
        System.out.println("Pick your flavor:");
        System.out.println("1) Cookies & Cream");
        System.out.println("2) Cotton Candy");
        System.out.println("3) Banana Split");
        System.out.println("4) Rainbow Ice");
        System.out.println("5) Mint Chocolate");
        int flavorChoice = getInput("Choice: ", 1, 5);

        String flavor;
        switch (flavorChoice) {
            case 2:  flavor = "Cotton Candy"; break;
            case 3:  flavor = "Banana Split"; break;
            case 4:  flavor = "Rainbow Ice"; break;
            case 5:  flavor = "Mint Chocolate"; break;
            default: flavor = "Cookies & Cream"; break;
        }

        System.out.println("\nPick your size:");
        System.out.println("1) Small ($4.50)");
        System.out.println("2) Large ($6.50)");
        int sizeChoice = getInput("Choice: ", 1, 2);

        String sizeName;
        double price;
        switch (sizeChoice) {
            case 2:  sizeName = "Large"; price = 6.50; break;
            default: sizeName = "Small"; price = 4.50; break;
        }

        Sides dots = new Sides(sizeName + " " + flavor + " Dippin' Dots", price);
        System.out.println("\n>>> " + dots.getDisplayName() + " - $" + String.format("%.2f", dots.getPrice()));
        return dots;
    }
}