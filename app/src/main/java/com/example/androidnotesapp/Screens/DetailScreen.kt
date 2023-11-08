package com.example.androidnotesapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidnotesapp.Note

@Composable
fun DetailScreen(note: Note, navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(10.dp)
        ){
            Text(text = "Note",
                color = Color(227,119,36,255),
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            // Create a spacer to push the "Add" button to the right.
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = {
                navController.navigate(Screen.MainScreen.route)
            }) {
                Text(text = "Back")
            }
        }
        Column (
            modifier = Modifier
                .padding(10.dp)
        ){
            // Display an OutlinedTextField for adding the title.
            Text(
                text = note.title,
                color = Color(227,119,36,255),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            // Display an OutlinedTextField for adding the text.
            Text(
                text = note.text,
                color = Color(227,119,36,255),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

    }
}