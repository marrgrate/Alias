package com.example.alias.presenter.Dictionary;

import android.os.Parcelable;
import com.example.alias.offline.model.Dictionary;

import java.io.IOException;

public interface DictionaryParser extends Parcelable {
    String readFileAsString(String filename) throws IOException;

    Dictionary Parse(String jsonString);
}
