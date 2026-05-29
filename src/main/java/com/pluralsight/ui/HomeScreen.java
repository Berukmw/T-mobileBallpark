package com.pluralsight.ui;

import java.util.Scanner;

public class HomeScreen extends TemplateScreen {

    public HomeScreen(Scanner scanner) {
        super(scanner);
    }

    public int display() {
        String PINK = "\033[1;35m";
        String WHITE = "\033[1;37m";
        String RESET = "\033[0m";

        System.out.println(PINK);
        System.out.println("  █████       █   █  ███  ████  ███ █     █████");
        System.out.println("    █         ██ ██ █   █ █   █  █  █     █    ");
        System.out.println("    █   ████  █ █ █ █   █ ████   █  █     ████ ");
        System.out.println("    █         █   █ █   █ █   █  █  █     █    ");
        System.out.println("    █         █   █  ███  ████  ███ █████ █████");
        System.out.println(WHITE);
        System.out.println("  ████   ███  █     █     ████   ███  ████  █  █");
        System.out.println("  █   █ █   █ █     █     █   █ █   █ █   █ █ █ ");
        System.out.println("  ████  █████ █     █     ████  █████ ████  ██  ");
        System.out.println("  █   █ █   █ █     █     █     █   █ █   █ █ █ ");
        System.out.println("  ████  █   █ █████ █████ █     █   █ █   █ █  █" + RESET);
        System.out.println("\n  1) Scan Ticket and Enter");
        System.out.println("  0) Exit");

        return getInput("  Choice: ", 0, 1);
    }

}