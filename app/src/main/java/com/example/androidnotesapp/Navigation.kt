package com.example.androidnotesapp



import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(list: MutableList<Note>){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(list,navController = navController)
        }
        composable(route = Screen.AddScreen.route){
            AddScreen(list, navController = navController)
        }
        composable(route = Screen.EditScreen.route){navBackStackEntry ->
            val index = navBackStackEntry.arguments?.getString("index") ?: ""
            EditScreen(list, index = index, navController = navController)
        }
    }
}
