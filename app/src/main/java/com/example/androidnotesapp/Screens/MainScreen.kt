package com.example.androidnotesapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.androidnotesapp.Functions.AddNote
import com.example.androidnotesapp.Note
import com.example.androidnotesapp.View.ListView

@Composable
fun MainScreen(list: MutableList<Note>, navController: NavController, modifier: Modifier = Modifier.background(
    Color.LightGray)) {
    Column (
        modifier = modifier
            .fillMaxSize()
    ){
        AddNote(navController)
        ListView(list = list, navController)
    }
}