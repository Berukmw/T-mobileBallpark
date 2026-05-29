package com.pluralsight.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<Matchup> games;

    public Schedule() {
        this.games = new ArrayList<>();
    }

    public void loadFromCSV(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String date = parts[0].trim();
                    String opponent = parts[1].trim();
                    String homeAway = parts[2].trim();
                    String time = parts[3].trim();
                    games.add(new Matchup(date, opponent, homeAway, time));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading schedule: " + e.getMessage());
        }
    }

    public Matchup getMatchup(String monthDay) {
        for (Matchup game : games) {
            if (game.getDate().equals(monthDay)) {
                return game;
            }
        }
        return null;
    }
}