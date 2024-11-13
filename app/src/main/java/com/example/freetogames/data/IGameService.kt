package com.example.freetogames.data

import com.example.freetogames.data.models.GameDto
import retrofit2.http.GET

interface IGameService {
    @GET("games")
    suspend fun getGames() : List<GameDto>
}