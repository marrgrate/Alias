package com.example.alias.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.alias.R;
import com.example.alias.offline.model.Dictionary;
import com.example.alias.offline.model.DictionaryDeserializer;
import com.example.alias.offline.model.Game;
import com.example.alias.offline.model.JSONHelper;
import com.example.alias.offline.model.adapter.DictionaryAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DictionariesActivity extends AppCompatActivity {

    Game game;
    ArrayList<Dictionary> dictionaries = new ArrayList<>();
    RecyclerView recyclerView;
    Button buttonNext;

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionaries);

        Intent intent = getIntent();
        game = (Game) intent.getSerializableExtra("game");

        Toolbar toolbar = findViewById(R.id.dictionaries_action_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonNext = findViewById(R.id.button_next_dictionaries);
        buttonNext.setClickable(false);
        recyclerView = findViewById(R.id.dictionaries_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final DictionaryAdapter adapter = new DictionaryAdapter();

        String jsonFileString1 = null;
        String jsonFileString2 = null;
        try {
            jsonFileString1 = JSONHelper.getJsonFromAssets(getApplicationContext(), "dictionary0.json");
            jsonFileString2 = JSONHelper.getJsonFromAssets(getApplicationContext(), "dictionary1.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Type dictionary = new TypeToken<Dictionary>() {
        }.getType();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(dictionary, new DictionaryDeserializer())
                .create();
        Dictionary d = gson.fromJson(jsonFileString1, Dictionary.class);
        dictionaries.add(d);
        d = gson.fromJson(jsonFileString2, Dictionary.class);
        dictionaries.add(d);

        adapter.setItems(dictionaries);

        recyclerView.setAdapter(adapter);

        buttonNext.setOnClickListener(v -> {
            //todo добавить проверку выбран ли словарь
            Intent intent1 = new Intent(DictionariesActivity.this, StartGameActivity.class);
            game.setDictionarySelected(dictionaries.get(0));
            intent1.putExtra("game", game);
            startActivity(intent1);
        });
    }
}
