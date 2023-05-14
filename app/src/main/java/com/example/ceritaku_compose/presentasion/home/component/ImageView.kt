package com.example.ceritaku_compose.presentasion.home.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ImageView(
    photoUrl : String,
    modifier: Modifier
){

    val imgUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${photoUrl}.png"
    AsyncImage(
        model = imgUrl ,
        contentDescription = "imageCharacter",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}