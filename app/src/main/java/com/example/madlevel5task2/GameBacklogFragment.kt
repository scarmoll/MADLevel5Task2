package com.example.madlevel5task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_game_backlog.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GameBacklogFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()

    private val gameList = arrayListOf<Game>()
    private val gameListAdapter = GameListAdapter(gameList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_backlog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeAddGameResult()
    }

    private fun initViews() {
        rvGamelist.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        rvGamelist.adapter = gameListAdapter

        createItemTouchHelper()
    }

    private fun observeAddGameResult() {
        viewModel.games.observe(viewLifecycleOwner, Observer {
                gameList ->
            this@GameBacklogFragment.gameList.clear()
            this@GameBacklogFragment.gameList.addAll(gameList)
            gameListAdapter.notifyDataSetChanged()
        })
    }

    private fun createItemTouchHelper(): ItemTouchHelper {
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val game = gameList[position]

                viewModel.deleteGame(game)
            }
        }
        return ItemTouchHelper(callback)
    }
}