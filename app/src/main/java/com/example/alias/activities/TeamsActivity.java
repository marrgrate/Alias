package com.example.alias.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.alias.R;
import com.example.alias.offline.model.Game;
import com.example.alias.offline.model.TeamAdapter;

public class TeamsActivity extends AppCompatActivity {
    Game game = new Game();
    Toolbar toolbar;
    RecyclerView recyclerView;
    Button addTeam;
    Button deleteTeam;
    Button next;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String mode = intent.getStringExtra("mode");
        if (mode.equals("offline")) {
            setContentView(R.layout.activity_teams);

            toolbar = findViewById(R.id.teams_list_action_bar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            addTeam = findViewById(R.id.button_add_team);
            deleteTeam = findViewById(R.id.button_delete_team);
            next = findViewById(R.id.button_next_teams);

            recyclerView = findViewById(R.id.teams_recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            final TeamAdapter adapter = new TeamAdapter();
            adapter.setItems(game.getTeams());
            recyclerView.setAdapter(adapter);

            addTeam.setOnClickListener(v -> {
                adapter.addItem();
                if(game.teams.size()<6)
                    game.teams.add(adapter.getLastItem());
                recyclerView.setAdapter(adapter);
            });

            deleteTeam.setOnClickListener(v -> {
                adapter.deleteItem();
                if(game.teams.size()>2)
                    game.teams.remove(game.teams.size() - 1);
                recyclerView.setAdapter(adapter);
            });

            next.setOnClickListener(v -> {
                Intent intent1 = new Intent(TeamsActivity.this, ConfigurationsActivity.class);
                intent1.putExtra("game", game);
                startActivity(intent1);
            });
        } else if (mode.equals("network")) {
            //todo for network game
            toolbar = findViewById(R.id.teams_list_action_bar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}

