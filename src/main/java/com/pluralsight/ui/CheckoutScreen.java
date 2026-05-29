package com.pluralsight.ui;

import com.pluralsight.model.*;
import com.pluralsight.util.ReceiptManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckoutScreen extends TemplateScreen {
    private ReceiptManager receiptManager;

    public CheckoutScreen(Scanner scanner, ReceiptManager receiptManager) {
        super(scanner);
        this.receiptManager = receiptManager;
    }

    public boolean display(Order order) {
        List<String> uniqueVendors = new ArrayList<>();
        for (String vendor : order.getVendors()) {
            if (!uniqueVendors.contains(vendor)) {
                uniqueVendors.add(vendor);
            }
        }

        System.out.println("\n========================================");
        System.out.println(" ALERT from 72166 (Chase Fraud Dept)");
        System.out.println("========================================");
        System.out.println(" We noticed unusual activity on your");
        System.out.println(" card ending in **4287 at T-Mobile Park:\n");

        for (String vendor : uniqueVendors) {
            System.out.println(" " + vendor + ":");
            for (int i = 0; i < order.getItems().size(); i++) {
                if (order.getVendors().get(i).equals(vendor)) {
                    Priceable item = order.getItems().get(i);
                    System.out.println("   " + item.getDisplayName() + "  $" + String.format("%.2f", item.getPrice()));

                    if (item instanceof HotDog) {
                        HotDog dog = (HotDog) item;
                        for (Topping t : dog.getToppings()) {
                            String extra = t.isExtra() ? " (Extra)" : "";
                            System.out.println("     - " + t.getName() + extra);
                        }
                    }
                }
            }
        }

        System.out.println("\n Total charges: $" + String.format("%.2f", order.getTotal()));
        System.out.println("\n Were these transactions made by you?");
        System.out.println(" 1) Yes, that was me");
        System.out.println(" 0) No, someone robbed me!");
        System.out.print("\n Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            receiptManager.saveReceipt(order);
            System.out.println("\nAll charges confirmed.");
            System.out.println("Thanks for visiting T-Mobile Park! Enjoy the game!");
            return true;
        } else {
            return handleDispute(order, uniqueVendors);
        }
    }

    private boolean handleDispute(Order order, List<String> uniqueVendors) {
        System.out.println("\nWe're sorry to hear that. All charges have been");
        System.out.println("refunded to your account ending in **4287.\n");
        System.out.println("T-Mobile Park security has been notified.");
        System.out.println("We are reviewing camera footage from the");
        System.out.println("following vendors:");

        for (String vendor : uniqueVendors) {
            System.out.println(" - " + vendor);
        }

        System.out.println("\nA detective by the name of Sasha Iluku will");
        System.out.println("contact you within 24 hours.");
        System.out.println("Case #" + order.getCaseNumber());
        System.out.println("\nStay safe out there.\n");

        System.out.println(" 1) Jk it was me lol");
        System.out.println(" 0) Exit");
        System.out.print("\n Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("\n... We figured.\n");
            System.out.println("Someone who orders:");
            for (int i = 0; i < order.getItems().size(); i++) {
                System.out.println(" - " + order.getItems().get(i).getDisplayName());
            }
            System.out.println("\nwould definitely be you.\n");
            System.out.println("All charges will be restored.");
            System.out.println("Please be a better human next time");
            System.out.println("and not waste our time.\n");
            receiptManager.saveReceipt(order);
            System.out.println("Thanks for visiting T-Mobile Park! Enjoy the game!");
            return true;
        } else {
            System.out.println("\nOrder cancelled.");
            return false;
        }
    }
}