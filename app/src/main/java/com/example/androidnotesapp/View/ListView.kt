package com.example.androidnotesapp.View

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.androidnotesapp.Note

@Composable
fun ListView(list: MutableList<Note>, navController: NavController) {
    LazyColumn {
        items(list) {note ->
            RowView(note, list, navController)
        }
    }
}
