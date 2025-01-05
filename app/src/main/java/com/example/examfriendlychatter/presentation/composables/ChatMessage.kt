package com.example.examfriendlychatter.presentation.composables

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.rememberAsyncImagePainter
import com.example.examfriendlychatter.R
import com.example.examfriendlychatter.data.Message
import com.example.examfriendlychatter.data.Screen

@Composable
fun ChatMessage(message: Message, isLeft: Boolean = true, navController: NavController, currentImageUri: Uri?) {
    Row (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
            .semantics { contentDescription = "ChatMessage" }
        ,

        horizontalArrangement = if (isLeft) {
            Arrangement.Start
        } else {
            Arrangement.End
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isLeft) {
            ProfilePicture(from = message.from, navController, currentImageUri)
            VerticalDivider(
                modifier = Modifier
                    .width(2.dp)
                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
                    .height(80.dp)
                    .background(MaterialTheme.colorScheme.secondary)
                    .semantics { contentDescription = "Don'tWorryNoTestingHereLol" }
            )
            Spacer(modifier = Modifier.width(16.dp).semantics { contentDescription = "ImagineTestingASpacer" })
        }
        MessageField(message = message.message)
        if (!isLeft) {
            Spacer(modifier = Modifier.width(16.dp).semantics { contentDescription = "VeryImportantSpacer" })
            VerticalDivider(
                modifier = Modifier
                    .width(2.dp)
                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
                    .height(80.dp)
                    .background(MaterialTheme.colorScheme.secondary)
                    .semantics { contentDescription = "VeryImportantDivider" }
            )
            ProfilePicture(from = message.from, navController, currentImageUri)
        }
    }
}


@Composable
fun ProfilePicture(from: String, navController: NavController, currentImageUri: Uri?) {
    val imagePainter = if (currentImageUri != null) {
        rememberAsyncImagePainter(model = currentImageUri)
    } else {
        painterResource(id = R.drawable.ic_launcher_foreground)
    }
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .padding(0.dp, 0.dp, 0.dp, 0.dp)
            .semantics { contentDescription = "ProfilePicture" },
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            //painter = painterResource(id = R.drawable.ic_launcher_foreground),
            painter = imagePainter,
            contentDescription = "Profile Picture",
            modifier = Modifier.width(50.dp).semantics { contentDescription = "ChatProfilePicture" }
                .clickable { navController.navigate(Screen.ProfileScreen.route + "/$from") }
        )
        Text(text = from,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.semantics { contentDescription = "ChatProfileName" }
        )
    }
}

@Composable
fun MessageField(message: String) {
    Text(text = message,
        style = MaterialTheme.typography.displayMedium,
        modifier = Modifier.semantics { contentDescription = "ChatMessageText" }
    )
}