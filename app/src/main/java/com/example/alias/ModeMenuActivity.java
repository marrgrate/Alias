package com.example.alias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ModeMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_menu);
    }
    public void onOfflineClicked(View view){
        Intent intent = new Intent(this, TeamsActivity.class);
        startActivity(intent);
    }
    public void onCancelClicked(View view){
        finish();
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.button_offline: {
                Intent intent = new Intent(this, TeamsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button_network: {

                break;
            }
        }
    }
}
