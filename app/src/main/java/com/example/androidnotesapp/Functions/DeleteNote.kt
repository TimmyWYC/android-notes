package com.example.androidnotesapp.Functions

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DeleteNote(onClickHandler: () -> Unit){
    Button(
        onClick = {
            onClickHandler()
        }) {
        Text(text = "Delete")
    }
}
