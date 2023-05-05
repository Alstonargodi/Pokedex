package com.example.ceritaku_compose.presentasion.mainactivity.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ceritaku_compose.presentasion.mainactivity.theme.CeritakucomposeTheme

@Composable
fun PokedexListItem(
    name : String,
    photoUrl : String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {  }
    ) {
        val url = photoUrl.removePrefix("https://pokeapi.co/api/v2/pokemon/")
        val idUrl = url.replace("/","")
        val imgUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${idUrl}.png"
        AsyncImage(
            model = imgUrl ,
            contentDescription = "imageCharacter",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun listPreview(){
    CeritakucomposeTheme {
        PokedexListItem(name = "a", photoUrl = "")
    }
}