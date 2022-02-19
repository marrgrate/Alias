package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alias.R
import com.example.alias.databinding.FragmentTeamListBinding
import com.example.alias.domain.entities.Team
import com.example.alias.presentation.adapters.TeamListAdapter
import com.example.alias.presentation.contracts.HasCustomTitle
import com.example.alias.presentation.contracts.navigator
import com.example.alias.presentation.viewmodels.TeamListViewModel
import java.lang.RuntimeException

class TeamListFragment : Fragment(), HasCustomTitle {
    private var _binding: FragmentTeamListBinding? = null
    private val binding: FragmentTeamListBinding
        get() = _binding ?: throw RuntimeException("FragmentTeamListBinding == null!")
    private lateinit var teamListAdapter: TeamListAdapter
    private lateinit var viewModel : TeamListViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeamListBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel = ViewModelProvider(this)[TeamListViewModel::class.java]
        viewModel.teamList.observe(viewLifecycleOwner) { teamListAdapter.submitList(it) }

        setupOnSwipeListener()
        setupOnClickListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun getTitleRes(): Int = R.string.teams_title

    private fun onNextPressed() {
        binding.buttonNextScreen.setOnClickListener { navigator().showConfigScreen() }
    }

    private fun onAddTeamPressed() {
        var counter: Int = 2
        binding.buttonAddTeam.setOnClickListener { viewModel.addTeam(Team("Team${++counter}", 0)) }
    }

    private fun setupOnSwipeListener() {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT,
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val team = teamListAdapter.currentList[viewHolder.layoutPosition]
                viewModel.deleteTeam(team)
            }
        }
        val itemTouchHelper =ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.recyclerTeamList)
    }

    private fun setupRecyclerView() {
        with(binding.recyclerTeamList) {
            teamListAdapter = TeamListAdapter()
            adapter = teamListAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setupOnClickListeners() {
        onAddTeamPressed()
        onNextPressed()
    }
}