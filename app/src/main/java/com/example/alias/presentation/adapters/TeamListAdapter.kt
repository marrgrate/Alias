package com.example.alias.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.alias.R
import com.example.alias.domain.entities.Team
import com.example.alias.presentation.adapters.callbacks.TeamDiffCallback


class TeamListAdapter : ListAdapter<Team, TeamListAdapter.TeamViewHolder>(TeamDiffCallback()) {

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
    }

    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTeamName = view.findViewById<TextView>(R.id.tv_team_name)

        fun bind(team: Team) {
            tvTeamName.text = team.name
        }
    }
}