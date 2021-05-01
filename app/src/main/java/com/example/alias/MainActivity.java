package com.example.alias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.button_start: {
                Intent intent = new Intent(this, ModeMenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button_rules: {
                Intent intent = new Intent(this, RulesActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button_exit: {
                System.exit(0);
            }
        }
    }
}
