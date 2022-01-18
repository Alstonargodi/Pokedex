package com.example.pokedek.Ui.Pokemon

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Model.Room.Entity.Pokemon.Pokemonlist
import com.example.pokedek.R
import com.example.pokedek.Ui.Pokemon.Adapter.Pokemonrvadapter
import com.example.pokedek.Viewmodel.Api.Apiviewmodel
import com.example.pokedek.Viewmodel.Api.Vmodelfactory
import kotlinx.android.synthetic.main.fragment_pokemon.view.*


class Pokemonfragment : Fragment() {
    lateinit var apiviewmodel: Apiviewmodel

    private var isloading= false
    private var adapter = Pokemonrvadapter()
    var arrayList = ArrayList<Pokemonlist>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_pokemon, container, false)

        //recyclerview
        arrayList = arrayListOf()
        val recview= view.recyclerviewpoke
        adapter = Pokemonrvadapter()
        recview.adapter = adapter
        recview.layoutManager= LinearLayoutManager(context)
        recview.animate().start()


        //api
        val repo = Apirepo()
        val vmfac = Vmodelfactory(repo)
        apiviewmodel = ViewModelProvider(this,vmfac).get(Apiviewmodel::class.java)


        view.btn_menu.setOnClickListener {
            findNavController().navigate(PokemonfragmentDirections.actionPokemonToFragmenthome())
        }

        getpokemonlist()

        return view
    }

    fun getpokemonlist(){
        isloading = true
        view?.progressbarpoke?.visibility = View.VISIBLE

        apiviewmodel.getpokelist(0,10)
        apiviewmodel.pokelistrespon.observe(viewLifecycleOwner, Observer { pokelist ->
            if(pokelist.isSuccessful){
                val data = pokelist.body()?.results
                for(i in 0 until data!!.size){
                    val nama = data[i].name
                    apiviewmodel.getpokesum(nama)
                    apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { sumrespon ->
                        if (sumrespon.isSuccessful){

                            val sum = Pokemonlist(
                                sumrespon.body()?.name.toString(),
                                sumrespon.body()?.sprites!!.other.officialArtwork.frontDefault,
                                sumrespon.body()?.height.toString(),
                                sumrespon.body()?.weight.toString()
                            )

                            arrayList.add(sum)
                            adapter.setdata(arrayList)
                            view?.progressbarpoke?.visibility = View.INVISIBLE

                        }else{
                            view?.recyclerviewpoke?.setPadding(10,20,10,20)
                            view?.recyclerviewpoke?.setBackgroundResource(R.drawable.emptyview)
                            view?.progressbarpoke?.visibility = View.INVISIBLE
                            Log.d("homepoke","cannot retrive sum data")
                        }
                    })
                }
            }else{
                Log.d("homepoke","cannot retrive list data")
            }
        })
    }


}