package com.example.alias.presenter;

import android.content.Intent;
import com.example.alias.offline.model.Game;

public class TeamsPresenter {
    private TeamsView teamsView;
    public Game game;

    public TeamsPresenter(TeamsView teamsView, Game game) {
        this.teamsView = teamsView;
        this.game = game;
    }
    public String[] getData() {
        return game.getTeamsNames();
    }

    void onResume() {
    }

    public void onAddClick() {
        if(game.teams.size() <= 5){
            game.addTeam();
        }
    }

    public void onDeleteClick(){
        if(game.teams.size() > 2){
            game.teams.remove(game.teams.size()-1);
        }
    }

    public Intent onNextClick(Intent intent){
        return intent.putExtra("game", game);
    }

    void onDestroy() {
    }

    public void onFinished() {
    }
}
