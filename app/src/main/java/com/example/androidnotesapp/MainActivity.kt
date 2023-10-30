package com.example.androidnotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidnotesapp.ui.theme.AndroidNotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val listOfNotes = remember{
                mutableStateListOf<Note>(Note(title = "hello", text = "text"))
            }
            AndroidNotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(list = listOfNotes)
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    list: MutableList<Note>,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxSize()
    ){
        ListView(list = list)
    }
}

@Composable
fun ListView(list: List<Note>) {
    LazyColumn {
        items(list) {note ->
            RowView(note)
        }
    }
}

@Composable
fun RowView(note: Note) {
    Row(
        modifier = Modifier
            .fillMaxSize(),
    ){
        Text(note.title)
        Text(note.text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val listOfNotes = remember{
        mutableStateListOf<Note>(Note(title = "hello", text = "text"))
    }
    AndroidNotesAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen(list = listOfNotes)
        }
    }
}