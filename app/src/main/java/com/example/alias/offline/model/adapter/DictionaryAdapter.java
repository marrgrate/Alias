package com.example.alias.offline.model.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.alias.R;
import com.example.alias.offline.model.Dictionary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DictionaryAdapter extends RecyclerView.Adapter<DictionaryAdapter.ViewHolder> {

    private List<Dictionary> dictionaries = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView disclaimer;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            name = view.findViewById(R.id.dictionary_name);
            disclaimer = view.findViewById(R.id.disclaimer);
        }

        public TextView getName() {
            return name;
        }
        public TextView getDisclaimer() {
            return name;
        }

        public void bind(Dictionary dictionary){
            name.setText(dictionary.getName());
            disclaimer.setText(dictionary.getDisclaimer());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.dictionary_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.bind(dictionaries.get(position));
    }

    @Override
    public int getItemCount() {
        return dictionaries.size();
    }

    public void setItems(Collection<Dictionary> dictionaryList) {
        dictionaries.addAll(dictionaryList);
        notifyDataSetChanged();
    }
}
