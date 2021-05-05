package com.example.alias;

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

        ListView listView = (ListView) findViewById(R.id.team_least);
        final ArrayAdapter<Team> adapter = new ArrayAdapter<Team>(this,
                android.R.layout.simple_list_item_1,
                newGame.getTeams());
        listView.setAdapter(adapter);

        EditText editText;
        Button addButton;
        Button deleteButton;

        addButton = (Button)findViewById(R.id.button_add_team);
        deleteButton = (Button)findViewById(R.id.button_delete_team);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                newGame.addDefaultTeam();
                adapter.notifyDataSetChanged();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                newGame.deleteTeam();
                adapter.notifyDataSetChanged();
            }
        });
    }

//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.button_add_team: {
//                newGame.addDefaultTeam();
//                adapter.notifyDataSetChanged();
//                break;
//            }
//            case R.id.button_network: {
//                newGame.deleteTeam();
//                adapter.notifyDataSetChanged();
//                break;
//            }
//            case R.id.button_next: {
//                break;}
//        }
//    }


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

