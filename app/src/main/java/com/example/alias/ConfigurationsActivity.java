package com.example.alias;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ConfigurationsActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private TextView curTime;
    private TextView curWordsNumber;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Toolbar toolbar = findViewById(R.id.config_action_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final SeekBar seekBarWords = findViewById(R.id.seekbar_words);
        seekBarWords.setOnSeekBarChangeListener(this);

        final SeekBar seekBarTime= findViewById(R.id.seekbar_time);
        seekBarTime.setOnSeekBarChangeListener(this);

        curWordsNumber = findViewById(R.id.text_view_cur_words_num);
        curWordsNumber.setText("60");

        curTime = findViewById(R.id.text_view_cur_time);
        curTime.setText("60");
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar.getId() == R.id.seekbar_time)
            curTime.setText(String.valueOf(seekBar.getProgress()));
        else {
            curWordsNumber.setText(String.valueOf(seekBar.getProgress()));
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, DictionariesActivity.class);
        startActivity(intent);
    }
}
