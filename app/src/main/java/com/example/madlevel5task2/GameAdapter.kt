package com.example.madlevel5task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.DateFormatSymbols

class GameAdapter(private val backlogs: List<Game>) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun databind(game: Game) {

            itemView.tvGameName.text = game.title
            itemView.tvPlatform.text = game.platform
            itemView.tvReleaseDate.text = String.format(
                "Release: " + game.date.date + " " +
                        DateFormatSymbols.getInstance().months[game.date.month - 1] + " " +
                        game.date.year
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(backlogs[position])
    }

    override fun getItemCount(): Int {
        return backlogs.size
    }
}