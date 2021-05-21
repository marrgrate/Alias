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
            // Define click listener for the ViewHolder's View
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
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.team_view, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.bind(teams.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
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
            teams.add(new Team());
            notifyDataSetChanged();
        }
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
