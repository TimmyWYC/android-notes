package com.example.androidnotesapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidnotesapp.Screens.AddScreen
import com.example.androidnotesapp.Screens.DetailScreen
import com.example.androidnotesapp.Screens.EditScreen
import com.example.androidnotesapp.Screens.MainScreen
import com.example.androidnotesapp.Screens.Screen

/*
*Define the navigation for your app using Jetpack Compose Navigation.
*/
@Composable
fun Navigation(list: MutableList<Note>){
    // Create a navigation controller to manage the navigation within your app.
    val navController = rememberNavController()
    // Define the starting destination for your app's navigation.
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        // Define different screens (composable) and their routes.
        composable(route = Screen.MainScreen.route){
            // Show the MainScreen
            MainScreen(list,navController = navController)
        }
        composable(route = Screen.AddScreen.route){
            // Show the Add Screen
            AddScreen(list, navController = navController)
        }
        composable(route = Screen.EditScreen.route){ navBackStackEntry ->
            //retrieve the index from the navigation arguments.
            val index = navBackStackEntry.arguments?.getString("index") ?: ""
            // Show the Edit Screen,
            EditScreen(list, index = index, navController = navController)
        }
        composable(route = Screen.DetailScreen.route){navBackStackEntry ->
            val index = navBackStackEntry.arguments?.getString("index") ?: ""
            val note = list[index.toInt()]
            // Show the DetailScreen
            DetailScreen(note,navController = navController)
        }
    }
}
