package com.example.alias.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.alias.R;
import com.example.alias.offline.model.Dictionary;
import com.example.alias.offline.model.Game;

import java.util.ArrayList;

public class DictionariesActivity extends AppCompatActivity {
    Button buttonNext;
    ListView dictionariesListView;
    public ArrayList<Dictionary> dictionaries = new ArrayList<>();
    Game myGame;
    //todo запись названий словарей из файла в список

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionaries);
        if (savedInstanceState != null) {
            myGame = savedInstanceState.getParcelable("game");
        }

        Toolbar toolbar = findViewById(R.id.dictionaries_action_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dictionariesListView = findViewById(R.id.dictionaries_list);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                myGame.toStringList(dictionaries));
        dictionariesListView.setAdapter(adapter);
        dictionariesListView.setClickable(true);

        buttonNext = findViewById(R.id.button_next_dictionaries);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(DictionariesActivity.this, StartGameActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("game", myGame);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    //todo startActivityForResult
                }
        });

        dictionariesListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dictionariesListView.isClickable()) {
                    //todo если нажат элемент, выделить его
                    dictionariesListView.setSelected(true);
                    myGame.setDictionarySelected(dictionariesListView.getSelectedItem().toString());
                }
            }
        });
    }

}
