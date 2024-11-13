package com.example.freetogames.data.local.database.games

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GameDao {
    @Query("select * from games")
    suspend fun getAll() : List<GameEntity>
    @Query("select * from games where title like '%'||:title||'%'")
    suspend fun getByTitle(title: String) : List<GameEntity>
    @Query("select * from games where id = :id")
    suspend fun getById(id: Int) : GameEntity
    @Delete
    suspend fun delete(gameEntity: GameEntity)
    @Insert
    suspend fun insert(vararg gameEntity: GameEntity)
    @Update
    suspend fun update(gameEntity: GameEntity)
}