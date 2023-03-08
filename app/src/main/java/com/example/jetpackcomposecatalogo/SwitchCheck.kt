package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun MySwitch() {
  var state by rememberSaveable { mutableStateOf(true) }
  Switch(
    checked = state, onCheckedChange = { state = !state }, enabled = true, colors = SwitchDefaults.colors(
      checkedThumbColor = Color.Green,
      checkedTrackColor = Color.Cyan,
      uncheckedThumbColor = Color.Red,
      uncheckedTrackColor = Color.Magenta,
    )
  )

}

@Composable
fun MyCheckbox() {
  var state by rememberSaveable { mutableStateOf(true) }
  Checkbox(
    checked = state, onCheckedChange = { state = !state }, colors = CheckboxDefaults.colors( //      checkedColor = Color.Red,
      //      uncheckedColor = Color.Yellow,
      //      checkmarkColor = Color.Blue,
    )
  )
}

@Composable
fun MyCheckBoxWithText() {
  var state by rememberSaveable { mutableStateOf(true) }
  Row(Modifier.padding(8.dp)) {
    Checkbox(checked = state, onCheckedChange = { state = !state })
    Spacer(modifier = Modifier.width(8.dp))
    Text(text = "Ejemplo")
  }
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
  Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
    Checkbox(checked = checkInfo.selected, onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
    Spacer(modifier = Modifier.width(8.dp))
    Text(text = checkInfo.title)
  }
}

@Composable
fun MyTriStatusCheckBox() {
  var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
  TriStateCheckbox(state = status, onClick = {
    status = when(status) {
      ToggleableState.On -> ToggleableState.Off
      ToggleableState.Off -> ToggleableState.Indeterminate
      ToggleableState.Indeterminate -> ToggleableState.On
    }
  })
}