package com.example.alias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class TeamsActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        final Game newGame = new Game();
        newGame.addDefaultTeam();   //1 team
        newGame.addDefaultTeam();   //2 team

        Toolbar toolbar = findViewById(R.id.teams_list_action_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView) findViewById(R.id.team_least);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                newGame.getTeamsNames());
        listView.setAdapter(adapter);

        EditText editText;
        Button addButton;
        Button deleteButton;

        addButton = (Button)findViewById(R.id.button_add_team);
        deleteButton = (Button)findViewById(R.id.button_delete_team);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newGame.addDefaultTeam();
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

    }

    public void onClick(View view) {
        int viewId = view.getId();
        if(viewId == R.id.button_next_teams) {
            Intent intent = new Intent(this, ConfigurationsActivity.class);
            startActivity(intent);
        }
    }


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

