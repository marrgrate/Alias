package com.example.alias.offline.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary
        implements Serializable {
    private String name;
    private String disclaimer;
    private int wordsCount = 0;
    private ArrayList<String> words = new ArrayList<>();
    private ArrayList<String> usedWords = new ArrayList<>();

    public Dictionary(){
        name = "DICTIONARY_NAME";
        disclaimer = "DISCLAIMER";
        wordsCount = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setWordsCount(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public void addWord(String word){
        words.add(word);
    }

    public void addUsedWord(String word) {
        usedWords.add(word);
    }

    public String getRandomWord(){
        if(this.words.size() == 0) {
            return "no_words_in_list";
        }
        if(this.words.size() <= 1){
            this.words.addAll(this.usedWords);
            usedWords.removeAll(words);
        }
        int n = new Random().nextInt(this.words.size());
        String newWord = this.words.get(n);
        this.words.remove(newWord);

        if(this.usedWords.contains(newWord))
            return getRandomWord();
        this.usedWords.add(newWord);
        return newWord;
    }
}
