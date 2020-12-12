package com.example.madlevel5task2

import android.content.Context
import androidx.lifecycle.LiveData

class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    fun getNotepad(): LiveData<Game?> {
        return gameDao.getGameList()
    }

    suspend fun updateNotepad(game: Game) {
        gameDao.updateGame(game)
    }

}