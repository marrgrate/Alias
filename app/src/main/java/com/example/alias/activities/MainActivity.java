package com.example.alias.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.alias.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.button_start) {
            Intent intent = new Intent(this, ModeMenuActivity.class);
            startActivity(intent);
        } else if (viewId == R.id.button_rules) {
            Intent intent = new Intent(this, RulesActivity.class);
            startActivity(intent);
        } else if (viewId == R.id.button_exit) {
            this.finishAffinity();
        }
    }
}
