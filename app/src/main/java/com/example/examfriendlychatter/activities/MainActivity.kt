package com.example.examfriendlychatter.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.examfriendlychatter.presentation.screens.ChatRoom
import com.example.examfriendlychatter.presentation.screens.MainScreen
import com.example.examfriendlychatter.presentation.theme.ExamFriendlyChatterTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamFriendlyChatterTheme(
                dynamicColor = false
            ) {
                MainScreen()
            }
        }
    }
}





