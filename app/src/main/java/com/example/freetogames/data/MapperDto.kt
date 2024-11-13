package com.example.freetogames.data

import com.example.freetogames.data.local.database.games.GameEntity
import com.example.freetogames.data.models.GameDto
import com.example.freetogames.domain.models.Game
import java.util.Date

fun GameDto.toDomain(): Game =
    Game(
        this.id,
        this.title,
        this.thumbnail,
        this.shortDescription,
        this.gameUrl,
        this.genre,
        this.platform,
        this.publisher,
        this.developer,
        this.releaseDate,
        this.freeToGameProfileUrl,
    )

fun GameEntity.toDomain(): Game =
    Game(
        this.id,
        this.title,
        this.thumbnail,
        this.shortDescription,
        this.gameUrl,
        this.genre,
        this.platform,
        this.publisher,
        this.developer,
        this.releaseDate,
        this.freeToGameProfileUrl,
    )

fun Game.toGameEntity(): GameEntity =
    GameEntity(
        this.id,
        this.title,
        this.thumbnail,
        this.shortDescription,
        this.gameUrl,
        this.genre,
        this.platform,
        this.publisher,
        this.developer,
        this.releaseDate,
        this.freeToGameProfileUrl,
    )