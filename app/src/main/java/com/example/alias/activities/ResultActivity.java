package com.example.alias.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.alias.R;
import com.example.alias.offline.model.Game;

public class ResultActivity extends AppCompatActivity {
    Game game;
    TextView guessedWords;
    TextView skippedWords;
    TextView general;
    Button nextButton;
    ListView usedWords;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        game = (Game)intent.getSerializableExtra("game");

        Toolbar toolbar = findViewById(R.id.result_action_bar);
        setSupportActionBar(toolbar);

        guessedWords = findViewById(R.id.text_view_guessed_num);
        skippedWords = findViewById(R.id.text_view_skipped_num);
        general = findViewById(R.id.text_view_general_result);
        usedWords = findViewById(R.id.passed_words_list);

        guessedWords.setText(game.getTeamPlaying().getResult().getGuessed()+"");
        skippedWords.setText(game.getTeamPlaying().getResult().getSkipped()+"");
        general.setText(game.getTeamPlaying().getResult().getResult()+"");

        //todo вывод использованных слов
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,
//                game.getUsedWords());
//        usedWords.setAdapter(adapter);

        nextButton = findViewById(R.id.button_next_result);
        nextButton.setOnClickListener(v -> {
            Intent intent1;
            if(game.getTeamPlaying().result.getResult() <= game.getMaxWordsNumber()) {
                intent1 = new Intent(ResultActivity.this, StartGameActivity.class);
                game.getTeamPlaying().getResult().resetRoundResult();
                game.setTeamPlaying();
                intent1.putExtra("game", game);
                //todo startActivityForResult
            } else {
                intent1 = new Intent(ResultActivity.this, FinishGameActivity.class);
                intent1.putExtra("winner", game.getTeamPlaying());
            }
            startActivity(intent1);
        }
        );
    }
}
