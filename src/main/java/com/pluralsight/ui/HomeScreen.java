package com.pluralsight.ui;

import java.util.Scanner;

public class HomeScreen {
    private Scanner scanner;

    public HomeScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public int display() {
        String PINK = "\033[1;35m";
        String TEAL = "\033[36m";
        String WHITE = "\033[1;37m";
        String RESET = "\033[0m";

        System.out.println(TEAL + "\n  ╔════════════════════════════════════════════════════╗");
        System.out.println("  ║" + PINK + "  _____ _  _ __  __      _    _ _       " + TEAL + "         ║");
        System.out.println("  ║" + PINK + " |_   _| || |  \\/  |___ | |__(_) |___  " + TEAL + "         ║");
        System.out.println("  ║" + PINK + "   | | |__  | |\\/| / _ \\| '_ \\ | / -_) " + TEAL + "         ║");
        System.out.println("  ║" + PINK + "   |_|   _| |_|  |_\\___/|_.__/_|_\\___| " + TEAL + "         ║");
        System.out.println("  ║" + PINK + "        |__|                            " + TEAL + "         ║");
        System.out.println("  ║" + WHITE + "   ____        _ _                  _    " + TEAL + "    ║");
        System.out.println("  ║" + WHITE + "  | __ )  __ _| | |_ __   __ _ _ __| | __" + TEAL + "    ║");
        System.out.println("  ║" + WHITE + "  |  _ \\ / _` | | | '_ \\ / _` | '__| |/ /" + TEAL + "    ║");
        System.out.println("  ║" + WHITE + "  | |_) | (_| | | | |_) | (_| | |  |   < " + TEAL + "    ║");
        System.out.println("  ║" + WHITE + "  |____/ \\__,_|_|_| .__/ \\__,_|_|  |_|\\_\\" + TEAL + "    ║");
        System.out.println("  ║" + WHITE + "                   |_|                    " + TEAL + "    ║");
        System.out.println("  ╚════════════════════════════════════════════════════╝" + RESET);
        System.out.println("  1) Scan Ticket and Enter");
        System.out.println("  0) Exit");
        System.out.print("  Choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}