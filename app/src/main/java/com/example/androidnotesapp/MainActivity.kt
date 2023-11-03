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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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

@Composable
fun MainScreen(list: MutableList<Note>, navController: NavController, modifier: Modifier = Modifier.background(Color.LightGray)) {
    Column (
        modifier = modifier
            .fillMaxSize()
    ){
        AddNote(navController)
        ListView(list = list, navController)
    }
}

@Composable
fun AddScreen(list: MutableList<Note>, navController: NavController ){
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
        OutlinedTextField(
            value = title,
            onValueChange = { title = it},
            label = { Text("Title") },
            modifier = Modifier
                .fillMaxWidth()
        )
        if (showError) {Text(text = "Title: 3..30")}
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            label = { Text(text = "Text") },
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
            )
        if (showError) {Text(text = "text: <= 150")}
        Row {
            Button(onClick = {
                if(title.length in 3..30 && text.length <= 150){
                    list.add(Note(title = title,text = text))
                    navController.navigate(Screen.MainScreen.route)
                }else{
                    showError = true
                }
            }) {
                Text(text = "Ok")
            }
            Button(onClick = {
                navController.navigate(Screen.MainScreen.route)
            }) {
                Text(text = "Cancel")
            }
        }
    }
}

@Composable
fun EditScreen(list: MutableList<Note>, index: String, navController: NavController){
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
        OutlinedTextField(
            value = title,
            onValueChange = { title = it},
            label = { Text("Title") },
            modifier = Modifier
                .fillMaxWidth()
        )
        if (showError) {Text(text = "Title: 3..30")}
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            label = { Text(text = "Text") },
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
        if (showError) {Text(text = "text: <= 150")}
        Row {
            Button(onClick = {
                if(title.length in 3..30 && text.length <= 150){
                    list[index.toInt()].title = title
                    list[index.toInt()].text = text
                    navController.navigate(Screen.MainScreen.route)
                }else{
                    showError = true
                }
            }) {
                Text(text = "Ok")
            }
            Button(onClick = {
                navController.navigate(Screen.MainScreen.route)
            }) {
                Text(text = "Cancel")
            }
        }
    }
}

@Composable
fun ListView(list: MutableList<Note>, navController: NavController) {
    LazyColumn {
        items(list) {note ->
            RowView(note, list, navController)
        }
    }
}

@Composable
fun RowView(note: Note, list: MutableList<Note>,navController: NavController) {
    var index by rememberSaveable {
        mutableStateOf("")
    }
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
            Button(onClick = {
                //index = {list.indexOf(note)}.toString()
                index = list.indexOf(note).toString()
                navController.navigate(Screen.EditScreen.route.replace("{index}", index))
            }) {
                Text(text = "Edit")
            }
            DeleteNote(onClickHandler = {
                list.remove(note)
            })
        }

    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun AddNote(navController: NavController){
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
            navController.navigate(Screen.AddScreen.route)
        }) {
            Text(text = "Add")
        }
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
            Navigation(list = listOfNotes)
        }
    }
}