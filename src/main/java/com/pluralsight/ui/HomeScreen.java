package com.pluralsight.ui;

import java.util.Scanner;

public class HomeScreen {
    private Scanner scanner;

    public HomeScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public int display() {
        System.out.println("\n========================================");
        System.out.println("   Welcome to T-Mobile Park!");
        System.out.println("========================================");
        System.out.println("1) Scan Ticket and Enter");
        System.out.println("0) Exit");
        System.out.println("========================================");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // clear the newline
        return choice;
    }
}