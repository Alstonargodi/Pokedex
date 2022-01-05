package com.example.pokedek.Model.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitbuilder {

    val pokemonbuild by lazy {
            Retrofit.Builder()
                .baseUrl(Constant.base)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    val apipokem : Getdataapi by lazy {
        pokemonbuild.create(Getdataapi::class.java)
    }


    //pokemon summary
    val pokemsum by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.basesum)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val sumpoke : Getdataapi by lazy {
        pokemsum.create(Getdataapi::class.java)
    }
}