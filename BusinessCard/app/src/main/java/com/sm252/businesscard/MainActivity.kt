package com.sm252.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sm252.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD2E8D4) // Color de fondo personalizado
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonalInfoSection()
        Spacer(modifier = Modifier.height(100.dp)) // Espaciador entre las dos secciones
        ContactInfoSection()
    }
}

@Composable
fun PersonalInfoSection() {
    val image = painterResource(R.drawable.android_logo) // Asume que tienes un logo de Android en drawable
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = stringResource(R.string.android_logo_description),
            modifier = Modifier.size(100.dp).background(Color(0xFF073042))
        )
        Text(
            text = stringResource(R.string.full_name),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(R.string.title),
            fontSize = 16.sp,
            color = Color(0xFF3DDC84)
        )
    }
}

@Composable
fun ContactInfoSection() {
    Column {
        ContactRow(
            icon = Icons.Default.Call,
            content = stringResource(R.string.phone_number),
            contentDescription = stringResource(R.string.call_icon_description)
        )
        ContactRow(
            icon = Icons.Default.Share,
            content = stringResource(R.string.social_handle),
            contentDescription = stringResource(R.string.share_icon_description)
        )
        ContactRow(
            icon = Icons.Default.Email,
            content = stringResource(R.string.email),
            contentDescription = stringResource(R.string.email_icon_description)
        )
    }
}

@Composable
fun ContactRow(icon: ImageVector, content: String, contentDescription: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = Color(0xFF3DDC84),
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = content,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp),
            color = Color(0xFF073042)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFD2E8D4)
        ) {
            BusinessCardApp()
        }
    }
}