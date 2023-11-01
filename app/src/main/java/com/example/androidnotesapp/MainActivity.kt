package com.example.androidnotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    MainScreen(list = listOfNotes)
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    list: MutableList<Note>,
    modifier: Modifier = Modifier.background(Color.LightGray)
) {
    Column (
        modifier = modifier
            .fillMaxSize()
    ){
        AddNote(list = list)
        ListView(list = list)
    }
}

@Composable
fun ListView(list: MutableList<Note>) {
    LazyColumn {
        items(list) {note ->
            RowView(note, list)
        }
    }
}

@Composable
fun RowView(note: Note, list: MutableList<Note>) {
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
            EditNote(list)
            DeleteNote(onClickHandler = {
                list.remove(note)
            })
        }

    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun AddNote(list: MutableList<Note>){
    var title by rememberSaveable{
        mutableStateOf("")
    }
    var text by rememberSaveable{
        mutableStateOf("")
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(10.dp)
    ){
        Text(text = "Notes",
            color = Color(227,119,36,255),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            list.add(Note(title = "test",text = "test"))
        }) {
            Text(text = "Add")
        }
    }
}

@Composable
fun EditNote(list: MutableList<Note>, ){
    Button(
        onClick = {

    }) {
        Text(text = "Edit")
    }
}

@Composable
fun DeleteNote(onClickHandler: () -> Unit){
    Button(
        onClick = {
            onClickHandler()
    }) {
        Text(text = "Delete")
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
            MainScreen(list = listOfNotes)
        }
    }
}