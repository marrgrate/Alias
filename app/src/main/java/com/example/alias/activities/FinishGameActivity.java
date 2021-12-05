/*package com.example.alias.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.alias.R;
import com.example.alias.presentation.MenuActivity;

public class FinishGameActivity extends AppCompatActivity {
    String winner;
    TextView textViewWinner;
    Button main_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_finish);
        Intent intent = getIntent();
        winner = intent.getStringExtra("winner");

        Toolbar toolbar = findViewById(R.id.mode_action_bar);
        setSupportActionBar(toolbar);

        textViewWinner = findViewById(R.id.winner_name);
        textViewWinner.setText(winner);

        main_menu = findViewById(R.id.button_back_to_menu);
        main_menu.setOnClickListener(v -> {
            Intent intent1 = new Intent(FinishGameActivity.this, MenuActivity.class);
            startActivity(intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        });
    }
}
*/