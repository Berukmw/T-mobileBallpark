package com.pluralsight;

import com.pluralsight.model.*;
import com.pluralsight.ui.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HomeScreen homeScreen = new HomeScreen(scanner);
        VendorSelectScreen vendorScreen = new VendorSelectScreen(scanner);
        HotDogStandScreen hotDogScreen = new HotDogStandScreen(scanner);

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
                                order.addItem(dog);
                                System.out.println("Added to order! Enjoy the game!");
                                break;
                            case 6:
                                System.out.println(order.getOrderDetails());
                                ordering = false;
                                break;
                            case 0:
                                System.out.println("Order cancelled.");
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