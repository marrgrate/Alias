package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.R
import com.example.alias.databinding.FragmentTeamListBinding
import com.example.alias.presentation.contracts.HasCustomTitle
import com.example.alias.presentation.contracts.navigator

class TeamListFragment : Fragment(), HasCustomTitle {
    private lateinit var binding: FragmentTeamListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = FragmentTeamListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun getTitleRes(): Int = R.string.teams_title

    fun onNextPressed() {
        binding.buttonNextScreen.setOnClickListener { navigator().showConfigScreen() }
    }

    fun onAddTeamPressed() {
        binding.buttonAddTeam.setOnClickListener {  }
    }
}