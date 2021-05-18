package com.example.alias.offline.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.example.alias.presenter.Dictionary.DictionaryParser;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

@SuppressLint("ParcelCreator")
public class Dictionary
        implements DictionaryParser, Serializable {
    public String name;
    public String disclaimer;
    public int words_count = 0;
    public ArrayList<String> words = new ArrayList<>();
    public ArrayList<String> usedWords = new ArrayList<>();

    public Dictionary(){
        name = "DICTIONARY_NAME";
        disclaimer = "DISCLAIMER";
        words_count = 0;
        words.add("word1");
        words.add("word2");
        usedWords.add("used_word1");
    }

    protected Dictionary(Parcel in) {
        name = in.readString();
        disclaimer = in.readString();
        words_count = in.readInt();
        //words = in.readArrayList();
        //usedWords = in.readArrayList();
    }


    public String getName(){
        return name;
    }

    public Dictionary loadDictionary(String filename) throws IOException {
        Dictionary dic = new Dictionary();
        return dic.Parse(dic.readFileAsString(filename));
    }

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
        return gson.fromJson(jsonString, Dictionary.class);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
