package com.example.alias;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ConfigurationsActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private TextView curTime;
    private TextView curWordsNumber;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_config);

        Toolbar toolbar = findViewById(R.id.config_action_bar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final SeekBar seekBarWords = (SeekBar)findViewById(R.id.seekbar_words);
        seekBarWords.setOnSeekBarChangeListener(this);

        final SeekBar seekBarTime= (SeekBar)findViewById(R.id.seekbar_time);
        seekBarTime.setOnSeekBarChangeListener(this);

        curWordsNumber = (TextView)findViewById(R.id.text_view_cur_words_num);
        curWordsNumber.setText("0");

        curTime = (TextView)findViewById(R.id.text_view_cur_time);
        curTime.setText("0");
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

}
