package com.example.pokedek.Model

import com.example.pokedek.Model.Pokemonsum.Pokesummary
import com.example.pokedek.Model.Retrofit.Retrofitbuilder
import com.example.pokedek.Model.pokemonlist.Pokemon
import retrofit2.Response

class Apirepo() {

    suspend fun getlist(): Response<Pokemon>{
        return Retrofitbuilder.apipokem.getlist()
    }


    suspend fun getsum(id : String):Response<Pokesummary>{
        return Retrofitbuilder.sumpoke.getsum(id)
    }

}