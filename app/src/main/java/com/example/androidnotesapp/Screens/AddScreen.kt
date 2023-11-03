package com.example.androidnotesapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidnotesapp.Note


@Composable
fun AddScreen(list: MutableList<Note>, navController: NavController){
    // Define mutable state variables for the title, text, and an error flag.
    var title by rememberSaveable{
        mutableStateOf("")
    }
    var text by rememberSaveable{
        mutableStateOf("")
    }
    var showError by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        // Display an OutlinedTextField for adding the title.
        OutlinedTextField(
            value = title,
            onValueChange = { title = it},
            label = { Text("Title") },
            modifier = Modifier
                .fillMaxWidth()
        )
        if (showError) {
            Text(text = "Title: 3..30")
        }
        // Display an OutlinedTextField for adding the text.
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            label = { Text(text = "Text") },
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
        if (showError) {
            Text(text = "text: <= 150")
        }
        // Create a row with "Ok" and "Cancel" buttons
        Row {
            Button(onClick = {
                if(title.length in 3..30 && text.length <= 150){
                    // Add a new note to the list
                    list.add(Note(title = title,text = text))
                    navController.navigate(Screen.MainScreen.route)
                }else{
                    showError = true
                }
            }) {
                Text(text = "Ok")
            }
            Button(onClick = {
                // Navigate back to the main screen without adding
                navController.navigate(Screen.MainScreen.route)
            }) {
                Text(text = "Cancel")
            }
        }
    }
}