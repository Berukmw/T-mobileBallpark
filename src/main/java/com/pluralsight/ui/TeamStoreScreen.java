package com.pluralsight.ui;

import com.pluralsight.model.*;
import java.util.Scanner;

public class TeamStoreScreen extends TemplateScreen {

    public TeamStoreScreen(Scanner scanner) {
        super(scanner);
    }

    public Merchandise buildMerch() {
        System.out.println("\n--- Team Store ---");
        System.out.println("1) Jersey ($149.99)");
        System.out.println("2) Hat ($34.99)");
        System.out.println("3) Sticker ($5.99)");
        System.out.println("4) Ball Boy Baseball ($12.99)");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: return buildJersey();
            case 2: return buildHat();
            case 4: return buildBallBoy();
            default: return buildSticker();
        }
    }

    private Merchandise buildJersey() {
        System.out.println("\nPick your size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.println("4) XL");
        System.out.print("Choice: ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        String size;
        switch (sizeChoice) {
            case 2:  size = "Medium"; break;
            case 3:  size = "Large"; break;
            case 4:  size = "XL"; break;
            default: size = "Small"; break;
        }

        System.out.println("\nPick a player:");
        System.out.println("1) Julio Rodriguez #44");
        System.out.println("2) Cal Raleigh #29");
        System.out.println("3) Ichiro Suzuki #51");
        System.out.println("4) Ken Griffey Jr. #24");
        System.out.println("5) Yoel Weldeselassie #00");
        System.out.print("Choice: ");
        int playerChoice = scanner.nextInt();
        scanner.nextLine();

        String player;
        switch (playerChoice) {
            case 2:  player = "Raleigh #29"; break;
            case 3:  player = "Ichiro #51"; break;
            case 4:  player = "Griffey Jr. #24"; break;
            case 5:  player = "Yoel #00"; break;
            default: player = "Rodriguez #44"; break;
        }

        Merchandise jersey = new Merchandise(player + " Jersey", size, 149.99);
        System.out.println("\n>>> " + jersey.getDisplayName() + " - $" + String.format("%.2f", jersey.getPrice()));
        return jersey;
    }

    private Merchandise buildHat() {
        System.out.println("\nPick your style:");
        System.out.println("1) Classic Navy");
        System.out.println("2) Teal Alternate");
        System.out.println("3) City Connect");
        System.out.print("Choice: ");
        int styleChoice = scanner.nextInt();
        scanner.nextLine();

        String style;
        switch (styleChoice) {
            case 2:  style = "Teal Alternate"; break;
            case 3:  style = "City Connect"; break;
            default: style = "Classic Navy"; break;
        }

        Merchandise hat = new Merchandise(style + " Hat", "", 34.99);
        System.out.println("\n>>> " + hat.getDisplayName() + " - $" + String.format("%.2f", hat.getPrice()));
        return hat;
    }

    private Merchandise buildSticker() {
        System.out.println("\nPick your sticker:");
        System.out.println("1) Mariners Logo");
        System.out.println("2) Trident");
        System.out.println("3) Moose");
        System.out.print("Choice: ");
        int stickerChoice = scanner.nextInt();
        scanner.nextLine();

        String sticker;
        switch (stickerChoice) {
            case 2:  sticker = "Trident"; break;
            case 3:  sticker = "Moose"; break;
            default: sticker = "Mariners Logo"; break;
        }

        Merchandise stickerItem = new Merchandise(sticker + " Sticker", "", 5.99);
        System.out.println("\n>>> " + stickerItem.getDisplayName() + " - $" + String.format("%.2f", stickerItem.getPrice()));
        return stickerItem;
    }

    private Merchandise buildBallBoy() {
        Merchandise ball = new Merchandise("Ball Boy Signed Baseball", "", 12.99);
        System.out.println("\n>>> " + ball.getDisplayName() + " - $" + String.format("%.2f", ball.getPrice()));
        return ball;
    }
}