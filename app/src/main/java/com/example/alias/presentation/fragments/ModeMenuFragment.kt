package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.databinding.FragmentModeMenuBinding
import com.example.alias.databinding.FragmentStartMenuBinding
import com.example.alias.presentation.contracts.HasCustomTitle

class ModeMenuFragment : Fragment(), HasCustomTitle {
    private lateinit var binding: FragmentModeMenuBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentModeMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun getTitleRes(): Int {
        TODO("Not yet implemented")
    }
}