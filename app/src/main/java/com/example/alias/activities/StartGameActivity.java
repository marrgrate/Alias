package com.example.alias.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.alias.R;
import com.example.alias.offline.model.Game;

public class StartGameActivity extends AppCompatActivity {
    Game myGame;
    TextView timer;
    TextView teamPlays;
    ImageButton skipButton;
    ImageButton acceptButton;
    TextView word;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        if (savedInstanceState != null) {
            myGame = savedInstanceState.getParcelable("game");
        }

        skipButton = findViewById(R.id.button_skip);
        acceptButton= findViewById(R.id.button_accept);
        teamPlays = findViewById(R.id.text_view_team_name);
        //todo определить команду которая играет
        teamPlays.setText(myGame.teamPlaying.toString());
        skipButton.setVisibility(View.INVISIBLE);
        acceptButton.setVisibility(View.INVISIBLE);

        word = findViewById(R.id.word);
    }

    public void onClick(View view){
        if(view.getId() == R.id.start_game){
            view.setVisibility(View.INVISIBLE);
            timer = findViewById(R.id.timer);
            new CountDownTimer(60000, 1000) {

                public void onTick(long millisUntilFinished) {
                    timer.setText((millisUntilFinished/1000) < 10?
                            "00:0"+ millisUntilFinished / 1000 :
                            "00:"+ millisUntilFinished / 1000);
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
