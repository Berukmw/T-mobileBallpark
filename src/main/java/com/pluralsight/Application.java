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

        System.out.println("\n   Seattle Mariners 2026 Season");
        System.out.println("   Loading...\n");
        System.out.print("What date are you visiting? (MM-DD): ");
        String dateInput = scanner.nextLine();

        Matchup matchup = schedule.getMatchup(dateInput);

        if (matchup == null) {
            System.out.println("\nSorry, the ballpark is closed on " + dateInput + ".");
            System.out.println("No game scheduled. Come back on a game day!");
            scanner.close();
            return;
        }

        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║  T-MOBILE PARK              ||||| |||| ||||| ||||   ║");
        System.out.println("║  Seattle Mariners            |||| ||||| |||| |||||  ║");
        System.out.println("║  vs " + String.format("%-25s", matchup.getOpponent()) + " ||||| |||| ||||| ||||   ║");
        System.out.println("║                              |||| ||||| |||| |||||  ║");
        System.out.println("║  " + matchup.getHomeAway() + " | " + String.format("%-22s", matchup.getTime()) + "||||| |||| ||||| ||||   ║");
        System.out.println("║  2026 Season                 |||| ||||| |||| |||||  ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

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

        playAudio("playball.wav");

        while (ordering) {
            int vendor = vendorScreen.display(order.getItems().size(), !gameOver);

            switch (vendor) {
                case 1:
                    boolean stayAtDogs = true;
                    while (stayAtDogs) {
                        HotDog dog = hotDogScreen.buildHotDog();
                        if (dog != null) {
                            order.addItem(dog, "Hot Dog Stand");
                            System.out.println("Added to order!");
                        }
                        if (vendorPrompt("Hot Dog Stand") == 0) stayAtDogs = false;
                    }
                    printSwipe();
                    break;
                case 2:
                    boolean stayAtDrinks = true;
                    while (stayAtDrinks) {
                        Drink drink = drinkScreen.buildDrink();
                        if (drink != null) {
                            order.addItem(drink, "Drink Stand");
                            System.out.println("Added to order!");
                        }
                        if (vendorPrompt("Drink Stand") == 0) stayAtDrinks = false;
                    }
                    printSwipe();
                    break;
                case 3:
                    boolean stayAtDots = true;
                    while (stayAtDots) {
                        Sides dots = dotsScreen.buildDippinDots();
                        if (dots != null) {
                            order.addItem(dots, "Dippin' Dots");
                            System.out.println("Added to order!");
                        }
                        if (vendorPrompt("Dippin' Dots") == 0) stayAtDots = false;
                    }
                    printSwipe();
                    break;
                case 4:
                    boolean stayAtSnacks = true;
                    while (stayAtSnacks) {
                        Sides snack = snackScreen.buildSide();
                        if (snack != null) {
                            order.addItem(snack, "Snack Stand");
                            System.out.println("Added to order!");
                        }
                        if (vendorPrompt("Snack Stand") == 0) stayAtSnacks = false;
                    }
                    printSwipe();
                    break;
                case 5:
                    boolean stayAtStore = true;
                    while (stayAtStore) {
                        Merchandise merch = teamStoreScreen.buildMerch();
                        if (merch != null) {
                            order.addItem(merch, "Team Store");
                            System.out.println("Added to order!");
                        }
                        if (vendorPrompt("Team Store") == 0) stayAtStore = false;
                    }
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
                                    System.out.println("While heading home you notice a text message...\n");
                                    System.out.println("1) Check Text Message");
                                    while (true) {
                                        System.out.print("Choice: ");
                                        try {
                                            scanner.nextInt();
                                            scanner.nextLine();
                                            break;
                                        } catch (Exception e) {
                                            scanner.nextLine();
                                            System.out.println("Please enter a number.");
                                        }
                                    }
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
                                System.out.println("While heading home you notice a text message...\n");
                                System.out.println("1) Check Text Message");
                                while (true) {
                                    System.out.print("Choice: ");
                                    try {
                                        scanner.nextInt();
                                        scanner.nextLine();
                                        break;
                                    } catch (Exception e) {
                                        scanner.nextLine();
                                        System.out.println("Please enter a number.");
                                    }
                                }
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
                    System.out.println("Someone picked it up and put a charge of $67.00");
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

    private int vendorPrompt(String vendorName) {
        System.out.println("\n1) Order more from " + vendorName);
        System.out.println("0) Leave " + vendorName);
        while (true) {
            System.out.print("Choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 0 || choice == 1) return choice;
                System.out.println("Invalid choice, try again.");
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Please enter a number.");
            }
        }
    }

    private void playAudio(String fileName) {
        try {
            java.io.File audioFile = new java.io.File(fileName);
            if (audioFile.exists()) {
                javax.sound.sampled.AudioInputStream audio = javax.sound.sampled.AudioSystem.getAudioInputStream(audioFile);
                javax.sound.sampled.Clip clip = javax.sound.sampled.AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            }
        } catch (Exception e) {
            // No audio, no problem
        }
    }

    private void printSwipe() {
        System.out.println("\n*Card swiped*");
        System.out.println("Transaction approved! Enjoy the game!");
    }
}