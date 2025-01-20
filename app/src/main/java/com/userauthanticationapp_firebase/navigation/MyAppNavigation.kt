package com.userauthanticationapp_firebase.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.userauthanticationapp_firebase.ui.screens.AuthViewModel
import com.userauthanticationapp_firebase.ui.screens.HomeScreen
import com.userauthanticationapp_firebase.ui.screens.LoginScreen1
import com.userauthanticationapp_firebase.ui.screens.RegisterScreen1

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login") {
            LoginScreen1(
                modifier = modifier,
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable("signup") {
            RegisterScreen1(
                modifier = modifier,
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable("home") {
            HomeScreen(
                modifier = modifier,
                navController = navController,
                authViewModel = authViewModel
            )
        }
    })
}