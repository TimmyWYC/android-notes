package com.example.androidnotesapp.View

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.androidnotesapp.Note

@Composable
fun ListView(list: MutableList<Note>, navController: NavController) {
    // Create a LazyColumn, which is a scrollable list of items.
    LazyColumn {
        // Iterate through the list of notes and create a RowView for each note for display for each note
        items(list) {note ->
            RowView(note, list, navController)
        }
    }
}
