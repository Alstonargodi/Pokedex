package com.example.ceritaku_compose.presentasion.home.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
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
    isShow : Boolean,
    onQueryChange : (String) -> Unit,
){
    AnimatedVisibility(
        visible = isShow
    ) {
        TextField(
            value = "",
            onValueChange = onQueryChange,
            modifier = modifier
                .background(Color.White)
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                disabledIndicatorColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,

            ),
            placeholder = {
                Text(text = "search pokemon")
            },
            keyboardActions = KeyboardActions()
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun SearchPreview(){
    CeritakucomposeTheme {
//        SearchBar(isShow = false)
    }
}