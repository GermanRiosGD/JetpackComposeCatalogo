package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.jetpackcomposecatalogo.model.Routes

@Composable
fun Screen1(navigationControler: NavHostController) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Cyan)
  ) {
    Text(text = "Pantalla 1", modifier = Modifier.align(Alignment.Center).clickable { navigationControler.navigate(
      Routes.Screen2.route
    ) })
  }
}

@Composable
fun Screen2(navigationControler: NavHostController) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Green)
  ) {
    Text(text = "Pantalla 2", modifier = Modifier.align(Alignment.Center).clickable { navigationControler.navigate(Routes.Screen3.route) })
  }
}

@Composable
fun Screen3(navigationControler: NavHostController) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Magenta)
  ) {
    Text(text = "Pantalla 3", modifier = Modifier.align(Alignment.Center).clickable { navigationControler.navigate(Routes.Screen4.createRoute(30)) })
  }
}

@Composable
fun Screen4(navigationControler: NavHostController,age:Int) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.White)
  ) {
    Text(text = "Tengo $age años ", modifier = Modifier.align(Alignment.Center).clickable { navigationControler.navigate(Routes.Screen5.createRoute("German")) })
  }
}

@Composable
fun Screen5(navigationControler: NavHostController,name:String?) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.White)
  ) {
    Text(text = "Me llamo $name ", modifier = Modifier.align(Alignment.Center).clickable { navigationControler.navigate(Routes.Screen1.route) })
  }
}