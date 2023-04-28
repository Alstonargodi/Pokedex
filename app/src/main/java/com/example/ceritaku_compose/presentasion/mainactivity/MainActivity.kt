package com.example.ceritaku_compose.presentasion.mainactivity

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ceritaku_compose.R
import com.example.ceritaku_compose.presentasion.mainactivity.theme.CeritakucomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = getColor(R.color.orange)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        setContent {
            CeritakucomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainActivityApp()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFF121212))
            .wrapContentSize(Alignment.Center),
    ) {
        Text(
            text = "Main",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 60.sp,
            fontStyle = FontStyle(R.font.poppinsregular)
        )
    }
}

@Composable
fun Header(
    showSearch : (Boolean) -> Unit
){
    var visible by remember { mutableStateOf(false) }
    showSearch(visible)
    Row(
        modifier = Modifier
            .background(Color(0xFFE8592D))
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(
                    top = 5.dp,
                    bottom = 5.dp
                )
                .fillMaxWidth()
        ) {
            Text(
                text = "Pokedex",
                modifier = Modifier
                    .padding(
                        top = 2.dp,
                        start = 5.dp
                    )
                    .align(Alignment.CenterStart)
                ,
                textAlign = TextAlign.Start,
                color = Color.White,
                fontSize = 30.sp,
                fontStyle = FontStyle(
                    R.font.poppinsregular,
                ),
                fontWeight = FontWeight.Bold,
            )
            IconButton(
                onClick = { visible = !visible },
                modifier = Modifier
                    .height(40.dp)
                    .align(Alignment.CenterEnd)
                    .padding(
                        top = 2.dp,
                        end = 5.dp
                    ),
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = Color.White,
                    contentDescription = "search",
                )
            }
        }
    }
}


@Composable
fun MainActivityApp(){
    var valueVisible by remember { mutableStateOf(false) }
    Column {
        Header(
            showSearch = { valueVisible = it}
        )
        SearchBar(isShow = valueVisible)
        Greeting()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    CeritakucomposeTheme {
       MainActivityApp()
    }
}