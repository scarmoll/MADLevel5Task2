package com.example.madlevel5task2

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GameDao {

    @Insert
    suspend fun insertGame(game: Game)

    @Query("SELECT * FROM GameTable")
    fun getGameList(): LiveData<Game?>

    @Update
    suspend fun updateGame(game: Game)

}