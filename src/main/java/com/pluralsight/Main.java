package com.pluralsight;

import com.pluralsight.model.*;
import com.pluralsight.ui.*;
import com.pluralsight.util.ReceiptManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HomeScreen homeScreen = new HomeScreen(scanner);
        VendorSelectScreen vendorScreen = new VendorSelectScreen(scanner);
        HotDogStandScreen hotDogScreen = new HotDogStandScreen(scanner);
        DrinkStandScreen drinkScreen = new DrinkStandScreen(scanner);
        DippinDotsScreen dotsScreen = new DippinDotsScreen(scanner);
        SnackStandScreen snackScreen = new SnackStandScreen(scanner);
        TeamStoreScreen teamStoreScreen = new TeamStoreScreen(scanner);
        ReceiptManager receiptManager = new ReceiptManager("receipts");
        CheckoutScreen checkoutScreen = new CheckoutScreen(scanner, receiptManager);

        boolean running = true;
        while (running) {
            int choice = homeScreen.display();

            switch (choice) {
                case 1:
                    Order order = new Order();
                    boolean ordering = true;
                    while (ordering) {
                        int vendor = vendorScreen.display();
                        switch (vendor) {
                            case 1:
                                HotDog dog = hotDogScreen.buildHotDog();
                                order.addItem(dog, "Hot Dog Stand");
                                System.out.println("\n*Card swiped*");
                                System.out.println("Transaction approved! Enjoy the game!");
                                break;
                            case 2:
                                Drink drink = drinkScreen.buildDrink();
                                order.addItem(drink, "Drink Stand");
                                System.out.println("\n*Card swiped*");
                                System.out.println("Transaction approved! Enjoy the game!");
                                break;
                            case 3:
                                Sides dots = dotsScreen.buildDippinDots();
                                order.addItem(dots, "Dippin' Dots");
                                System.out.println("\n*Card swiped*");
                                System.out.println("Transaction approved! Enjoy the game!");
                                break;
                            case 4:
                                Sides snack = snackScreen.buildSide();
                                order.addItem(snack, "Snack Stand");
                                System.out.println("\n*Card swiped*");
                                System.out.println("Transaction approved! Enjoy the game!");
                                break;
                            case 5:
                                Merchandise merch = teamStoreScreen.buildMerch();
                                order.addItem(merch, "Team Store");
                                System.out.println("\n*Card swiped*");
                                System.out.println("Transaction approved! Enjoy the game!");
                                break;
                            case 6:
                                if (order.getItems().size() == 0) {
                                    System.out.println("You haven't bought anything yet!");
                                } else {
                                    checkoutScreen.display(order);
                                    ordering = false;
                                }
                                break;
                            case 0:
                                System.out.println("\nYou left T-Mobile Park early.");
                                System.out.println("On your way out, you dropped your credit card!");
                                System.out.println("Someone picked it up and put a charge of $420.00");
                                System.out.println("on your account ending in **4287!\n");
                                System.out.println("Don't worry, Chase Bank has reversed all charges");
                                System.out.println("and cancelled your card.");
                                System.out.println("A new card will be mailed to you in 5-7 business days.\n");
                                System.out.println("Maybe don't leave the ballpark early next time.");
                                ordering = false;
                                break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Thanks for visiting T-Mobile Park!");
                    running = false;
                    break;
            }
        }
        scanner.close();
    }
}