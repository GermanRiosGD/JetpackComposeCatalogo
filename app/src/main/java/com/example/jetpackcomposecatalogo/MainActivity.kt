package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposecatalogo.model.Routes
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      JetpackComposeCatalogoTheme { // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          val myOptions = getOptions(titles = listOf("German", "Ejemplo", "Eevee"))
          var selected by remember { mutableStateOf("German") }
          //Column {
//            MyTextField(myText) { myText = it }
//            myOptions.forEach {
//              MyCheckBoxWithTextCompleted(it)
//            }
//            MyRadioButtonList(selected) { selected = it }

//            var show by remember { mutableStateOf(false) }
//            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//              Button(onClick = { show = true }) {
//                Text(text = "Mostrar Dialog")
//              }
//            }
          //MyCustomDialog(show = show, onDismiss = { show = false }, onConfirm = { Log.i("German", "Click") })
//            MyConfirmationDialog(show = show, onDismiss = { show = false })

//          }
          val navigationControler = rememberNavController()
          NavHost(navController = navigationControler, startDestination = Routes.Screen1.route) {
            composable(Routes.Screen1.route) { Screen1(navigationControler) }
            composable(Routes.Screen2.route) { Screen2(navigationControler) }
            composable(Routes.Screen3.route) { Screen3(navigationControler) }
            composable(
              Routes.Screen4.route,
              arguments = listOf(navArgument("age") { type = NavType.IntType })
            ) { backStackEntry ->
              Screen4(
                navigationControler, backStackEntry.arguments?.getInt("age") ?: 0
              )
            }
            composable(
              Routes.Screen5.route,
              listOf(navArgument("name") { defaultValue = "" })
            ) { backStackEntry ->
              Screen5(navigationControler, backStackEntry.arguments?.getString("name")) }
          }

        }
      }
    }
  }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
  return titles.map {
    var status by rememberSaveable { mutableStateOf(false) }
    CheckInfo(title = it,
      selected = status,
      onCheckedChange = { myNewStatus -> status = myNewStatus })
  }
}

@Composable
fun MyStateExample() {
  var counter by rememberSaveable { mutableStateOf(0) }
  Column(
    Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Button(onClick = { counter += 1 }) {
      Text(text = "Pulsar")
    }
    Text(text = "He sido pulstado ${counter} veces")
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  JetpackComposeCatalogoTheme {
    MyStateExample()
  }
}