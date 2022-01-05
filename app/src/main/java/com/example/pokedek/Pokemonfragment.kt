package com.example.pokedek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Model.Room.Entity.Pokemonlist
import com.example.pokedek.Viewmodel.Apiviewmodel
import com.example.pokedek.Viewmodel.Vmodelfactory


class Pokemonfragment : Fragment() {
    lateinit var localviewmodel : Apiviewmodel
    var arrayList = ArrayList<Pokemonlist>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_pokemon, container, false)

        arrayList = arrayListOf()
        val repo = Apirepo()
        val vmfactory = Vmodelfactory(repo)
        localviewmodel = ViewModelProvider(this,vmfactory).get(Apiviewmodel::class.java)
        localviewmodel.listapirespon.observe(viewLifecycleOwner, Observer { pokeres ->
            if (pokeres.isSuccessful){
                val datarespon = pokeres.body()?.results
                for (i in datarespon!!.indices){
                    val pokenama = datarespon[i].name

                }
            }

        })


        return  view
    }


}