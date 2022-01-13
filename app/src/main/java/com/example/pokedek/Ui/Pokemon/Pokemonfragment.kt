package com.example.pokedek.Ui.Pokemon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.Model.Room.Entity.Pokemon.Pokemonlist
import com.example.pokedek.R
import com.example.pokedek.Ui.Pokemon.Adapter.Pokemonrvadapter
import com.example.pokedek.Viewmodel.Roomviewmodel
import kotlinx.android.synthetic.main.fragment_pokemon.view.*


class Pokemonfragment : Fragment() {
    lateinit var roomviewmodel: Roomviewmodel
    var arrayList = ArrayList<Pokemonlist>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_pokemon, container, false)

        //recyclerview
        val recview= view.recyclerviewpoke
        val adapter = Pokemonrvadapter()
        recview.adapter = adapter
        recview.layoutManager= LinearLayoutManager(context)


        recview.animate().start()


        //room
        roomviewmodel = ViewModelProvider(this).get(Roomviewmodel::class.java)
        roomviewmodel.readpokelist.observe(viewLifecycleOwner, Observer { responpoke->
            adapter.setdata(responpoke)
        })


        view.btn_menu.setOnClickListener {
            findNavController().navigate(PokemonfragmentDirections.actionPokemonToFragmenthome())
        }

        return view
    }


}