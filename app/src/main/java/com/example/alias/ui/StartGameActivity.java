package com.example.alias.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.alias.R;

public class StartGameActivity extends AppCompatActivity {
    TextView timer;
    ImageButton skipButton;
    ImageButton acceptButton;
    TextView word;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        skipButton = (ImageButton)findViewById(R.id.button_skip);
        acceptButton= (ImageButton)findViewById(R.id.button_accept);

        skipButton.setVisibility(View.INVISIBLE);
        acceptButton.setVisibility(View.INVISIBLE);

        word = findViewById(R.id.word);
    }

    public void onClick(View view){
        if(view.getId() == R.id.start_game){
            view.setVisibility(View.INVISIBLE);
            timer = (TextView)findViewById(R.id.timer);
            new CountDownTimer(60000, 1000) {

                public void onTick(long millisUntilFinished) {
                    timer.setText("00:"+ millisUntilFinished / 1000);
                }

                public void onFinish() {
                    Intent intent = new Intent(StartGameActivity.this, ResultActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
                    .start();

            skipButton.setVisibility(View.VISIBLE);
            acceptButton.setVisibility(View.VISIBLE);
        } else if(view.getId()==R.id.button_accept) {
            word.setText("new word accept");
        } else if(view.getId()==R.id.button_skip) {
            word.setText("new word skipped");
        }
    }
}
