package com.example.alias.network;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.alias.R;

public class CreateGameActivity extends AppCompatActivity {
    Button create;
    Button join;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_config);

        Toolbar toolbar = findViewById(R.id.create_game_action_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        create = findViewById(R.id.create_game_button);
        join = findViewById(R.id.join_game_button);
    }

    public void onClick(View v){
        Intent intent = new Intent(this, KeyActivity.class);
        if(v.getId() == R.id.create_game_button) {
            intent.putExtra("status", "host");
            startActivity(intent);
        }
        else if(v.getId() == R.id.join_game_button){
            intent.putExtra("status", "guest");
            startActivity(intent);
        }
    }
}
