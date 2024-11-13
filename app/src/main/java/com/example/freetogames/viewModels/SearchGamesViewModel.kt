package com.example.freetogames.viewModels
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freetogames.domain.IGameRepository
import com.example.freetogames.domain.models.Game
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchGamesViewModel @Inject constructor(
    private val repository: IGameRepository
): ViewModel() {

    private val _games = mutableStateListOf<Game>()
    val games: SnapshotStateList<Game> = _games

     fun getGames() {
        viewModelScope.launch(Dispatchers.IO) {
            _games.clear()
            _games.addAll(repository.getGames())
            Log.e("LIST_OF_GAMES", _games.toString())
        }
    }
}