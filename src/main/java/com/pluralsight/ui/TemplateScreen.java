package com.pluralsight.ui;

import java.util.Scanner;

public abstract class TemplateScreen {
    protected Scanner scanner;

    public TemplateScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    protected int getInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Please enter a number.");
            }
        }
    }

    protected int getInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Invalid choice, try again.");
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Please enter a number.");
            }
        }
    }

    protected void printHeader(String title) {
        System.out.println("\n========================================");
        System.out.println("   " + title);
        System.out.println("========================================");
    }
}