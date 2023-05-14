package com.example.ceritaku_compose.presentasion.screen

import com.example.ceritaku_compose.remote.response.PokemonListResult

sealed class Screen(val route : String){
    object Home : Screen("home")
    object DetailPokemon : Screen("home/{name}"){
        fun createRoute(
            name : String,
        ) = "home/$name"
    }
}
