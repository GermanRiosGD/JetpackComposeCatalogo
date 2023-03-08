package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TwitterPage() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(color = Color(0xFF191F2A))
  ) {
    Column(Modifier.fillMaxWidth()) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
      ) {
        Image(
          painter = painterResource(id = R.drawable.profile),
          contentDescription = "profile",
          modifier = Modifier
            .clip(CircleShape)
            .size(55.dp)
        )
        Column(modifier = Modifier
          .fillMaxWidth()
          .padding(start = 8.dp, end = 8.dp)) {
          Row(Modifier.fillMaxWidth()) {
            Text(
              text = "German",
              color = Color.White,
              fontWeight = FontWeight.ExtraBold
            )
            Text(text = "@RiverzCode", color = Color.Gray,
              modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp))
            Icon(
              painter = painterResource(id = R.drawable.ic_dots),
              contentDescription = "opciones",
              tint = Color.White
            )
          }
          Text(text = "Esto es una descripción muy larga que mira Esto es una descripción muy larga que mira Esto es una descripción muy larga que mira Esto es una descripción muy larga que mira ",
            color = Color.White,
          modifier = Modifier.padding(bottom = 8.dp))
          Image(painter = painterResource(id = R.drawable.profile), contentDescription = "profile", modifier = Modifier
            .clip(
              RoundedCornerShape(16.dp)
            )
            .height(200.dp)
            .fillMaxWidth(), contentScale = ContentScale.Crop )
        }
      }
      Row(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp), horizontalArrangement = Arrangement.SpaceAround) {
        var chat by rememberSaveable { mutableStateOf(1) }
        var chatState by rememberSaveable { mutableStateOf(false) }
        var retwit by rememberSaveable { mutableStateOf(1) }
        var retwitState by rememberSaveable { mutableStateOf(false) }
        var like by rememberSaveable { mutableStateOf(1) }
        var likeState by rememberSaveable { mutableStateOf(false) }

        reaction(drawableType = 0, count = chat, state = chatState) {
          if(chatState) {
            chat -= 1
          } else {
            chat += 1
          }
          chatState = !chatState
        }
        reaction(drawableType = 1, count = retwit, state = retwitState) {
          if(retwitState) {
            retwit -= 1
          } else {
            retwit += 1
          }
          retwitState = !retwitState
        }
        reaction(drawableType = 2, count = like, state = likeState) {
          if(likeState) {
            like -= 1
          } else {
            like += 1
          }
          likeState = !likeState
        }
      }
      Divider(Modifier.height(1.dp))
    }
  }
}

@Composable
fun reaction(drawableType: Int, count: Int, state: Boolean, onReactionMaked: () -> Unit) {
  Row() {
    Button(
      onClick = onReactionMaked, colors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
      )
    ) {
      when(drawableType) {
        0 -> {
          if(state) {
            Icon(
              painter = painterResource(id = R.drawable.ic_chat_filled),
              contentDescription = "reaction",
              tint = Color.LightGray
            )
          } else {
            Icon(
              painter = painterResource(id = R.drawable.ic_chat),
              contentDescription = "reaction",
              tint = Color.LightGray
            )
          }

        }
        1 -> {
          if(state) {
            Icon(
              painter = painterResource(id = R.drawable.ic_rt),
              contentDescription = "reaction",
              tint = Color.Green
            )
          } else {
            Icon(
              painter = painterResource(id = R.drawable.ic_rt),
              contentDescription = "reaction",
              tint = Color.LightGray
            )
          }

        }
        2 -> {
          if(state) {
            Icon(
              painter = painterResource(id = R.drawable.ic_like_filled),
              contentDescription = "reaction",
              tint = Color.Red
            )
          } else {
            Icon(
              painter = painterResource(id = R.drawable.ic_like),
              contentDescription = "reaction",
              tint = Color.LightGray
            )
          }

        }
        else -> Icon(
          painter = painterResource(id = R.drawable.ic_dots), contentDescription = "reaction"
        )
      }
      Text(text = count.toString())
    }

  }

}

data class Reaction(
  val state: Boolean, val value: Int, val type: Int
//  var onValueChanged:(Boolean) -> Unit
)