package com.pluralsight.ui;

import com.pluralsight.model.*;
import java.util.Scanner;

public class HotDogStandScreen extends TemplateScreen {

    public HotDogStandScreen(Scanner scanner) {
        super(scanner);
    }

    public HotDog buildHotDog() {
        System.out.println("\n--- Hot Dog Stand ---");
        System.out.println("1) Build Your Own");
        System.out.println("2) Seattle Dog (cream cheese, grilled onions)");
        System.out.println("3) Polish Dog (turkey, sauerkraut, mustard, grilled onions)");
        int menuChoice = getInput("Choice: ", 1, 3);

        switch (menuChoice) {
            case 2: return buildSeattleDog();
            case 3: return buildPolishDog();
            default: return buildCustomDog();
        }
    }

    private HotDogSize pickSize() {
        System.out.println("\nPick your size:");
        System.out.println("1) Regular ($5.00)");
        System.out.println("2) Footlong ($7.00)");
        System.out.println("3) Jumbo ($9.00)");
        int sizeChoice = getInput("Choice: ", 1, 3);

        switch (sizeChoice) {
            case 2:  return HotDogSize.FOOTLONG;
            case 3:  return HotDogSize.JUMBO;
            default: return HotDogSize.REGULAR;
        }
    }

    private void printDogSummary(HotDog dog) {
        System.out.println("\n>>> " + dog.getDisplayName());
        for (Topping t : dog.getToppings()) {
            String extra = t.isExtra() ? " (Extra)" : "";
            System.out.println("    - " + t.getName() + extra);
        }
        System.out.println("    Price: $" + String.format("%.2f", dog.getPrice()));
    }

    private HotDog buildSeattleDog() {
        HotDogSize size = pickSize();

        HotDog dog = new HotDog(size, HotDogType.CLASSIC);
        dog.setCustomName("Seattle Dog");
        dog.addTopping(new Topping("Cream Cheese", ToppingCategory.CHEESE, false));
        dog.addTopping(new Topping("Grilled Onions", ToppingCategory.REGULAR, false));
        dog.setLoaded(true);

        printDogSummary(dog);
        return dog;
    }

    private HotDog buildPolishDog() {
        HotDogSize size = pickSize();

        HotDog dog = new HotDog(size, HotDogType.TURKEY);
        dog.setCustomName("Polish Dog");
        dog.addTopping(new Topping("Sauerkraut", ToppingCategory.REGULAR, false));
        dog.addTopping(new Topping("Mustard", ToppingCategory.SAUCE, false));
        dog.addTopping(new Topping("Grilled Onions", ToppingCategory.REGULAR, false));

        printDogSummary(dog);
        return dog;
    }

