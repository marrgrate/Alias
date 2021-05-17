package com.example.alias.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.example.alias.R;
import com.example.alias.offline.model.Game;
import com.example.alias.presenter.TeamsAdapter;
import com.example.alias.presenter.TeamsPresenter;
import com.example.alias.presenter.TeamsView;

public class TeamsActivity extends AppCompatActivity
        implements TeamsView {
    RecyclerView listView;
    Toolbar toolbar;
    Button addTeam;
    Button deleteTeam;
    Button next;
    TeamsPresenter teamsPresenter;
    TeamsAdapter adapter;

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

            listView = findViewById(R.id.teams_recycler_view);
            addTeam = findViewById(R.id.button_add_team);
            deleteTeam = findViewById(R.id.button_delete_team);
            next = findViewById(R.id.button_next_teams);
            teamsPresenter = new TeamsPresenter(this, new Game());

        } else if (mode.equals("network")) {
                //todo for network game
                toolbar = findViewById(R.id.teams_list_action_bar);
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }

    public void setItems() {
        listView.setAdapter(adapter = new TeamsAdapter(teamsPresenter));
    }

    @Override
    public void onAddClick(){
        teamsPresenter.onAddClick();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDeleteClick() {
        teamsPresenter.onDeleteClick();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onNextClick(View v) {
        Intent intent = new Intent(this, ConfigurationsActivity.class);
        intent = teamsPresenter.onNextClick(intent);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Define what your app should do if no activity can handle the intent.
        }
    }

}