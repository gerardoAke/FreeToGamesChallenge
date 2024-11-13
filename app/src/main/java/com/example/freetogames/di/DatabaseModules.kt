package com.example.freetogames.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.freetogames.data.local.database.AppDatabase
import com.example.freetogames.data.local.database.games.GameDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModules {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context):
            AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "free_to_games.db").build()

    @Provides
    @Singleton
    fun providesGameDao(appDatabase : AppDatabase) : GameDao = appDatabase.gameDao()
}