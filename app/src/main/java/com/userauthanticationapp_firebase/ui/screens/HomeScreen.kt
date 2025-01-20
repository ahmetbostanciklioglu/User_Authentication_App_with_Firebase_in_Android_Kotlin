package com.userauthanticationapp_firebase.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    modifier: Modifier,
    navController: NavHostController,
    authViewModel: AuthViewModel
) {

    LaunchedEffect(authViewModel.authState.value) {
        when (authViewModel.authState.value) {
            is AuthState.Unauthenticated -> navController.navigate("login")
            else -> Unit
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Screen", fontSize = 32.sp)


        Button(onClick = {

            navController.navigate("login")
            authViewModel.signout()
        }) {
            Text("Sign out")
        }
    }
}