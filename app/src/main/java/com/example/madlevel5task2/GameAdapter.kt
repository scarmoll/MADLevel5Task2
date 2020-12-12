package com.example.madlevel5task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.DateFormatSymbols

class GameAdapter(private val gameList: List<Game>) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun databind(game: Game) {
            val monthFormat = game.date.month

            itemView.tvGameName.text = game.title
            itemView.tvPlatform.text = game.platform

            itemView.tvDate.text = String.format(
                "Release: " +
                        game.date.date + " " +
                        DateFormatSymbols().months[monthFormat] + " " +
                        game.date.year
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.databind(gameList[position])
    }

    override fun getItemCount(): Int {
        return gameList.size
    }
}