package com.example.androidnotesapp.Functions

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DeleteNote(onClickHandler: () -> Unit){
    // Create a button that triggers the specified `onClickHandler` when clicked.
    Button(
        onClick = {
            // When the button is clicked, it calls the `onClickHandler` function.
            // The `onClickHandler` function is sent by the caller
            onClickHandler()
        }) {
        Text(text = "Delete")
    }
}
