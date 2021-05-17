package com.example.alias.offline.model;

import java.io.Serializable;

public class Team
implements Serializable {
    private String name;
    public Result result;

    public Team() {
        name = "NULL";
    }

    public String getName(){
        return this.name;
    }

    public void setName(Team name) {
        this.name = name.name;
        this.result = name.result;
    }
    public Team(String name){
        this.name = name;
    }
}
