package com.example.pokedek.Model.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitbuilder {

    //pokemon list
    val pokemonbuild by lazy {
            Retrofit.Builder()
                .baseUrl(Constant.base)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    val getpokemonlist : Getdataapi by lazy {
        pokemonbuild.create(Getdataapi::class.java)
    }

    //pokemon summary
    val pokemsum by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val getpokesum : Getdataapi by lazy {
        pokemsum.create(Getdataapi::class.java)
    }

    //pokemon ability
    val pokeabt by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getpokeabt : Getdataapi by lazy {
        pokeabt.create(Getdataapi::class.java)
    }

    //pokemon moves
    val pokemoves by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val getpokemoves : Getdataapi by lazy {
        pokemoves.create(Getdataapi::class.java)
    }

    //berrylist
    val berylazy by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getberrylist : Getdataapi by lazy {
        berylazy.create(Getdataapi::class.java)
    }

    //berrysum
    val berrysum by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getberrysum : Getdataapi by lazy {
        berrysum.create(Getdataapi::class.java)
    }


    //itemsum
    val itemlist by lazy{
        Retrofit.Builder()
            .baseUrl(Constant.base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val getitemlist : Getdataapi by lazy {
        itemsum.create(Getdataapi::class.java)
    }

    val itemsum by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getitemsum : Getdataapi by lazy {
        itemsum.create(Getdataapi::class.java)
    }

}