package com.example.ceritaku_compose.presentasion.mainactivity.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ceritaku_compose.presentasion.splashscreen.ui.theme.CeritakucomposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar (
    modifier: Modifier = Modifier,
    isShow : Boolean
){
    AnimatedVisibility(
        visible = isShow
    ) {
        TextField(
            value = "",
            onValueChange = { },
            modifier = modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(text = "Find Pokemon")
            }
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun SearchPreview(){
    CeritakucomposeTheme {
        SearchBar(isShow = false)
    }
}