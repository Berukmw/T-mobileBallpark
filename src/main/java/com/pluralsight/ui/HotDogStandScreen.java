package com.pluralsight.ui;

import com.pluralsight.model.*;
import java.util.Scanner;

public class HotDogStandScreen {
    private Scanner scanner;

    public HotDogStandScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public HotDog buildHotDog() {
        // Step 1: Pick size
        System.out.println("\n--- Hot Dog Stand ---");
        System.out.println("Pick your size:");
        System.out.println("1) Regular ($5.00)");
        System.out.println("2) Footlong ($7.00)");
        System.out.println("3) Jumbo ($9.00)");
        System.out.print("Choice: ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        HotDogSize size;
        switch (sizeChoice) {
            case 2:  size = HotDogSize.FOOTLONG; break;
            case 3:  size = HotDogSize.JUMBO; break;
            default: size = HotDogSize.REGULAR; break;
        }

        // Step 2: Pick type
        System.out.println("\nPick your dog type:");
        System.out.println("1) Classic");
        System.out.println("2) Beef");
        System.out.println("3) Turkey");
        System.out.println("4) Veggie");
        System.out.print("Choice: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        HotDogType type;
        switch (typeChoice) {
            case 2:  type = HotDogType.BEEF; break;
            case 3:  type = HotDogType.TURKEY; break;
            case 4:  type = HotDogType.VEGGIE; break;
            default: type = HotDogType.CLASSIC; break;
        }

        HotDog dog = new HotDog(size, type);

        // Step 3: Premium Meats
        System.out.print("\nWould you like premium meats? (1=Yes, 2=No): ");
        int wantsMeat = scanner.nextInt();
        scanner.nextLine();

        if (wantsMeat == 1) {
            String[] meats = {"Chili", "Bacon", "Extra Sausage"};
            System.out.println("\n--- Premium Meats ---");
            for (int i = 0; i < meats.length; i++) {
                System.out.println((i + 1) + ") " + meats[i]);
            }
            System.out.println("0) Done");

            int meatChoice = -1;
            while (meatChoice != 0) {
                System.out.print("Add meat (0 when done): ");
                meatChoice = scanner.nextInt();
                scanner.nextLine();

                if (meatChoice >= 1 && meatChoice <= meats.length) {
                    dog.addTopping(new Topping(meats[meatChoice - 1], ToppingCategory.MEAT, false));
                    System.out.println("Added " + meats[meatChoice - 1] + "!");

                    System.out.print("Extra " + meats[meatChoice - 1] + "? (1=Yes, 2=No): ");
                    int extraChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (extraChoice == 1) {
                        dog.addTopping(new Topping(meats[meatChoice - 1], ToppingCategory.MEAT, true));
                        System.out.println("Added extra " + meats[meatChoice - 1] + "!");
                    }
                } else if (meatChoice != 0) {
                    System.out.println("Invalid choice, try again.");
                }
            }
        }

        // Step 4: Cheese
        System.out.print("\nWould you like cheese? (1=Yes, 2=No): ");
        int wantsCheese = scanner.nextInt();
        scanner.nextLine();

        if (wantsCheese == 1) {
            String[] cheeses = {"American", "Cheddar", "Pepper Jack", "Swiss"};
            System.out.println("\n--- Cheese ---");
            for (int i = 0; i < cheeses.length; i++) {
                System.out.println((i + 1) + ") " + cheeses[i]);
            }
            System.out.println("0) Done");

            int cheeseChoice = -1;
            while (cheeseChoice != 0) {
                System.out.print("Add cheese (0 when done): ");
                cheeseChoice = scanner.nextInt();
                scanner.nextLine();

                if (cheeseChoice >= 1 && cheeseChoice <= cheeses.length) {
                    dog.addTopping(new Topping(cheeses[cheeseChoice - 1], ToppingCategory.CHEESE, false));
                    System.out.println("Added " + cheeses[cheeseChoice - 1] + "!");

                    System.out.print("Extra " + cheeses[cheeseChoice - 1] + "? (1=Yes, 2=No): ");
                    int extraChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (extraChoice == 1) {
                        dog.addTopping(new Topping(cheeses[cheeseChoice - 1], ToppingCategory.CHEESE, true));
                        System.out.println("Added extra " + cheeses[cheeseChoice - 1] + "!");
                    }
                } else if (cheeseChoice != 0) {
                    System.out.println("Invalid choice, try again.");
                }
            }
        }

        // Step 5: Regular Toppings
        System.out.print("\nWould you like toppings? (1=Yes, 2=No): ");
        int wantsToppings = scanner.nextInt();
        scanner.nextLine();

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
                System.out.print("Add topping (0 when done): ");
                topChoice = scanner.nextInt();
                scanner.nextLine();

                if (topChoice >= 1 && topChoice <= toppings.length) {
                    dog.addTopping(new Topping(toppings[topChoice - 1], ToppingCategory.REGULAR, false));
                    System.out.println("Added " + toppings[topChoice - 1] + "!");
                } else if (topChoice != 0) {
                    System.out.println("Invalid choice, try again.");
                }
            }
        }

        // Step 6: Sauces
        System.out.print("\nWould you like sauces? (1=Yes, 2=No): ");
        int wantsSauces = scanner.nextInt();
        scanner.nextLine();

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
                System.out.print("Add sauce (0 when done): ");
                sauceChoice = scanner.nextInt();
                scanner.nextLine();

                if (sauceChoice >= 1 && sauceChoice <= sauces.length) {
                    dog.addTopping(new Topping(sauces[sauceChoice - 1], ToppingCategory.SAUCE, false));
                    System.out.println("Added " + sauces[sauceChoice - 1] + "!");
                } else if (sauceChoice != 0) {
                    System.out.println("Invalid choice, try again.");
                }
            }
        }

        // Step 7: Loaded?
        System.out.print("\nMake it loaded? (grilled onions & peppers) (1=Yes, 2=No): ");
        int loadedChoice = scanner.nextInt();
        scanner.nextLine();
        if (loadedChoice == 1) {
            dog.setLoaded(true);
        }

        // Show what they built
        System.out.println("\n>>> " + dog.getDisplayName() + " - $" + String.format("%.2f", dog.getPrice()));

        return dog;
    }
}