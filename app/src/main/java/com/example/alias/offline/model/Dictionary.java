package com.example.alias.offline.model;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public abstract class Dictionary
        implements DictionaryParser {
    public String name;
    public String difficulty;
    public String disclaimer;
    public int words_count = 0;
    public ArrayList<String> words = new ArrayList<>();
    public ArrayList<String> usedWords = new ArrayList<>();

    public String getRandomWord(){
        if(this.words.size() == 0) {
            return "no_words_in_list";
        }
        if(this.words.size() <= 1){
            this.words.addAll(this.usedWords);
        }

        int n = new Random().nextInt(this.words.size());
        String newWord = this.words.get(n);
        this.words.remove(newWord);
        if(this.usedWords.contains(newWord))
            return getRandomWord();
        this.usedWords.add(newWord);
        return newWord;
    }

    public String readFileAsString(String filename) throws IOException {
        StringBuilder fileData = new StringBuilder();
        BufferedReader reader = new BufferedReader(
                new FileReader(filename));
        char[] buf = new char[1024];
        int numRead;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
    public Dictionary Parse(String jsonString) {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString, Dictionary.class);
    }
}
