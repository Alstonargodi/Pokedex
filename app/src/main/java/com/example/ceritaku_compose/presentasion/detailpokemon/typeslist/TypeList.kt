package com.example.ceritaku_compose.presentasion.detailpokemon.typeslist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ceritaku_compose.remote.response.Type

@Composable
fun TypeList(
    modifier: Modifier = Modifier,
    typeList : List<Type>,
){
    Box(modifier = modifier){
        LazyColumn{
            items(typeList.size){ data ->
                TypeListItem(
                    name = typeList[data].type.name,
                    modifier = modifier
                )
            }
        }
    }
}