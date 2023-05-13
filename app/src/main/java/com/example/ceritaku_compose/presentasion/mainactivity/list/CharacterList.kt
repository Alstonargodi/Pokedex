package com.example.ceritaku_compose.presentasion.mainactivity.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ceritaku_compose.presentasion.detailpokemon.DetailPokemon
import com.example.ceritaku_compose.remote.response.PokemonListResult

@Composable
fun CharacterList(
    modifier: Modifier = Modifier,
    pokemonList : List<PokemonListResult>,
    navigateToDetail: (String)->Unit
) {
    var selectedItem by remember { mutableStateOf("") }

    if (selectedItem != ""){
        DetailPokemon(name = selectedItem)
    }

    Box(modifier = modifier) {
        LazyColumn {
            items(pokemonList.size) { data ->
                PokedexListItem(
                    name = pokemonList[data].name,
                    photoUrl = pokemonList[data].url,
                    modifier = Modifier
                        .clickable { navigateToDetail(pokemonList[data].name) }
                        .padding(5.dp),
                )
            }
        }
    }
}
