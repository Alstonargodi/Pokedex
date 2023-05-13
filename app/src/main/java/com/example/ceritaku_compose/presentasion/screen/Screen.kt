package com.example.ceritaku_compose.presentasion.screen

sealed class Screen(val route : String){
    object Home : Screen("home")
    object DetailPokemon : Screen("home/{id}"){
        fun createRoute(id : String) = "home/$id"
    }
}
