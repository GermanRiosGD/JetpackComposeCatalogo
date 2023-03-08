package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyText() {
  Column(Modifier.fillMaxSize()) {
    Text(text = "Estp es un ejemplo")
    Text(text = "Esto es un ejemplo", color = Color.Blue)
    Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
    Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
    Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
    Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.LineThrough)
    Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.Underline)
    Text(
      text = "Esto es un ejemplo", textDecoration = TextDecoration.combine(
        listOf(TextDecoration.Underline, TextDecoration.LineThrough)
      )
    )
    Text(text = "Esto es un ejemplo", fontSize = 30.sp)
  }

}

@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {
  BasicTextField(value = name, onValueChange = { onValueChanged })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance() {
  var myText by remember { mutableStateOf("") }
  TextField(value = myText, onValueChange = {
    myText = if(it.contains("a")) {
      it.replace("a", "")
    } else {
      it
    }
  }, label = { Text(text = "Introduce tu nombre") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined() {
  var myText by remember { mutableStateOf("") }
  OutlinedTextField(value = myText, onValueChange = {
    myText = if(it.contains("a")) {
      it.replace("a", "")
    } else {
      it
    }
  }, label = { Text(text = "Introduce tu nombre") }, modifier = Modifier.padding(24.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
    focusedBorderColor = Color.Magenta, unfocusedBorderColor = Color.Blue
  )
  )
}