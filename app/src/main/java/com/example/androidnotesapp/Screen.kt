package com.example.androidnotesapp

sealed class Screen(val route: String){
    object MainScreen: Screen("main_screen")
    object AddScreen: Screen("Add_screen")
    object EditScreen: Screen("Edit_screen")
}
