package com.example.freetogames.data.local.database.games

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("games")
data class GameEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val thumbnail: String,
    @ColumnInfo("short_description")
    val shortDescription: String,
    @ColumnInfo("game_url")
    val gameUrl: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val developer: String,
    @ColumnInfo("release_date")
    val releaseDate: String,
    @ColumnInfo("free_to_game_profile_url")
    val freeToGameProfileUrl: String
)
