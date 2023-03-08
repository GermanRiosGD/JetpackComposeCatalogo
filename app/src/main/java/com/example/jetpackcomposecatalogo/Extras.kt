package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MyCard() {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
    shape = MaterialTheme.shapes.large,
    colors = CardDefaults.cardColors(containerColor = Color.Red),
    border = BorderStroke(5.dp, Color.Green)
  ) {
    Column(Modifier.padding(16.dp)) {
      Text(text = "Ejemplo 1")
      Text(text = "Ejemplo 2")
      Text(text = "Ejemplo 3")
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
  BadgedBox(modifier = Modifier.padding(16.dp),
    badge = { Badge(content = { Text(text = "10") }, modifier = Modifier.padding(2.dp), contentColor = Color.Red, containerColor = Color.Blue) }) {
    Icon(imageVector = Icons.Default.Star, contentDescription = "")
  }
}

@Composable
fun MyDivider() {
  Divider(
    Modifier
      .fillMaxWidth()
      .padding(top = 16.dp), color = Color.Red
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu() {
  var selectedText by rememberSaveable { mutableStateOf("") }
  var expanded by rememberSaveable { mutableStateOf(false) }
  val desserts = listOf("Helado", "Chocolate", "Cafe", "Pudin", "Pastel")
  Column(modifier = Modifier.padding(16.dp)) {
    OutlinedTextField(value = selectedText,
      onValueChange = { selectedText = it },
      enabled = false,
      readOnly = true,
      modifier = Modifier
        .clickable { expanded = true }
        .fillMaxWidth())
    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }, modifier = Modifier.fillMaxWidth()) {
      desserts.forEach { dessert ->
        DropdownMenuItem(text = { Text(text = dessert) }, onClick = {
          expanded = false
          selectedText = dessert
        })
      }
    }
  }
}