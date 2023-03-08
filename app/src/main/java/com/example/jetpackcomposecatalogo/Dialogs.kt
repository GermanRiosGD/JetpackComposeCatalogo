package com.example.jetpackcomposecatalogo

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyAlertDialog(
  show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit
) {
  if(show) {
    AlertDialog(onDismissRequest = { /*TODO*/ },
      title = { Text(text = "Titulo") },
      text = { Text(text = "Hola, soy una descripcion :D") },
      confirmButton = {
        TextButton(onClick = onConfirm) {
          Text(text = "Confirm")
        }
      },
      dismissButton = {
        TextButton(onClick = onDismiss) {
          Text(text = "Dismiss")
        }
      })
  }
}

@Composable
fun MySimpleCustomDialog(
  show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit
) {
  if(show) {
    Dialog(
      onDismissRequest = { onDismiss() }, properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = true)
    ) {
      Column(
        Modifier
          .background(Color.White)
          .padding(24.dp)
          .fillMaxWidth()
      ) {
        Text(text = "Esto es un ejemplo")
      }
    }
  }
}

@Composable
fun MyCustomDialog(
  show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit
) {
  if(show) {
    Dialog(onDismissRequest = { onDismiss }) {
      Column(
        Modifier
          .background(Color.White)
          .padding(24.dp)
          .fillMaxWidth()
      ) {
        MyTitledialog(text = "Set backup account")
        AccountItem(email = "ejemplo1@gmail.com", drawable = R.drawable.avatar)
        AccountItem(email = "ejemplo2@gmail.com", drawable = R.drawable.avatar)
        AccountItem(email = "ejemplo3@gmail.com", drawable = R.drawable.avatar)
        AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.add)
      }
    }
  }
}

@Composable
fun MyTitledialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp) ) {
  Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 20.sp, modifier = modifier)
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    Image(
      painter = painterResource(id = drawable),
      contentDescription = "avatar",
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .padding(8.dp)
        .size(40.dp)
        .clip(CircleShape)
    )

    Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
  }
}

@Composable
fun MyConfirmationDialog(
  show: Boolean, onDismiss: () -> Unit
) {
  if(show) {
    Dialog(onDismissRequest = { onDismiss }) {
      Column(
        Modifier
          .fillMaxWidth()
          .background(Color.White)
      ) {
        MyTitledialog(text = "Phone ringtone", modifier = Modifier.padding(24.dp))
        Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
        var status by remember { mutableStateOf("") }
        MyRadioButtonList(status) { status = it }
        Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
        Row(Modifier.align(Alignment.End).padding(8.dp)) {
          TextButton(onClick = {  }) {
            Text(text = "CANCEL")
          }
          TextButton(onClick = {  }) {
            Text(text = "OK")
          }
        }
      }
    }
  }
}