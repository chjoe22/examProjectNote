package com.example.examfriendlychatter.presentation.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examfriendlychatter.data.Screen
import com.example.examfriendlychatter.presentation.content.MainScreenContent
import com.example.examfriendlychatter.viewmodel.ChatRoomViewModel

@Composable
fun MainScreen() {
    val viewModel: ChatRoomViewModel = viewModel()
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxWidth()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.MainScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screen.MainScreen.route) {
                MainScreenContent(navController)
            }
            composable(route = Screen.ChatRoomScreen.route) {
                ChatRoom(navController, viewModel)
            }
            composable(route = Screen.ProfileScreen.route + "/{user}") { backStackEntry ->
                val username = backStackEntry.arguments?.getString("user")
                username?.let { ProfileScreen(navController, it, viewModel) }
            }
        }
    }
}