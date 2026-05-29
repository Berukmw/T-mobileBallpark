package com.pluralsight.model;

public class Matchup {
    private String date;
    private String opponent;
    private String homeAway;
    private String time;

    public Matchup(String date, String opponent, String homeAway, String time) {
        this.date = date;
        this.opponent = opponent;
        this.homeAway = homeAway;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getOpponent() {
        return opponent;
    }

    public String getHomeAway() {
        return homeAway;
    }

    public String getTime() {
        return time;
    }
}