package com.example.ceritaku_compose.mainactivity

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ceritaku_compose.splashscreen.ui.theme.CeritakucomposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar (
    modifier: Modifier = Modifier
){
    TextField(
        value = "",
        onValueChange = { },
        modifier = modifier
            .padding(16.dp)
    )
}

@Preview(
    showBackground = true
)
@Composable
fun SearchPreview(){
    CeritakucomposeTheme {
        SearchBar()
    }
}