package com.example.alias;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.button_start) {
            Intent intent = new Intent(MainActivity.this, ModeMenuActivity.class);
            startActivity(intent);
        } else if (viewId == R.id.button_rules) {
            Intent intent = new Intent(MainActivity.this, RulesActivity.class);
            startActivity(intent);
        } else if (viewId == R.id.button_exit) {
            this.finishAffinity();
        }
    }

//    @Override
//    public void onConfigurationChanged(@NonNull Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        //обработка конфигураций
//    }
}
