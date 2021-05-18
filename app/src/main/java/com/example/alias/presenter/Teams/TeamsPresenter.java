package com.example.alias.presenter.Teams;

import android.content.Intent;
import com.example.alias.offline.model.Game;
import com.example.alias.offline.model.Team;

public class TeamsPresenter {
    private TeamsView teamsView;
    public Game game;

    public TeamsPresenter(TeamsView teamsView, Game game) {
        this.teamsView = teamsView;
        this.game = game;
    }

    public void onAddClick() {
        game.addTeam();
    }

    public void onDeleteClick() {
        game.teams.remove(game.teams.size() - 1);
    }

    public Intent onNextClick(Intent intent){
        return intent.putExtra("game", game);
    }

    void onResume() {
    }

    void onDestroy() {
    }

    public void onFinished() {
        if (teamsView != null) {
            teamsView.setItems();
        }
    }

    public void onBindTeamsRowViewAtPosition(int position, TeamsRowView rowView){
        Team team = game.getTeams().get(position);
        rowView.setTitle(team.getName());
    }

    public int getTeamsRowsCount() {
        return game.getTeams().size();
    }
}
