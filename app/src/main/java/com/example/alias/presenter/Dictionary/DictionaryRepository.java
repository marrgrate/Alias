package com.example.alias.presenter.Dictionary;

import com.example.alias.offline.model.Dictionary;

import java.io.IOException;
import java.util.ArrayList;

public class DictionaryRepository {
    public static String[] FILENAME = new String[]{"dictionary1.json", "dictionary1.json"};
    ArrayList<Dictionary> dictionaries = new ArrayList<>();

    public DictionaryRepository(){
        for(String name: FILENAME){
            try {
                dictionaries.add(new Dictionary().loadDictionary(name));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Dictionary> getDictionaries(){
        return dictionaries;
    }

    public String[] getStringDictionaries(){
        String[] str = new String[dictionaries.size()];
        for(int i = 0; i < dictionaries.size(); i++)
            str[i] = dictionaries.get(i).getName();
        return str;
    }

}
