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
        int choice = getInput("Choice: ", 1, 4);

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
        int sizeChoice = getInput("Choice: ", 1, 4);

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
        int playerChoice = getInput("Choice: ", 1, 5);

        String player;
        switch (playerChoice) {
            case 2:  player = "Raleigh #29"; break;
            case 3:  player = "Ichiro #51"; break;
            case 4:  player = "Griffey Jr. #24"; break;
            case 5:  player = "Weldeselassie #00"; break;
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
        int styleChoice = getInput("Choice: ", 1, 3);

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
        String TEAL = "\033[36m";
        String NAVY = "\033[34m";
        String WHITE = "\033[1;37m";
        String YELLOW = "\033[1;33m";
        String GREEN = "\033[32m";
        String RESET = "\033[0m";

        System.out.println("\nPick your sticker:");
        System.out.println("1) Mariners Logo");
        System.out.println("2) Trident");
        System.out.println("3) Moose");
        System.out.println("4) Go M's");
        System.out.println("5) Compass");
        int stickerChoice = getInput("Choice: ", 1, 5);

        String sticker;
        switch (stickerChoice) {
            case 1:
                sticker = "Mariners Logo";
                System.out.println(TEAL + "  ╔═══════════════╗");
                System.out.println("  ║   " + WHITE + "S E A" + TEAL + "       ║");
                System.out.println("  ║     " + YELLOW + "⚓" + TEAL + "         ║");
                System.out.println("  ║  " + NAVY + "MARINERS" + TEAL + "      ║");
                System.out.println("  ╚═══════════════╝" + RESET);
                break;
            case 2:
                sticker = "Trident";
                System.out.println(TEAL + "  ╔═══════════════╗");
                System.out.println("  ║  " + YELLOW + "\\  |  /" + TEAL + "      ║");
                System.out.println("  ║   " + YELLOW + "\\ | /" + TEAL + "       ║");
                System.out.println("  ║    " + YELLOW + "\\|/" + TEAL + "        ║");
                System.out.println("  ║     " + YELLOW + "|" + TEAL + "         ║");
                System.out.println("  ╚═══════════════╝" + RESET);
                break;
            case 3:
                sticker = "Moose";
                System.out.println(GREEN + "  ╔═══════════════╗");
                System.out.println("  ║  " + YELLOW + "\\/    \\/" + GREEN + "     ║");
                System.out.println("  ║   " + YELLOW + "\\    /" + GREEN + "      ║");
                System.out.println("  ║   " + YELLOW + "(o  o)" + GREEN + "      ║");
                System.out.println("  ║    " + YELLOW + "\\  /" + GREEN + "       ║");
                System.out.println("  ║   " + WHITE + "MOOSE" + GREEN + "       ║");
                System.out.println("  ╚═══════════════╝" + RESET);
                break;
            case 4:
                sticker = "Go M's";
                System.out.println(NAVY + "  ╔═══════════════╗");
                System.out.println("  ║  " + WHITE + "GO M's!" + NAVY + "      ║");
                System.out.println("  ║    " + TEAL + "⚾ ⚾" + NAVY + "       ║");
                System.out.println("  ║  " + TEAL + "SEA 2026" + NAVY + "      ║");
                System.out.println("  ╚═══════════════╝" + RESET);
                break;
            default:
                sticker = "Compass";
                System.out.println(TEAL + "  ╔═══════════════╗");
                System.out.println("  ║      " + WHITE + "N" + TEAL + "        ║");
                System.out.println("  ║      " + WHITE + "|" + TEAL + "        ║");
                System.out.println("  ║  " + WHITE + "W---" + YELLOW + "*" + WHITE + "---E" + TEAL + "    ║");
                System.out.println("  ║      " + WHITE + "|" + TEAL + "        ║");
                System.out.println("  ║      " + WHITE + "S" + TEAL + "        ║");
                System.out.println("  ╚═══════════════╝" + RESET);
                break;
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