package com.example.examfriendlychatter.viewmodel

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.examfriendlychatter.data.Message

class ChatRoomViewModel : ViewModel() {
    private val _messageList = mutableStateListOf<Message>()
    val messageList: List<Message> get() = _messageList

    var currentImageUri = mutableStateOf<Uri?>(null)
        private set
    private val userProfileImages = mutableStateMapOf<String, Uri?>()
    init {
        _messageList.addAll(
            listOf(
                Message("Hello", "Me"),
                Message("Hi", "Me2")
            )
        )
    }
    fun addMessage(message: String, from: String) {
        _messageList.add(Message(message, from))
    }
    fun saveProfileImage(user: String, imageUri: Uri?) {
        userProfileImages[user] = imageUri
        currentImageUri.value = imageUri
    }
    fun getProfileImage(user: String): Uri? {
        return userProfileImages[user]
    }
}