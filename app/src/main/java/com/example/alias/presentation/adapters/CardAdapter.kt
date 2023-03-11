package com.example.alias.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alias.databinding.StackViewItemBinding

class CardAdapter(val context: Context, private val words: List<String>)
    : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    inner class CardViewHolder(val binding: StackViewItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {


        return CardViewHolder(StackViewItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        ))
    }

    override fun getItemCount(): Int = words.size


    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val word = words[position]
        holder.binding.tvWord.text = word
    }
}