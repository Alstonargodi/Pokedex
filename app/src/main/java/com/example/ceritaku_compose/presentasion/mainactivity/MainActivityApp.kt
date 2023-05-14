package com.example.ceritaku_compose.presentasion.mainactivity

import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ceritaku_compose.presentasion.detailpokemon.DetailPokemon
import com.example.ceritaku_compose.presentasion.home.Home
import com.example.ceritaku_compose.presentasion.screen.Screen
import com.example.ceritaku_compose.remote.response.PokemonListResult
import com.google.gson.Gson

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
                navigateToDetail = { name->
                    navController.navigate(
                        Screen.DetailPokemon.createRoute(name)
                    )
                }
            )
        }
        composable(
            route = Screen.DetailPokemon.route,
        ){
            val id = it.arguments?.getString("name")
            DetailPokemon(
                data = id ?: "",
            )
        }
    }
}
