package com.example.freetogames.domain

import com.example.freetogames.domain.models.Game

interface IGameRepository {
    suspend fun getGames() : List<Game>
    suspend fun getGameById(id: Int) : Game
    suspend fun update(game: Game)
    suspend fun delete(game: Game)
}