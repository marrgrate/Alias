package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.R
import com.example.alias.databinding.FragmentRulesBinding
import com.example.alias.databinding.FragmentStartMenuBinding
import com.example.alias.presentation.contracts.HasCustomTitle

class RulesFragment : Fragment(), HasCustomTitle {
    private lateinit var binding: FragmentRulesBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentRulesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun getTitleRes(): Int = R.string.rules_title
}