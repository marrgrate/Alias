package com.example.alias.offline.model;

import java.io.Serializable;
import java.util.Random;

public class Team
    implements Serializable {
    private String name;
    public Result result;

    public Team() {
        //todo проверка на уникальность
        Random random = new Random();
        String[] DEFAULT_NAMES = new String[]{"Хмарачосы", "Тутэйшыя", "Валошкі", "Крумкачы",
        "Дармаеды", "Крывічы", "Палешукі"};
        name = DEFAULT_NAMES[random.nextInt(DEFAULT_NAMES.length)];
        result = new Result();
    }

    public String getName(){
        return this.name;
    }

    public void setName(Team name) {
        this.name = name.name;
        this.result = name.result;
    }

    public Result getResult(){
        return result;
    }
}
