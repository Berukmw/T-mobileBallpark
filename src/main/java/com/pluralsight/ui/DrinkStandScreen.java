package com.pluralsight.ui;

import com.pluralsight.model.*;
import java.util.Scanner;

public class DrinkStandScreen extends TemplateScreen {

    public DrinkStandScreen(Scanner scanner) {
        super(scanner);
    }

    public Drink buildDrink() {
        System.out.println("\n--- Drink Stand ---");
        System.out.println("Pick your drink:");
        System.out.println("1) Coca-Cola");
        System.out.println("2) Sprite");
        System.out.println("3) Fanta");
        System.out.println("4) Dr. Pepper");
        System.out.println("5) Lemonade");
        System.out.println("6) Iced Tea");
        System.out.println("7) Water ($2.00)");
        System.out.print("Choice: ");
        int drinkChoice = scanner.nextInt();
        scanner.nextLine();

        String flavor;
        switch (drinkChoice) {
            case 2:  flavor = "Sprite"; break;
            case 3:  flavor = "Fanta"; break;
            case 4:  flavor = "Dr. Pepper"; break;
            case 5:  flavor = "Lemonade"; break;
            case 6:  flavor = "Iced Tea"; break;
            case 7:  flavor = "Water"; break;
            default: flavor = "Coca-Cola"; break;
        }

        // Water is flat price, skip size
        if (flavor.equals("Water")) {
            Drink drink = new Drink(DrinkSize.SMALL, flavor);
            System.out.println("\n>>> " + drink.getDisplayName() + " - $" + String.format("%.2f", drink.getPrice()));
            return drink;
        }

        System.out.println("\nPick your size:");
        System.out.println("1) Small ($3.00)");
        System.out.println("2) Medium ($4.00)");
        System.out.println("3) Large ($5.00)");
        System.out.print("Choice: ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        DrinkSize size;
        switch (sizeChoice) {
            case 2:  size = DrinkSize.MEDIUM; break;
            case 3:  size = DrinkSize.LARGE; break;
            default: size = DrinkSize.SMALL; break;
        }

        Drink drink = new Drink(size, flavor);
        System.out.println("\n>>> " + drink.getDisplayName() + " - $" + String.format("%.2f", drink.getPrice()));
        return drink;
    }
}