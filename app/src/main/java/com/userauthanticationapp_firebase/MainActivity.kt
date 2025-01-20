package com.userauthanticationapp_firebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.userauthanticationapp_firebase.navigation.MyAppNavigation
import com.userauthanticationapp_firebase.ui.screens.AuthViewModel
import com.userauthanticationapp_firebase.ui.theme.UserAuthanticationAppFirebaseTheme

class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            UserAuthanticationAppFirebaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyAppNavigation(
                        modifier = Modifier.padding(innerPadding),
                        authViewModel = authViewModel
                    )

                }
            }
        }
    }
}

