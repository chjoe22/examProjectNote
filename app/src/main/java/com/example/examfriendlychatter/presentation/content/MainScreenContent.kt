package com.example.examfriendlychatter.presentation.content

import com.example.examfriendlychatter.data.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreenContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Go to Chat Room",
            modifier = Modifier
                .clickable { navController.navigate(Screen.ChatRoomScreen.route) }
                .padding(16.dp)
        )
    }
}