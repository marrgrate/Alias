package com.example.alias.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.alias.R;

public class FinishGameActivity extends AppCompatActivity {
    TextView textViewWinner;
    Button main_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        String winner = savedInstanceState.getString("winner");

        Toolbar toolbar = findViewById(R.id.mode_action_bar);
        setSupportActionBar(toolbar);

        textViewWinner = findViewById(R.id.winner_name);
        textViewWinner.setText(winner);

        main_menu = findViewById(R.id.button_back_to_menu);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishGameActivity.this, MainActivity.class);
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }
}
