package com.example.pokedek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.model.remote.ApiRepository
import com.example.pokedek.viewmodel.Api.Apiviewmodel
import com.example.pokedek.viewmodel.Api.VModelFactory
import com.example.pokedek.databinding.FragmentListPokemonBinding


class ListPokemon : Fragment() {
    lateinit var bind : FragmentListPokemonBinding
    lateinit var apiviewmodel : Apiviewmodel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentListPokemonBinding.inflate(layoutInflater)
        val repo = ApiRepository()
        val vmfac = VModelFactory(repo)
        apiviewmodel = ViewModelProvider(this,vmfac).get(Apiviewmodel::class.java)


        return bind.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}