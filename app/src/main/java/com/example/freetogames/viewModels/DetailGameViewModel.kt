package com.example.freetogames.viewModels

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freetogames.domain.IGameRepository
import com.example.freetogames.domain.models.Game
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailGameViewModel @Inject constructor(
    private val repository: IGameRepository,
    private val application: Application
): ViewModel() {

    private val _game = mutableStateOf<Game?>(null)

    val game: State<Game?> = _game

    fun getGameById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getGameById(id)
             _game.value = result
            Log.e("GAME", result.toString())
        }
    }

    fun updateGame(updatedGame: Game) {
        _game.value = updatedGame
    }

    fun updateToBd() {
        viewModelScope.launch(Dispatchers.IO) {
            _game.value?.let { repository.update(it) }
            Log.i("GAME_UPDATED", _game.value.toString())
        }
    }

    fun removeGame() {
        viewModelScope.launch(Dispatchers.IO) {
            _game.value?.let {
                Log.i("GAME_TO_BE_DELETED", _game.value.toString())
                repository.delete(it)
            }
        }
    }

    fun showToast(message: String) {
        Toast.makeText(application.applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}