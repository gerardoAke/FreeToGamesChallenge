package com.example.freetogames.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.freetogames.data.local.database.games.GameDao
import com.example.freetogames.data.local.database.games.GameEntity

@Database(entities = [GameEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun gameDao() : GameDao
}