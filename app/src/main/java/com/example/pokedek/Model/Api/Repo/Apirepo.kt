package com.example.pokedek.Model.Api.Repo

import com.example.pokedek.Model.Api.Pokemonsum.Pokesummary
import com.example.pokedek.Model.Api.Retrofitbuilder
import com.example.pokedek.Model.Api.pokemonlist.Pokemon
import retrofit2.Response

class Apirepo() {

    suspend fun getlist(): Response<Pokemon>{
        return Retrofitbuilder.apipokem.getlist()
    }


    suspend fun getsum(id : String):Response<Pokesummary>{
        return Retrofitbuilder.sumpoke.getsum(id)
    }

}