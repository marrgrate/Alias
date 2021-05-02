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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start: {
                Intent intent = new Intent(MainActivity.this, ModeMenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button_rules: {
                Intent intent = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button_exit: {
                this.finishAffinity();
                break;
            }
        }
    }
}
