package com.example.freetogames.data

import com.example.freetogames.data.local.database.games.GameDao
import com.example.freetogames.domain.models.Game
import com.example.freetogames.domain.IGameRepository
import javax.inject.Inject

class GameRepositoryService @Inject constructor(
    private val gameServiceApi: IGameService,
    private val gameDao: GameDao
) :
        IGameRepository
{
    override suspend fun getGames(): List<Game> {

        val lisOfGames = gameDao.getAll()

        if(lisOfGames.isNotEmpty())
            return lisOfGames.map { gameEntity -> gameEntity.toDomain()}

        val response = gameServiceApi.getGames().map {
                gameDto -> gameDto.toDomain()
        }

        gameDao.insert(*response.map { game -> game.toGameEntity() }.toTypedArray())

        return response
    }

    override suspend fun getGameById(id: Int): Game {
        return gameDao.getById(id).toDomain()
    }

    override suspend fun update(game: Game) {
        gameDao.update(game.toGameEntity())
    }

    override suspend fun delete(game: Game) {
        gameDao.delete(game.toGameEntity())
    }


}