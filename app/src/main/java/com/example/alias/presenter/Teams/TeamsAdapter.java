package com.example.alias.presenter.Teams;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.alias.R;

public class TeamsAdapter
        extends RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder>{
    TeamsPresenter presenter;
    public TeamsAdapter(TeamsPresenter presenter){
        this.presenter = presenter;
    }
    @NonNull
    @Override
    public TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_view, parent, false);
        return new TeamsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsViewHolder holder, int position) {
        presenter.onBindTeamsRowViewAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getTeamsRowsCount();
    }

    static class TeamsViewHolder extends RecyclerView.ViewHolder
            implements TeamsRowView {
        TextView textView;
        TeamsViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }
        public void setTitle(String title){
            textView.setText(title);
        }
    }
}
