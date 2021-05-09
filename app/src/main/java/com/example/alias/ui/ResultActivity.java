package com.example.alias.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.alias.R;

public class ResultActivity extends AppCompatActivity {
    Button nextButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Toolbar toolbar = findViewById(R.id.result_action_bar);
        setSupportActionBar(toolbar);

        nextButton = findViewById(R.id.button_next_result);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }                                     }
        );

    }
}
