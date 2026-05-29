package com.pluralsight.ui;

import java.util.Random;
import java.util.Scanner;

public class GameScreen {
    private Scanner scanner;
    private Random random;
    private int savedMarinersScore;
    private int savedOpponentScore;
    private String savedOpponent;

    public GameScreen(Scanner scanner) {
        this.scanner = scanner;
        this.random = new Random();
    }

    public boolean playGame(String opponent) {
        int marinersScore = 0;
        int opponentScore = 0;

        System.out.println("\n========================================");
        System.out.println("   PLAY BALL!");
        System.out.println("   Mariners vs " + opponent);
        System.out.println("========================================");

        for (int inning = 1; inning <= 7; inning++) {
            int marinersRuns = random.nextInt(3);
            int opponentRuns = random.nextInt(3);
            marinersScore += marinersRuns;
            opponentScore += opponentRuns;

            System.out.println("Inning " + inning + ": Mariners " + marinersScore + " - " + opponent + " " + opponentScore);
        }

        // 7th inning stretch audio
        javax.sound.sampled.Clip clip = null;
        try {
            java.io.File audioFile = new java.io.File("stretch.wav");
            if (audioFile.exists()) {
                javax.sound.sampled.AudioInputStream audio = javax.sound.sampled.AudioSystem.getAudioInputStream(audioFile);
                clip = javax.sound.sampled.AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            }
        } catch (Exception e) {
            // No audio, no problem
        }

        System.out.println("\n========================================");
        System.out.println("   7th INNING STRETCH!");
        System.out.println("========================================");
        System.out.println("   Mariners " + marinersScore + " - " + opponent + " " + opponentScore);
        System.out.println("\n   Last call!");
        System.out.println("   1) Yeah let me wander");
        System.out.println("   2) Nah I'm staying in my seat");
        System.out.print("   Choice: ");
        int stretchChoice = scanner.nextInt();
        scanner.nextLine();

        if (clip != null) {
            clip.stop();
            clip.close();
        }

        if (stretchChoice == 1) {
            this.savedMarinersScore = marinersScore;
            this.savedOpponentScore = opponentScore;
            this.savedOpponent = opponent;
            return true;
        }

        finishGame(marinersScore, opponentScore, opponent);
        return false;
    }

    public void resumeGame() {
        finishGame(savedMarinersScore, savedOpponentScore, savedOpponent);
    }

    private void finishGame(int marinersScore, int opponentScore, String opponent) {
        System.out.println("\n========================================");
        System.out.println("   Back to the game!");
        System.out.println("========================================");

        for (int inning = 8; inning <= 9; inning++) {
            int marinersRuns = random.nextInt(3);
            int opponentRuns = random.nextInt(3);
            marinersScore += marinersRuns;
            opponentScore += opponentRuns;

            System.out.println("Inning " + inning + ": Mariners " + marinersScore + " - " + opponent + " " + opponentScore);
        }

        if (marinersScore == opponentScore) {
            System.out.println("\n========================================");
            System.out.println("   TIE GAME! EXTRA INNINGS!");
            System.out.println("========================================");
            System.out.println("   Mariners " + marinersScore + " - " + opponent + " " + opponentScore);
            System.out.println("\n   1) Stay for extras");
            System.out.println("   0) Leave (you'll miss the ending!)");
            System.out.print("   Choice: ");
            int extraChoice = scanner.nextInt();
            scanner.nextLine();

            if (extraChoice == 0) {
                marinersScore += random.nextInt(4) + 1;
                System.out.println("\nYou left early... the Mariners won without you.");
                System.out.println("Final: Mariners " + marinersScore + " - " + opponent + " " + opponentScore);
                return;
            }

            int extraInning = 10;
            while (marinersScore == opponentScore) {
                int marinersRuns = random.nextInt(4) + 1;
                int opponentRuns = random.nextInt(2);
                marinersScore += marinersRuns;
                opponentScore += opponentRuns;

                System.out.println("Inning " + extraInning + ": Mariners " + marinersScore + " - " + opponent + " " + opponentScore);
                extraInning++;
            }

            if (opponentScore > marinersScore) {
                marinersScore = opponentScore + random.nextInt(4) + 1;
            }
        }

        if (opponentScore >= marinersScore) {
            marinersScore = opponentScore + random.nextInt(3) + 1;
        }

        System.out.println("\n========================================");
        System.out.println("   FINAL SCORE");
        System.out.println("   Mariners " + marinersScore + " - " + opponent + " " + opponentScore);
        System.out.println("========================================");
        System.out.println("   MARINERS WIN!");
        System.out.println("========================================");
    }
}