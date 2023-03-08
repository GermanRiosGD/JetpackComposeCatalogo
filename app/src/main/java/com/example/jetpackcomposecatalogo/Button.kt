package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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
fun MyButtonExample() {
  var enabled by rememberSaveable { mutableStateOf(true) }
  Column(
    Modifier
      .fillMaxSize()
      .padding(24.dp)
  ) {
    Button(
      onClick = { enabled = false }, colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta), enabled = enabled
    ) {
      Text(text = "hola")
    }

    OutlinedButton(
      onClick = {}, colors = ButtonDefaults.buttonColors(disabledContainerColor = Color.Magenta), enabled = enabled
    ) {
      Text(text = "hola")
    }

    TextButton(onClick = { /*TODO*/ }) {
      Text(text = "hola")
    }
  }
}

@Composable
fun MyRadioButton() {
  Row(Modifier.fillMaxWidth()) {
    RadioButton(
      selected = false, onClick = {

      }, colors = RadioButtonDefaults.colors(
        selectedColor = Color.Red, unselectedColor = Color.Yellow, disabledSelectedColor = Color.Green
      )
    )
    Text(text = "Ejemlo 1")
  }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

  Column(Modifier.fillMaxWidth()) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      RadioButton(selected = name == "German", onClick = { onItemSelected("German") })
      Text(text = "German")
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
      RadioButton(selected = name == "Ulises", onClick = { onItemSelected("Ulises") })
      Text(text = "Ulises")
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
      RadioButton(selected = name == "Aris", onClick = { onItemSelected("Aris") })
      Text(text = "Aris")
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
      RadioButton(selected = name == "Pepe", onClick = { onItemSelected("Pepe") })
      Text(text = "Pepe")
    }
  }
}