package com.example.alias.offline.model;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class JSONHelper {
    public final static String FILE_NAME0 = "dictionary0.json";
    public final static String FILE_NAME1 = "dictionary1.json";
    public static String getJsonFromAssets(Context context, String filename){

            String json;
            try {
                InputStream is = context.getAssets().open(filename);
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return json;
    }
}
