package com.example.pokedek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.model.remote.ApiRepository
import com.example.pokedek.viewmodel.Api.ItemViewModel
import com.example.pokedek.viewmodel.Api.VModelFactory
import com.example.pokedek.databinding.FragmentListPokemonBinding


class ListPokemon : Fragment() {
    lateinit var bind : FragmentListPokemonBinding
    lateinit var itemViewModel : ItemViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentListPokemonBinding.inflate(layoutInflater)



        return bind.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}