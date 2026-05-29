package com.pluralsight.ui;

import java.util.Scanner;

public class VendorSelectScreen extends TemplateScreen {

    public VendorSelectScreen(Scanner scanner) {
        super(scanner);
    }

    public int display(int itemCount, boolean gameAvailable) {
        System.out.println("\n========================================");
        System.out.println("   Where would you like to go?");
        System.out.println("========================================");
        System.out.println("1) Hot Dog Stand");
        System.out.println("2) Drink Stand");
        System.out.println("3) Dippin' Dots");
        System.out.println("4) Snack Stand");
        System.out.println("5) Team Store");
        if (itemCount > 0) {
            System.out.println("6) New Text From 72166");
        }
        if (gameAvailable) {
            System.out.println("7) Watch the Game");
        }
        System.out.println("0) Leave the Ballpark");
        System.out.println("========================================");
        System.out.print("Choose a vendor: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}