package com.example.alias.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.alias.domain.Team

class TeamDiffCallback : DiffUtil.ItemCallback<Team>() {

    override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
        return oldItem == newItem
    }

}