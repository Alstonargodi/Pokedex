package com.example.pokedek.Model.Retrofit

import com.example.pokedek.Model.Getdataapi
import com.google.gson.Gson
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