
package com.example.alias.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alias.R

class DictionariesAdapter(private val dictionaries: List<String>) : RecyclerView.Adapter<DictionariesAdapter.DictionaryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(
            R.layout.dictionary_item,
            parent,
            false
        )

        return DictionaryViewHolder(view)
    }

    override fun onBindViewHolder(holder: DictionaryViewHolder, position: Int) {
        val dictionary = dictionaries[position]
        holder.tvDictionaryName.text = dictionary
    }

    override fun getItemCount(): Int {
        return dictionaries.size
    }

    class DictionaryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDictionaryName: TextView = view.findViewById<TextView>(R.id.dictionary_name)
    }
}
