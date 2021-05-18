package com.example.alias.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.alias.R;
import com.example.alias.offline.model.Dictionary;
import com.example.alias.presenter.Dictionary.DictionaryRepository;
import com.example.alias.presenter.Dictionary.DictionariesPresenter;
import com.example.alias.presenter.Dictionary.DictionariesView;

import java.util.ArrayList;

import static android.view.View.VISIBLE;

public class DictionariesActivity extends AppCompatActivity
    implements DictionariesView {

    Button buttonNext;
    ListView dictionariesListView;
    DictionariesPresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionaries);

        Toolbar toolbar = findViewById(R.id.dictionaries_action_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonNext = findViewById(R.id.button_next_dictionaries);
        dictionariesListView = findViewById(R.id.dictionaries_list);
        presenter = new DictionariesPresenter(this, new DictionaryRepository());

        Intent intent = getIntent();
        presenter.getExtra(intent);
    }

    @Override
    public void onButtonClick() {
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DictionariesActivity.this, StartGameActivity.class);
                presenter.putExtra(intent);
                intent = presenter.onNextClick(intent);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(){
        if(dictionariesListView.isClickable()) {
            //todo если нажат элемент, выделить его
            dictionariesListView.setSelected(true);
        }
    }

    @Override
    public void showDictionaries(ArrayList<Dictionary> d) {
        dictionariesListView.setVisibility(VISIBLE);
        final ArrayAdapter<Dictionary> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                d);
        dictionariesListView.setAdapter(adapter);
        dictionariesListView.setClickable(true);
    }

    @Override
    public void showError(){
        Toast.makeText(this, "No dictionary selected", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
