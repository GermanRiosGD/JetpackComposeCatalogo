package com.example.jetpackcomposecatalogo

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffoldExample() {
  val snackbarHostState = remember { SnackbarHostState() }
  val coroutineScope = rememberCoroutineScope()
  val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
  ModalNavigationDrawer(
    drawerState = drawerState,
    drawerContent = { ModalDrawerSheet { MyDrawer(){
      coroutineScope.launch { drawerState.close() }
    } } },
    gesturesEnabled = false
  ) {
    Scaffold(
      topBar = {
        MyTopAppBar(onClickIcon = {
          coroutineScope.launch {
            snackbarHostState.showSnackbar(it)
          }
        }, onClickDrawable = {
          coroutineScope.launch { drawerState.open() }
        })
      },
      snackbarHost = { SnackbarHost(snackbarHostState) },
      bottomBar = { MyBottomNavigation() },
      floatingActionButton = { MyFAB() },
      floatingActionButtonPosition = FabPosition.Center,
    ) { }
  }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDrawable: () -> Unit) {
  TopAppBar(title = { Text(text = "Mi primer TopAppBar") },
    colors = TopAppBarDefaults.largeTopAppBarColors(
      containerColor = Color.Red, titleContentColor = Color.White
    ),
    navigationIcon = {
      IconButton(onClick = { onClickDrawable() }) {
        Icon(
          imageVector = Icons.Filled.Menu, contentDescription = "icon", tint = Color.White
        )
      }
    },
    actions = {
      IconButton(onClick = { onClickIcon("Buscar") }) {
        Icon(
          imageVector = Icons.Filled.Search, contentDescription = "search", tint = Color.White
        )
      }
      IconButton(onClick = { onClickIcon("Alerta !") }) {
        Icon(
          imageVector = Icons.Filled.Warning, contentDescription = "warning", tint = Color.White
        )
      }
    })
}

@Composable
fun MyBottomNavigation() {
  var index by remember { mutableStateOf(0) }
  NavigationBar(containerColor = Color.Red, contentColor = Color.Green) {
    NavigationBarItem(selected = index == 0, onClick = { index = 0 }, icon = {
      Icon(
        imageVector = Icons.Default.Home, contentDescription = "Home"
      )
    }, label = { Text(text = "Home") })
    NavigationBarItem(selected = index == 1, onClick = { index = 1 }, icon = {
      Icon(
        imageVector = Icons.Default.Favorite, contentDescription = "Fav"
      )
    }, label = { Text(text = "Fav") })
    NavigationBarItem(selected = index == 2, onClick = { index = 2 }, icon = {
      Icon(
        imageVector = Icons.Default.Person, contentDescription = "Perfil"
      )
    }, label = { Text(text = "Perfil") })
  }
}

@Composable
fun MyFAB() {
  FloatingActionButton(onClick = { }, containerColor = Color.Yellow, contentColor = Color.Black) {
    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
  }
}

@Composable
fun MyDrawer(onCLoseDrawer: () -> Unit) {
  Column(Modifier.padding(8.dp)) {
    Text(
      text = "Primera opcion", modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .clickable { onCLoseDrawer() }
    )
    Text(
      text = "Segunda opcion", modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .clickable { onCLoseDrawer() }
    )
    Text(
      text = "Tercera opcion", modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .clickable { onCLoseDrawer() }
    )
    Text(
      text = "Cuarta opcion", modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .clickable { onCLoseDrawer() }
    )
  }
}