package com.example.pokedek.Model.Api.Repo

import com.example.pokedek.Model.Api.Berry.BerryList.Berrylist
import com.example.pokedek.Model.Api.Berry.Berysum.Berrysum
import com.example.pokedek.Model.Api.Item.Itemsum
import com.example.pokedek.Model.Api.Pokemon.Pokeablity.Pokeablty
import com.example.pokedek.Model.Api.Pokemon.Pokemonsum.Pokesummary
import com.example.pokedek.Model.Api.Pokemon.Pokemoves.Pokemoves
import com.example.pokedek.Model.Api.Retrofitbuilder
import com.example.pokedek.Model.Api.Pokemon.pokemonlist.Pokemonlist
import retrofit2.Response

class Apirepo() {

    //pokemon
    suspend fun getlist(): Response<Pokemonlist>{
        return Retrofitbuilder.getpokemonlist.getlist()
    }
    suspend fun getsum(id : String):Response<Pokesummary>{
        return Retrofitbuilder.getpokesum.getsum(id)
    }
    suspend fun getability(id: String):Response<Pokeablty>{
        return Retrofitbuilder.getpokeabt.getabltysum(id)
    }
    suspend fun getmoves(id: String): Response<Pokemoves>{
        return Retrofitbuilder.getpokemoves.getmovessum(id)
    }

    //berry
    suspend fun getberrylist(): Response<Berrylist>{
        return Retrofitbuilder.getberrylist.getberrylist()
    }
    suspend fun getberrysum(id : String): Response<Berrysum>{
        return Retrofitbuilder.getberrysum.getberrysum(id)
    }

    //item
    suspend fun getitemsum(id : String): Response<Itemsum>{
        return Retrofitbuilder.getitemsum.getitemsum(id)
    }
}