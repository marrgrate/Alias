package com.example.alias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ModeMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_menu);

        Toolbar toolbar = findViewById(R.id.mode_action_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.button_offline) {
            Intent intent = new Intent(this, TeamsActivity.class);
            startActivity(intent);
        } else if (id == R.id.button_network) {
            //todo
            Intent intent = new Intent(this, TeamsActivity.class);
            startActivity(intent);
        }
    }
}
