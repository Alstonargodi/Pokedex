package com.example.ceritaku_compose.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ceritaku_compose.mainactivity.MainActivity
import com.example.ceritaku_compose.R
import com.example.ceritaku_compose.splashscreen.ui.theme.CeritakucomposeTheme

class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler( Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        },2000)
        setContent {
            CeritakucomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreen("Android")
                }
            }
        }
    }
}

@Composable
fun SplashScreen(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFF344D67))
            .wrapContentSize(Alignment.Center),
    ) {
        Text(
            text = "Pokedex",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(0xFF609EA2),
            fontSize = 60.sp,
            fontFamily = FontFamily(
                Font(R.font.poppinsbold,FontWeight.Bold)
            )
        )
        Image(
            painter = painterResource(id = R.drawable.ball),
            contentDescription = "logo",
            modifier = Modifier.padding(50.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview2() {
    CeritakucomposeTheme {
        SplashScreen("Android")
    }
}