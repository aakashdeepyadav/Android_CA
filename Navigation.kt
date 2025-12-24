package com.example.ca2_android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(
            navController = navController,
            startDestination = "login"
        ) {
            composable("login") {
                Login(navController)
            }
            composable("dashboard/{email}") {
                backStackEntry->
                val email=backStackEntry.arguments?.getString("email") ?: ""
                Dashboard(navController, email=email)
            }


    }

}