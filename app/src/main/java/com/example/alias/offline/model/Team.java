package com.example.alias.offline.model;

import java.io.Serializable;
import java.util.Random;

public class Team
    implements Serializable {
    String[] DEFAULT_NAMES = new String[]{"Хмарачосы", "Тутэйшыя", "Валошкі", "Крумкачы",
            "Дармаеды", "Крывічы", "Палешукі", "Зорачкі"};
    private String name;
    public Result result;

    public Team() {
        setRandomName();
        result = new Result();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRandomName(){
        Random random = new Random();
        this.name = DEFAULT_NAMES[random.nextInt(DEFAULT_NAMES.length - 1) ];
    }

    public String getName(){
        return this.name;
    }

    public Result getResult(){
        return result;
    }

    public void setTeam(Team name) {
        this.name = name.name;
        this.result = name.result;
    }
}
