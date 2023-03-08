package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyComplexLayout() {
  Column(Modifier.fillMaxSize()) {
    Box(
      Modifier
        .fillMaxWidth()
        .weight(1f)
        .background(Color.Cyan), Alignment.Center
    ) {
      Text(text = "Ejemplo 1")
    }
    mySpacer(30)
    Row(
      Modifier
        .fillMaxWidth()
        .weight(1f)
    ) {
      Box(
        modifier = Modifier
          .weight(1f)
          .fillMaxHeight()
          .background(Color.Red), Alignment.Center
      ) {
        Text(text = "Ejemplo 2")
      }
      Box(
        modifier = Modifier
          .weight(1f)
          .fillMaxHeight()
          .background(Color.Green), contentAlignment = Alignment.Center
      ) {
        Text(text = "Hola, soy German")
      }

    }
    mySpacer(30)
    Box(
      Modifier
        .fillMaxWidth()
        .weight(1f)
        .background(Color.Magenta), Alignment.BottomCenter
    ) {
      Text(text = "Ejemplo 4")
    }
  }
}

@Composable
fun mySpacer(size: Int) {
  Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyRow() {
  Row(
    Modifier
      .fillMaxSize()
      .horizontalScroll(rememberScrollState())
  ) {
    Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
    Text(text = "Ejemplo 2", modifier = Modifier.width(100.dp))
    Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp))
    Text(text = "Ejemplo 4", modifier = Modifier.width(100.dp))
    Text(text = "Ejemplo 5", modifier = Modifier.width(100.dp))
  }
}

@Composable
fun MyColumn() {
  Column(
    Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.SpaceBetween,
  ) {
    Text(
      text = "Ejemplo1", modifier = Modifier
        .background(Color.Red)
        .fillMaxWidth()
        .height(100.dp)
    )
    Text(
      text = "Ejemplo1", modifier = Modifier
        .background(Color.Blue)
        .fillMaxWidth()
        .height(100.dp)
    )
    Text(
      text = "Ejemplo1", modifier = Modifier
        .background(Color.Yellow)
        .fillMaxWidth()
        .height(100.dp)
    )
    Text(
      text = "Ejemplo1", modifier = Modifier
        .background(Color.Cyan)
        .fillMaxWidth()
        .height(100.dp)
    )
    Text(
      text = "Ejemplo1", modifier = Modifier
        .background(Color.Red)
        .fillMaxWidth()
        .height(100.dp)
    )
    Text(
      text = "Ejemplo1", modifier = Modifier
        .background(Color.Blue)
        .fillMaxWidth()
        .height(100.dp)
    )
    Text(
      text = "Ejemplo1", modifier = Modifier
        .background(Color.Yellow)
        .fillMaxWidth()
        .height(100.dp)
    )
    Text(
      text = "Ejemplo1", modifier = Modifier
        .background(Color.Cyan)
        .fillMaxWidth()
        .height(100.dp)
    )
    Text(
      text = "Ejemplo1", modifier = Modifier
        .background(Color.Red)
        .fillMaxWidth()
        .height(100.dp)
    )
    Text(
      text = "Ejemplo1", modifier = Modifier
        .background(Color.Blue)
        .fillMaxWidth()
        .height(100.dp)
    )
    Text(
      text = "Ejemplo1", modifier = Modifier
        .background(Color.Yellow)
        .fillMaxWidth()
        .height(100.dp)
    )
    Text(
      text = "Ejemplo1", modifier = Modifier
        .background(Color.Cyan)
        .fillMaxWidth()
        .height(100.dp)
    )
  }
}

@Composable
fun MyBox() {
  Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    Box(
      modifier = Modifier
        .width(200.dp)
        .height(200.dp)
        .background(Color.Cyan)
        .verticalScroll(
          rememberScrollState()
        ), contentAlignment = Alignment.BottomCenter
    ) {
      Text(text = "Esto es un EJEMPLO")
    }
  }
}