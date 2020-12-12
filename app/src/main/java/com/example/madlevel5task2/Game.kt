package com.example.madlevel5task2

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "gameTable")
data class Game (

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "platform")
    var platform: String,

    @ColumnInfo(name = "date")
    var date: String
)