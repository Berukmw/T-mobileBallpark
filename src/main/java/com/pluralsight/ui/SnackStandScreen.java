package com.pluralsight.ui;

import com.pluralsight.model.*;
import java.util.Scanner;

public class SnackStandScreen extends TemplateScreen {

    public SnackStandScreen(Scanner scanner) {
        super(scanner);
    }

    public Sides buildSide() {
        System.out.println("\n--- Snack Stand ---");
        System.out.println("1) Garlic Fries ($6.00)");
        System.out.println("2) Soft Pretzel ($5.00)");
        System.out.println("3) Peanuts ($4.00)");
        System.out.println("4) Cracker Jacks ($3.50)");
        System.out.println("5) Kettle Corn ($4.50)");
        System.out.println("6) Popcorn ($3.50)");
        int choice = getInput("Choice: ", 1, 6);

        Sides side;
        switch (choice) {
            case 2:  side = new Sides("Soft Pretzel", 5.00); break;
            case 3:  side = new Sides("Peanuts", 4.00); break;
            case 4:  side = new Sides("Cracker Jacks", 3.50); break;
            case 5:  side = new Sides("Kettle Corn", 4.50); break;
            case 6:  side = new Sides("Popcorn", 3.50); break;
            default: side = new Sides("Garlic Fries", 6.00); break;
        }

        System.out.println("\n>>> " + side.getDisplayName() + " - $" + String.format("%.2f", side.getPrice()));
        return side;
    }
}