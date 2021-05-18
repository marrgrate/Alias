package com.example.alias.activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.alias.R;
import com.example.alias.network.CreateGameActivity;

public class ModeMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_menu);

        Toolbar toolbar = findViewById(R.id.mode_action_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.button_offline) {
            Intent intent = new Intent(this, TeamsActivity.class);
            intent.putExtra("mode", "offline");
            startActivity(intent);
        } else if (id == R.id.button_network) {
            if (!isOnline()) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "No internet connection", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                Intent intent = new Intent(this, CreateGameActivity.class);
                intent.putExtra("mode", "network");
                startActivity(intent);
            }
        }
    }
    public boolean isOnline() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
