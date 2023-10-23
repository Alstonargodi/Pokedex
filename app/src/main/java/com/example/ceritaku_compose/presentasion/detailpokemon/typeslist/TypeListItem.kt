package com.example.ceritaku_compose.presentasion.detailpokemon.typeslist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TypeListItem(
    name : String,
    modifier: Modifier
){
    Card(
        modifier = modifier
    ){
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun itemPreview(){
    TypeListItem(
        name = "title",
        modifier = Modifier.padding(start = 0.dp)
    )
}