package com.example.alias.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.alias.R;
import com.example.alias.offline.model.Game;

public class ResultActivity extends AppCompatActivity {
    Game game;
    Button nextButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        if (savedInstanceState != null) {
            game = savedInstanceState.getParcelable("game");
        }

        Toolbar toolbar = findViewById(R.id.result_action_bar);
        setSupportActionBar(toolbar);

        nextButton = findViewById(R.id.button_next_result);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent;
                if(game.teamPlaying.result.getResult() <= game.getMaxWordsNumber()) {
                    //todo запуск startGameActivity для следующей команды
                    intent = new Intent(ResultActivity.this, StartGameActivity.class);
                    intent.putExtra("game", game);
                } else {
                    intent = new Intent(ResultActivity.this, FinishGameActivity.class);
                    intent.putExtra("winner", game.teamPlaying);
                }
                startActivity(intent);

            }
        }
        //todo если командой достигнуто максимальное количество очков - создать FinishGameActivity
        );

    }
}
