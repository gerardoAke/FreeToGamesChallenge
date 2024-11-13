package com.example.freetogames.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.freetogames.viewModels.DetailGameViewModel
import dagger.hilt.android.qualifiers.ApplicationContext

@Composable
fun DetailGameView(
    navController: NavHostController,
    id: Int,
    viewModel: DetailGameViewModel
) {

    Log.e("VIEW_MODEL_INVOKED", "DetailGameViewModel" + id.toString())

    LaunchedEffect(true) {
        viewModel.getGameById(id)
    }

    val gameResult = remember { viewModel.game }

    gameResult.value?.let { game ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    16.dp,
                    WindowInsets.systemBars.asPaddingValues().calculateTopPadding(),
                    16.dp,
                    WindowInsets.systemBars.asPaddingValues().calculateBottomPadding()
                )
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Thumbnail
            AsyncImage(
                model = game.thumbnail,
                contentDescription = "Game Thumbnail",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(1.dp, MaterialTheme.colorScheme.onSurface, RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            // Editable Fields
            EditableField(label = "Title", value = game.title) {
                viewModel.updateGame(game.copy(title = it))
            }
            EditableField(label = "Thumbnail URL", value = game.thumbnail) {
                viewModel.updateGame(game.copy(thumbnail = it))
            }
            EditableField(label = "Short Description", value = game.shortDescription) {
                viewModel.updateGame(game.copy(shortDescription = it))
            }
            EditableField(label = "Game URL", value = game.gameUrl) {
                viewModel.updateGame(game.copy(gameUrl = it))
            }
            EditableField(label = "Genre", value = game.genre) {
                viewModel.updateGame(game.copy(genre = it))
            }
            EditableField(label = "Platform", value = game.platform) {
                viewModel.updateGame(game.copy(platform = it))
            }
            EditableField(label = "Publisher", value = game.publisher) {
                viewModel.updateGame(game.copy(publisher = it))
            }
            EditableField(label = "Developer", value = game.developer) {
                viewModel.updateGame(game.copy(developer = it))
            }
            EditableField(label = "Release Date", value = game.releaseDate) {
                viewModel.updateGame(game.copy(releaseDate = it))
            }
            EditableField(label = "FreeToGame Profile URL", value = game.freeToGameProfileUrl) {
                viewModel.updateGame(game.copy(freeToGameProfileUrl = it))
            }

            // Save Button
            Button(
                onClick = {
                    viewModel.updateToBd()
                    viewModel.showToast("Changes applied")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Changes")
            }

            // Remove Button
            Button(
                onClick = {
                    viewModel.removeGame()
                    navController.popBackStack()
                    viewModel.showToast("Game removed")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error,
                    contentColor = MaterialTheme.colorScheme.onError
                )
            ) {
                Text("Remove Game")
            }
        }
    }
}

@Composable
fun EditableField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyLarge
        )
    }
}