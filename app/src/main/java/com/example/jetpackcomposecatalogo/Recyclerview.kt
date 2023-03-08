package com.example.jetpackcomposecatalogo

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalogo.model.Superhero
import kotlinx.coroutines.launch

@Composable
fun SimpleRecyclerview() {
  val myList = listOf("German", "Ulises", "Brenda", "Elizabeth")
  LazyColumn {
    item { Text(text = "Primer item") }
    items(7) {
      Text(text = "este es el item numero $it")
    }
    items(myList) {
      Text(text = "Hola me llamo $it")
    }
  }
}

@Composable
fun SuperHeroView() {
  val context = LocalContext.current
  LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    items(getSuperHeroes()) { superHero ->
      ItemHero(superhero = superHero) {
        Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
      }
    }
  }
}

@Composable
fun SuperHeroGridView() {
  val context = LocalContext.current
  LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
    items(getSuperHeroes()) { superHero ->
      ItemHero(superhero = superHero) {
        Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
      }
    }
  }, contentPadding = PaddingValues(8.dp))
}

@Composable
fun SuperHeroControlls() {
  val context = LocalContext.current
  val rvState = rememberLazyListState()
  val coroutinesScope = rememberCoroutineScope()

  Column {
    LazyColumn(
      state = rvState,
      verticalArrangement = Arrangement.spacedBy(8.dp),
      modifier = Modifier.weight(1f)
    ) {
      items(getSuperHeroes()) { superHero ->
        ItemHero(superhero = superHero) {
          Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
        }
      }
    }
    val showButton by remember {
      derivedStateOf { rvState.firstVisibleItemIndex > 0 }
    }
    if(showButton) {
      Button(onClick = {
        coroutinesScope.launch {
          rvState.animateScrollToItem(0)
        }
      }, modifier = Modifier
        .align(Alignment.CenterHorizontally)
        .padding(8.dp)) {
        Text(text = "Im a cool Button")
      }
    }

  }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyview() {
  val context = LocalContext.current
  val superhero: Map<String, List<Superhero>> = getSuperHeroes().groupBy { it.publisher }
  LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    superhero.forEach { (publicher, mySuperHero) ->
      
      stickyHeader { 
        Text(text = publicher,modifier = Modifier.fillMaxWidth().background(Color.Green), fontSize = 16.sp, color = Color.White)
      }
      items( mySuperHero) { superHero ->
        ItemHero(superhero = superHero) {
          Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
        }
      }
    }
    
  }
}





@Composable
fun ItemHero(superhero: Superhero, OnItemSelected: (Superhero) -> Unit) {
  Card(border = BorderStroke(2.dp, Color.Red),
    modifier = Modifier
      .width(200.dp)
      .clickable { OnItemSelected(superhero) }) {
    Column() {
      Image(
        painter = painterResource(id = superhero.photo),
        contentDescription = "Superhero Avatar",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
      )
      Text(text = superhero.superheroName, modifier = Modifier.align(Alignment.CenterHorizontally))
      Text(
        text = superhero.realName,
        modifier = Modifier.align(Alignment.CenterHorizontally),
        fontSize = 12.sp
      )
      Text(
        text = superhero.realName,
        modifier = Modifier
          .align(Alignment.End)
          .padding(8.dp),
        fontSize = 10.sp
      )
    }
  }
}

fun getSuperHeroes(): List<Superhero> {
  return listOf(
    Superhero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
    Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
    Superhero("Batman", "Bruce Weyne", "Marvel", R.drawable.batman),
    Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
    Superhero("Flash", "Barry Allen", "DC", R.drawable.flash),
    Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
    Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman),
  )
}