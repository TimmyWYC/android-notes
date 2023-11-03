package com.example.androidnotesapp.Screens

sealed class Screen(val route: String){
    // Define different screens as objects with their route identifiers.
    object MainScreen: Screen("main_screen")
    object AddScreen: Screen("Add_screen")
    // The edit screen has a dynamic route with an index as a placeholder.
    // This allows you to specify the index when navigating to the edit screen.
    // and not crashing!!!!!!
    object EditScreen: Screen("Edit_screen/{index}")
}
