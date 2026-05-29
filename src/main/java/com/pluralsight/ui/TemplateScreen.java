package com.pluralsight.ui;

import java.util.Scanner;

public abstract class TemplateScreen {
    protected Scanner scanner;

    public TemplateScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    protected int getInput(String prompt) {
        System.out.print(prompt);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    protected int getInput(String prompt, int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            System.out.print(prompt);
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < min || choice > max) {
                System.out.println("Invalid choice, try again.");
            }
        }
        return choice;
    }

    protected void printHeader(String title) {
        System.out.println("\n========================================");
        System.out.println("   " + title);
        System.out.println("========================================");
    }
}