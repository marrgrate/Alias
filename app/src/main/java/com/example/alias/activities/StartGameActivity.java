/*
package com.example.alias.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.alias.R;
import com.example.alias.offline.model.Game;

public class StartGameActivity extends AppCompatActivity {
    Game game;
    TextView timer;
    TextView teamPlays;
    Button buttonStart;
    ImageButton skipButton;
    ImageButton acceptButton;
    TextView word;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_game_process);
        Intent intent = getIntent();
        game = (Game) intent.getSerializableExtra("game");

        skipButton = findViewById(R.id.button_skip);
        acceptButton= findViewById(R.id.button_accept);
        buttonStart = findViewById(R.id.start_game);
        teamPlays = findViewById(R.id.text_view_team_name);
        word = findViewById(R.id.word);

        teamPlays.setText(game.getTeamPlaying().getName());
        skipButton.setVisibility(View.INVISIBLE);
        acceptButton.setVisibility(View.INVISIBLE);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                timer = findViewById(R.id.timer);
                new CountDownTimer(game.getMaxTime()* 1000L, 1000) {
                    public void onTick(long millisUntilFinished) {
                        timer.setText((millisUntilFinished/1000) < 10?
                                "00:0"+ millisUntilFinished / 1000 :
                                "00:"+ millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        Intent intent;
                        if(game.getTeamPlaying().getResult().getResult() < game.getMaxWordsNumber())
                        {
                            intent = new Intent(StartGameActivity.this, ResultActivity.class);
                            game.getTeamPlaying().getResult().recountResult();
                        } else {
                            intent = new Intent(StartGameActivity.this, FinishGameActivity.class);
                        }
                        intent.putExtra("game", game);
                        startActivity(intent);
                        finish();
                    }
                }
                        .start();
                skipButton.setVisibility(View.VISIBLE);
                acceptButton.setVisibility(View.VISIBLE);
            }
        });

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.getTeamPlaying().result.addPoint();
                String w = game.getDictionarySelected().getRandomWord();
                game.getDictionarySelected().addUsedWord(w);
                word.setText(w);
            }
        });

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.getTeamPlaying().result.subtractPoint();
                String w = game.getDictionarySelected().getRandomWord();
                game.getDictionarySelected().addUsedWord(w);
                word.setText(w);
            }
        });
    }
}
*/
