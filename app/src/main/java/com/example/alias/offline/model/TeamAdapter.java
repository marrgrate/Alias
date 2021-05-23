package com.example.alias.offline.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.alias.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private List<Team> teams = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.team_name);
        }

        public TextView getTextView() {
            return textView;
        }

        public void bind(Team team){
            textView.setText(team.getName());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.team_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.bind(teams.get(position));
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public void setItems(Collection<Team> teamList) {
        teams.addAll(teamList);
        notifyDataSetChanged();
    }

    public void addItem(){
        if(teams.size()<6) {
            Team team = new Team();
            ArrayList<String> teamNames = getTeamsNames();
            while(teamNames.contains(team.getName()))
                team.setRandomName();
            teams.add(team);
            notifyDataSetChanged();
        }
    }

    public ArrayList<String> getTeamsNames(){
        ArrayList<String> teamNames = new ArrayList<>();
        for(Team value: teams)
            teamNames.add(value.getName());
        return teamNames;
    }

    public void deleteItem(){
        if(teams.size()>2)
        teams.remove(teams.size() - 1);
        notifyDataSetChanged();
    }

    public Team getLastItem(){
        return teams.get(getItemCount() - 1);
    }
}
