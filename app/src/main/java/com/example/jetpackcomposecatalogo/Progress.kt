package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyProgress() {
  var shoLoading by rememberSaveable { mutableStateOf(false) }
  Column(
    Modifier
      .padding(24.dp)
      .fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
  ) {
    if(shoLoading) {
      CircularProgressIndicator(
        color = Color.Blue, strokeWidth = 5.dp
      )
      LinearProgressIndicator(
        modifier = Modifier.padding(top = 32.dp), color = Color.Red, trackColor = Color.Green
      )
    }
    Button(onClick = { shoLoading = !shoLoading }) {
      Text(text = "Cargar perfil")
    }
  }
}

@Composable
fun MyProgressAdvance() {
  var manageLoading by rememberSaveable { mutableStateOf(0.0f) }
  Column(
    Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
  ) {
    CircularProgressIndicator(progress = manageLoading)

    Row(
      Modifier.fillMaxWidth(),
    ) {
      Button(onClick = { manageLoading += 0.1f }) {
        Text(text = "Incrementar")
      }
      Button(onClick = { manageLoading -= 0.1f }) {
        Text(text = "Reducir")
      }
    }
  }
}