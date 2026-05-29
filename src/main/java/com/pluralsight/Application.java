package com.pluralsight;

import com.pluralsight.model.*;
import com.pluralsight.ui.*;
import com.pluralsight.util.ReceiptManager;
import java.util.Scanner;

public class Application {
    private Scanner scanner;
    private HomeScreen homeScreen;
    private VendorSelectScreen vendorScreen;
    private HotDogStandScreen hotDogScreen;
    private DrinkStandScreen drinkScreen;
    private DippinDotsScreen dotsScreen;
    private SnackStandScreen snackScreen;
    private TeamStoreScreen teamStoreScreen;
    private CheckoutScreen checkoutScreen;

    public Application() {
        this.scanner = new Scanner(System.in);
        this.homeScreen = new HomeScreen(scanner);
        this.vendorScreen = new VendorSelectScreen(scanner);
        this.hotDogScreen = new HotDogStandScreen(scanner);
        this.drinkScreen = new DrinkStandScreen(scanner);
        this.dotsScreen = new DippinDotsScreen(scanner);
        this.snackScreen = new SnackStandScreen(scanner);
        this.teamStoreScreen = new TeamStoreScreen(scanner);
        ReceiptManager receiptManager = new ReceiptManager("receipts");
        this.checkoutScreen = new CheckoutScreen(scanner, receiptManager);
    }

    public void run() {
        Schedule schedule = new Schedule();
        schedule.loadFromCSV("mariners_schedule.csv");

        System.out.println("========================================");
        System.out.println("   Welcome to T-Mobile Park!");
        System.out.println("   Seattle Mariners 2026 Season");
        System.out.println("========================================");
        System.out.print("What date are you visiting? (MM-DD): ");
        String dateInput = scanner.nextLine();

        Matchup matchup = schedule.getMatchup(dateInput);

        if (matchup == null) {
            System.out.println("\nSorry, the ballpark is closed on " + dateInput + ".");
            System.out.println("No game scheduled. Come back on a game day!");
            scanner.close();
            return;
        }

        System.out.println("\n========================================");
        System.out.println("   TODAY'S GAME");
        System.out.println("   Mariners vs " + matchup.getOpponent());
        System.out.println("   " + matchup.getHomeAway() + " | " + matchup.getTime());
        System.out.println("========================================");

        boolean running = true;
        while (running) {
            int choice = homeScreen.display();

            switch (choice) {
                case 1:
                    boolean keepGoing = handleOrder(matchup);
                    if (!keepGoing) {
                        running = false;
                    }
                    break;
                case 0:
                    System.out.println("Thanks for visiting T-Mobile Park!");
                    running = false;
                    break;
            }
        }
        scanner.close();
    }

    private boolean handleOrder(Matchup matchup) {
        Order order = new Order();
        GameScreen gameScreen = new GameScreen(scanner);
        boolean ordering = true;
        boolean gameStarted = false;
        boolean gameOver = false;

        while (ordering) {
            int vendor = vendorScreen.display(order.getItems().size(), !gameOver);

            switch (vendor) {
                case 1:
                    HotDog dog = hotDogScreen.buildHotDog();
                    order.addItem(dog, "Hot Dog Stand");
                    printSwipe();
                    break;
                case 2:
                    Drink drink = drinkScreen.buildDrink();
                    order.addItem(drink, "Drink Stand");
                    printSwipe();
                    break;
                case 3:
                    Sides dots = dotsScreen.buildDippinDots();
                    order.addItem(dots, "Dippin' Dots");
                    printSwipe();
                    break;
                case 4:
                    Sides snack = snackScreen.buildSide();
                    order.addItem(snack, "Snack Stand");
                    printSwipe();
                    break;
                case 5:
                    Merchandise merch = teamStoreScreen.buildMerch();
                    order.addItem(merch, "Team Store");
                    printSwipe();
                    break;
                case 6:
                    if (order.getItems().size() > 0) {
                        checkoutScreen.display(order);
                        ordering = false;
                    }
                    break;
                case 7:
                    if (!gameOver) {
                        if (!gameStarted) {
                            boolean wantsFood = gameScreen.playGame(matchup.getOpponent());
                            gameStarted = true;
                            if (wantsFood) {
                                System.out.println("\nHead to the concourse and grab some food!");
                            } else {
                                gameOver = true;
                                System.out.println("\nThe game is over!");
                                if (order.getItems().size() > 0) {
                                    System.out.println("You have a new text message...\n");
                                    checkoutScreen.display(order);
                                }
                                ordering = false;
                                return false;
                            }
                        } else {
                            gameScreen.resumeGame();
                            gameOver = true;
                            System.out.println("\nThe game is over!");
                            if (order.getItems().size() > 0) {
                                System.out.println("You have a new text message...\n");
                                checkoutScreen.display(order);
                            }
                            ordering = false;
                            return false;
                        }
                    }
                    break;
                case 0:
                    System.out.println("\nYou left T-Mobile Park early.");
                    System.out.println("On your way out, you dropped your credit card!");
                    System.out.println("Someone picked it up and put a charge of $420.00");
                    System.out.println("on your account ending in **4287!\n");
                    System.out.println("Don't worry, Chase Bank has reversed all charges");
                    System.out.println("and cancelled your card.");
                    System.out.println("A new card will be mailed to you in 5-7 business days.\n");
                    System.out.println("Maybe don't leave the ballpark early next time.");
                    ordering = false;
                    break;
            }
        }
        return true;
    }

    private void printSwipe() {
        System.out.println("\n*Card swiped*");
        System.out.println("Transaction approved! Enjoy the game!");
    }
}