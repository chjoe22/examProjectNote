package com.example.examfriendlychatter.data

sealed class Screen(val route: String){
    object MainScreen: Screen("main")
    object ChatRoomScreen: Screen("chat_room")
    object ProfileScreen: Screen("profile_screen/{user}"){
        fun createRoute(user: String) = "profile_screen/$user"
    }
}