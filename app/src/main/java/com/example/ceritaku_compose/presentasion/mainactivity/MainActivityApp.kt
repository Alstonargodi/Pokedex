package com.example.ceritaku_compose.presentasion.mainactivity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ceritaku_compose.presentasion.detailpokemon.DetailPokemon
import com.example.ceritaku_compose.presentasion.mainactivity.component.Header
import com.example.ceritaku_compose.presentasion.mainactivity.component.ProgreesBar
import com.example.ceritaku_compose.presentasion.mainactivity.component.SearchBar
import com.example.ceritaku_compose.presentasion.mainactivity.list.CharacterList
import com.example.ceritaku_compose.presentasion.mainactivity.viewmodel.MainActivityViewModel
import com.example.ceritaku_compose.presentasion.screen.Screen
import com.example.ceritaku_compose.presentasion.viewmodelfactory.ViewModelFactory

@Composable
fun MainActivityApp(
    navController: NavHostController = rememberNavController()
) {
    var valueVisible by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ){
        composable(Screen.Home.route){
            Home(
                isVisible = valueVisible,
                text = text,
                navigateToDetail = {
                    navController.navigate(
                        Screen.DetailPokemon.createRoute(it)
                    )
                }
            )
        }
        composable(
            route = Screen.DetailPokemon.route,
        ){
            val id = it.arguments?.getString("id") ?: ""
            DetailPokemon(name = id)
        }
    }
}

@Composable
fun Home(
    isVisible : Boolean,
    text : String,
    viewModel : MainActivityViewModel = viewModel(
        factory = ViewModelFactory.getInstance()
    ),
    navigateToDetail: (String)->Unit
){
    var valueVisible by remember { mutableStateOf(isVisible) }
    var text by remember { mutableStateOf(text) }
    var pokemonList by remember { viewModel.pokemonList }
    var isLoading by remember {viewModel.isLoading }

    Column {
        Header(
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