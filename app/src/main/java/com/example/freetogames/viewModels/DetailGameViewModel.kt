package com.example.freetogames.viewModels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freetogames.domain.IGameRepository
import com.example.freetogames.domain.models.Game
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailGameViewModel @Inject constructor(
    private val repository: IGameRepository
): ViewModel() {

    private val _game = mutableStateOf(
        Game(
            title = "Tarisland",
            thumbnail = "https://www.freetogame.com/g/582/thumbnail.jpg",
            shortDescription = "A cross-platform MMORPG developed by Level Infinite and Published by Tencent.",
            gameUrl = "https://www.freetogame.com/open/tarisland",
            genre = "MMORPG",
            platform = "PC (Windows)",
            publisher = "Tencent",
            developer = "Level Infinite",
            releaseDate = "2024-06-22",
            freeToGameProfileUrl = "https://www.freetogame.com/tarisland",
            id = 0
        )
    )

    val game: State<Game> = _game

    fun updateGame(updatedGame: Game) {
        _game.value = updatedGame
    }

    fun removeGame() {
        // Logic to remove game (e.g., delete from repository or navigate away)
        _game.value = Game(
            0, "", "", "", "", "", "", "", "", "",  ""
        )
    }
}