    private HotDog buildCustomDog() {
        HotDogSize size = pickSize();

        System.out.println("\nPick your dog type:");
        System.out.println("1) Classic");
        System.out.println("2) Beef");
        System.out.println("3) Turkey");
        System.out.println("4) Veggie");
        int typeChoice = getInput("Choice: ", 1, 4);

        HotDogType type;
        switch (typeChoice) {
            case 2:  type = HotDogType.BEEF; break;
            case 3:  type = HotDogType.TURKEY; break;
            case 4:  type = HotDogType.VEGGIE; break;
            default: type = HotDogType.CLASSIC; break;
        }

        HotDog dog = new HotDog(size, type);

        int wantsMeat = getInput("\nWould you like premium meats? (1=Yes, 2=No): ", 1, 2);

        if (wantsMeat == 1) {
            String[] meats = {"Chili", "Bacon", "Extra Sausage"};
            System.out.println("\n--- Premium Meats ---");
            for (int i = 0; i < meats.length; i++) {
                System.out.println((i + 1) + ") " + meats[i]);
            }
            System.out.println("0) Done");

            int meatChoice = -1;
            while (meatChoice != 0) {
                meatChoice = getInput("Add meat (0 when done): ", 0, meats.length);

                if (meatChoice >= 1 && meatChoice <= meats.length) {
                    dog.addTopping(new Topping(meats[meatChoice - 1], ToppingCategory.MEAT, false));
                    System.out.println("Added " + meats[meatChoice - 1] + "!");

                    int extraChoice = getInput("Extra " + meats[meatChoice - 1] + "? (1=Yes, 2=No): ", 1, 2);
                    if (extraChoice == 1) {
                        dog.addTopping(new Topping(meats[meatChoice - 1], ToppingCategory.MEAT, true));
                        System.out.println("Added extra " + meats[meatChoice - 1] + "!");
                    }
                }
            }
        }

        int wantsCheese = getInput("\nWould you like cheese? (1=Yes, 2=No): ", 1, 2);

        if (wantsCheese == 1) {
            String[] cheeses = {"American", "Cheddar", "Pepper Jack", "Swiss"};
            System.out.println("\n--- Cheese ---");
            for (int i = 0; i < cheeses.length; i++) {
                System.out.println((i + 1) + ") " + cheeses[i]);
            }
            System.out.println("0) Done");

            int cheeseChoice = -1;
            while (cheeseChoice != 0) {
                cheeseChoice = getInput("Add cheese (0 when done): ", 0, cheeses.length);

                if (cheeseChoice >= 1 && cheeseChoice <= cheeses.length) {
                    dog.addTopping(new Topping(cheeses[cheeseChoice - 1], ToppingCategory.CHEESE, false));
                    System.out.println("Added " + cheeses[cheeseChoice - 1] + "!");

                    int extraChoice = getInput("Extra " + cheeses[cheeseChoice - 1] + "? (1=Yes, 2=No): ", 1, 2);
                    if (extraChoice == 1) {
                        dog.addTopping(new Topping(cheeses[cheeseChoice - 1], ToppingCategory.CHEESE, true));
                        System.out.println("Added extra " + cheeses[cheeseChoice - 1] + "!");
                    }
                }
            }
        }

        int wantsToppings = getInput("\nWould you like toppings? (1=Yes, 2=No): ", 1, 2);

        if (wantsToppings == 1) {
            String[] toppings = {"Onions", "Relish", "Sauerkraut", "Jalapenos",
                    "Diced Tomatoes", "Sport Peppers", "Pickles", "Coleslaw"};
            System.out.println("\n--- Toppings (Free) ---");
            for (int i = 0; i < toppings.length; i++) {
                System.out.println((i + 1) + ") " + toppings[i]);
            }
            System.out.println("0) Done");

            int topChoice = -1;
            while (topChoice != 0) {
                topChoice = getInput("Add topping (0 when done): ", 0, toppings.length);

                if (topChoice >= 1 && topChoice <= toppings.length) {
                    dog.addTopping(new Topping(toppings[topChoice - 1], ToppingCategory.REGULAR, false));
                    System.out.println("Added " + toppings[topChoice - 1] + "!");
                }
            }
        }

        int wantsSauces = getInput("\nWould you like sauces? (1=Yes, 2=No): ", 1, 2);

        if (wantsSauces == 1) {
            String[] sauces = {"Ketchup", "Mustard", "Spicy Mustard",
                    "Sriracha", "Mayo", "Relish Sauce"};
            System.out.println("\n--- Sauces (Free) ---");
            for (int i = 0; i < sauces.length; i++) {
                System.out.println((i + 1) + ") " + sauces[i]);
            }
            System.out.println("0) Done");

            int sauceChoice = -1;
            while (sauceChoice != 0) {
                sauceChoice = getInput("Add sauce (0 when done): ", 0, sauces.length);

                if (sauceChoice >= 1 && sauceChoice <= sauces.length) {
                    dog.addTopping(new Topping(sauces[sauceChoice - 1], ToppingCategory.SAUCE, false));
                    System.out.println("Added " + sauces[sauceChoice - 1] + "!");
                }
            }
        }

        int loadedChoice = getInput("\nMake it loaded? (grilled onions & peppers) (1=Yes, 2=No): ", 1, 2);
        if (loadedChoice == 1) {
            dog.setLoaded(true);
        }

        printDogSummary(dog);
        return dog;
    }
}