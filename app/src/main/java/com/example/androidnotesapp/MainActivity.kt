package com.example.androidnotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidnotesapp.ui.theme.AndroidNotesAppTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val listOfNotes = remember{
                mutableStateListOf<Note>(Note(title = "note1", text = "text1"), Note(title = "note2", text = "text2"))
            }
            AndroidNotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(list = listOfNotes)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    val listOfNotes = remember{
        mutableStateListOf<Note>(Note(title = "note1", text = "text1"), Note(title = "note2", text = "text2"))
    }
    AndroidNotesAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Navigation(list = listOfNotes)
        }
    }
}