package com.example.alias.offline.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dictionary implements Serializable {
    public String name;
    public String difficulty;
    public String disclaimer;
    public ArrayList<String> words = new ArrayList<String>();
    public ArrayList<String> usedWords = new ArrayList<String>();
    public int wordsCount = 0;

    public String getRandomWord(){
        return "randomWord";
    }

}
