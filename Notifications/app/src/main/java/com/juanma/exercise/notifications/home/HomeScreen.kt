package com.juanma.exercise.notifications.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val state = viewModel.state
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = state.name, onValueChange = { viewModel.changeName(it) })
        Button(onClick = { viewModel.sendNotification(context = context) }) {
            Text(text = "Enviar notificación")
        }
    }
}