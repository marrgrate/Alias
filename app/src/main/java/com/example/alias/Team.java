package com.example.alias;

public class Team {
    public String teamName;
    private final int teamId;

    Team(String name){
        teamName = name;
        teamId = (int) Math.random() * Integer.MAX_VALUE;
    }

    public int getTeamId() {
        return teamId;
    }
}
