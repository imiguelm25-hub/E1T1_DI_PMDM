package com.example.e1t1_di

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNabigazio (modifier: Modifier = Modifier){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        composable("login") {
            Login(
                onLoginSuccess = {
                    navController.navigate("menua")
                }
            )
        }
        composable("menua") {
            Menua(
                onBack = { navController.popBackStack() },
                onEkitaldiGuztiak = { navController.navigate("ekitaldiak") },
            )
        }
        composable("ekitaldiak") {
            ekitaldiGuztiak(
                onBack = { navController.popBackStack() }
            )
        }
    }
}