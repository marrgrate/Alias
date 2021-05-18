package com.example.alias.presenter.Dictionary;

import com.example.alias.offline.model.Dictionary;

import java.util.ArrayList;

public interface DictionariesView {
    void showDictionaries(ArrayList<Dictionary> data);

    void onButtonClick();

    void onItemSelected();

    void showError();
}
