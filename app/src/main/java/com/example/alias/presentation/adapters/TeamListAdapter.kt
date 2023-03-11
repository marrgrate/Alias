package com.example.alias.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.alias.R
import com.example.alias.domain.entities.Team
import com.example.alias.presentation.adapters.callbacks.TeamDiffCallback
import com.example.alias.presentation.viewmodels.TeamListViewModel

class   TeamListAdapter() : ListAdapter<Team, TeamListAdapter.TeamViewHolder>(TeamDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.team_item,
            parent,
            false
        )

        Log.i("CREATE_TEAM", currentList.size.toString())

        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = getItem(position)
        holder.bind(team)

        holder.removeButton.setOnClickListener {
            val newList = currentList.toMutableList()
            newList.removeAt(position)
            submitList(newList)
        }
    }

    inner class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTeamName = view.findViewById<TextView>(R.id.tv_team_name)
        val removeButton: ImageButton = view.findViewById(R.id.remove_team_button)

        fun bind(team: Team) {
            tvTeamName.text = team.name
        }

    }
}