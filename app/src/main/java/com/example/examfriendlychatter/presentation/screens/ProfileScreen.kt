package com.example.examfriendlychatter.presentation.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import com.example.examfriendlychatter.viewmodel.ChatRoomViewModel

@Composable
fun ProfileScreen(navController: NavController, user: String, viewModel: ChatRoomViewModel){
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
    ) {
        Column (
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(32.dp))
                    .clickable { launcher.launch("image/*") }
            ) {
                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUri ?: android.R.drawable.ic_menu_camera)
                        .build()
                )
                Image(
                    painter = painter,
                    //painter = painterResource(id = android.R.drawable.ic_menu_camera),
                    contentDescription = "Profile Picture",
                    Modifier.size(150.dp).clip(RoundedCornerShape(32.dp))
                )
            }
            Text(text = user, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(16.dp))
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            navController.popBackStack() },
            modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
            Text("Go Back")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            viewModel.saveProfileImage(user, imageUri)
            navController.popBackStack()
        }, modifier = Modifier.fillMaxWidth().height(50.dp)) {
            Text("Save")
        }
    }
}