package com.example.androidnotesapp.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidnotesapp.Functions.DeleteNote
import com.example.androidnotesapp.Note
import com.example.androidnotesapp.Screens.Screen

@Composable
fun RowView(note: Note, list: MutableList<Note>, navController: NavController) {
    var index by rememberSaveable {
        mutableStateOf("")
    }
    Row(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.DarkGray)
            .padding(10.dp),
    ){
        Column (
            modifier = Modifier
                .weight(1f)
        ){
            Text(
                note.title,
                color = Color(227,119,36,255),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                note.text,
                color = Color(227,119,36,255),
            )
        }
        Column (
            modifier = Modifier
        ){
            Button(onClick = {
                //index = {list.indexOf(note)}.toString()
                index = list.indexOf(note).toString()
                navController.navigate(Screen.EditScreen.route.replace("{index}", index))
            }) {
                Text(text = "Edit")
            }
            DeleteNote(onClickHandler = {
                list.remove(note)
            })
        }

    }
    Spacer(modifier = Modifier.height(10.dp))
}
