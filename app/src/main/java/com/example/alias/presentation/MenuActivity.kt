package com.example.alias.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alias.R
import com.example.alias.databinding.FragmentStartMenuBinding

//private lateinit var binding: FragmentStartMenuBinding

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = FragmentStartMenuBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.fragment_start_menu)
    }
}