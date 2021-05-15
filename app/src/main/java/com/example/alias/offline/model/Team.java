package com.example.alias.offline.model;

import java.io.Serializable;

public class Team
implements Serializable {
    private String team;
    public Result result;

    public String getName(){
        return this.team;
    }
    public void setTeam(Team team) {
        this.team = team.team;
        this.result = team.result;
    }
    public String toString() {
        return this.team;
    }

    Team(String name){
        team = name;
    }
}
