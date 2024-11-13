package com.example.freetogames.domain

import com.example.freetogames.domain.models.Game

interface IGameRepository {
    suspend fun getGames() : List<Game>
    suspend fun getGameById() : Game
}