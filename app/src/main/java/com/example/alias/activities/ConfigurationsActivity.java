/*package com.example.alias.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.alias.R;
import com.example.alias.offline.model.Game;

public class ConfigurationsActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    TextView curTime;
    TextView curWordsNumber;
    Button buttonNext;
    Game game;
    SeekBar seekBarWords;
    SeekBar seekBarTime;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Intent intent = getIntent();
        game = (Game)intent.getSerializableExtra("game");

        Toolbar toolbar = findViewById(R.id.config_action_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        seekBarWords = findViewById(R.id.seekbar_words);
        seekBarWords.setOnSeekBarChangeListener(this);

        seekBarTime = findViewById(R.id.seekbar_time);
        seekBarTime.setOnSeekBarChangeListener(this);

        curWordsNumber = findViewById(R.id.text_view_cur_words_num);
        curWordsNumber.setText("30");

        curTime = findViewById(R.id.text_view_cur_time);
        curTime.setText("60");

        buttonNext = findViewById(R.id.button_next_config);
    }

    public void onClick(View v) {
        game.setMaxWordsNumber(seekBarWords.getProgress());
        game.setMaxTime(seekBarTime.getProgress());
        Intent intent = new Intent(ConfigurationsActivity.this, DictionariesActivity.class);
        intent.putExtra("game", game);
        startActivity(intent);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar.getId() == R.id.seekbar_time){
            game.setMaxTime(seekBar.getProgress());
            if(seekBar.getProgress()<30)
                seekBar.setProgress(30);
            curTime.setText(String.valueOf(seekBar.getProgress()));
        }
        else if (seekBar.getId() == R.id.seekbar_words){
            game.setMaxWordsNumber(seekBar.getProgress());
            if(seekBar.getProgress()<20)
                seekBar.setProgress(20);
            curWordsNumber.setText(String.valueOf(seekBar.getProgress()));
        }
    }
}*/
