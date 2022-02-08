package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.R
import com.example.alias.databinding.FragmentPauseGameProcessBinding
import com.example.alias.databinding.FragmentRulesBinding
import com.example.alias.databinding.FragmentStartMenuBinding
import com.example.alias.presentation.contracts.HasCustomTitle
import java.lang.RuntimeException

class RulesFragment : Fragment(), HasCustomTitle {
    private var _binding: FragmentRulesBinding? = null
    private val binding: FragmentRulesBinding
        get() = _binding ?: throw RuntimeException("FragmentRulesBinding == null!")

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = FragmentRulesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun getTitleRes(): Int = R.string.rules_title
}