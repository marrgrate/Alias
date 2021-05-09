package com.example.alias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class TeamsActivity extends AppCompatActivity{

    private Game newGame = new Game();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        Toolbar toolbar = findViewById(R.id.teams_list_action_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView) findViewById(R.id.team_least);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                newGame.getTeamsNames());
        listView.setAdapter(adapter);

        Button addButton;
        Button deleteButton;
        Button nextButton;

        addButton = findViewById(R.id.button_add_team);
        deleteButton = findViewById(R.id.button_delete_team);
        nextButton = findViewById(R.id.button_next_teams);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.addTeam();
                adapter.notifyDataSetChanged();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.deleteTeam();
                adapter.notifyDataSetChanged();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeamsActivity.this, ConfigurationsActivity.class);
                startActivity(intent);
            }
        });


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> a, View v, int position,
//                                    long id) {
//                Toast.makeText(TeamsActivity.this, "Clicked", Toast.LENGTH_LONG)
//                        .show();
//            }
//        });
//    }


//    edtText.addTextChangedListener(new TextWatcher() {
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            // TODO Auto-generated method stub
//        }
//
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count,
//        int after) {
//            // TODO Auto-generated method stub
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//            // TODO Auto-generated method stub
//            if (!edtText.getText().toString().equalsIgnoreCase("")){
//
//                // here textview.setText(edtText.getText());
//
//            }
//        }
//    });
}

