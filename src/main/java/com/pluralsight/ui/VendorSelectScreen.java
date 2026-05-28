package com.pluralsight.ui;

import java.util.Scanner;

public class VendorSelectScreen {
    private Scanner scanner;

    public VendorSelectScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public int display() {
        System.out.println("\n========================================");
        System.out.println("   Where would you like to go?");
        System.out.println("========================================");
        System.out.println("1) Hot Dog Stand");
        System.out.println("2) Drink Stand");
        System.out.println("3) Dippin' Dots");
        System.out.println("4) Snack Stand");
        System.out.println("5) Team Store");
        System.out.println("6) Check Text Messages");
        System.out.println("0) Leave the Ballpark");
        System.out.println("========================================");
        System.out.print("Choose a vendor: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}