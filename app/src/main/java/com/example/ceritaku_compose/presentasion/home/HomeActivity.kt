package com.example.ceritaku_compose.presentasion.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ceritaku_compose.presentasion.home.component.HeaderHome
import com.example.ceritaku_compose.presentasion.home.component.ProgreesBar
import com.example.ceritaku_compose.presentasion.home.component.SearchBar
import com.example.ceritaku_compose.presentasion.home.list.CharacterList
import com.example.ceritaku_compose.presentasion.home.viewmodel.HomeActivityViewModel
import com.example.ceritaku_compose.presentasion.viewmodelfactory.ViewModelFactory
import com.example.ceritaku_compose.remote.response.PokemonListResult

@Composable
fun Home(
    isVisible : Boolean,
    text : String,
    viewModel : HomeActivityViewModel = viewModel(
        factory = ViewModelFactory.getInstance()
    ),
    navigateToDetail: (String)->Unit
){
    var valueVisible by remember { mutableStateOf(isVisible) }
    var text by remember { mutableStateOf(text) }
    var pokemonList by remember { viewModel.pokemonList }
    var isLoading by remember {viewModel.isLoading }

    Column {
        HeaderHome(
            showSearch = { valueVisible = it }
        )
        SearchBar(isShow = valueVisible, onQueryChange = {text = it})
        Box {
            CharacterList(
                pokemonList = pokemonList,
                navigateToDetail = navigateToDetail
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ProgreesBar(isLoading)
            }
        }
    }


}