package com.example.pokedek.Ui

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
import com.example.pokedek.Ui.Pokemon.Adapter.Pokehomervadapter
import com.example.pokedek.Viewmodel.Api.Apiviewmodel
import com.example.pokedek.Viewmodel.Roomviewmodel
import com.example.pokedek.Viewmodel.Api.Vmodelfactory
import com.example.pokedek.databinding.FragmentFragmenthomeBinding
import kotlinx.android.synthetic.main.fragment_fragmenthome.view.*


class Homefragment : Fragment() {
    lateinit var apiviewmodel: Apiviewmodel
    lateinit var roomviewmodel: Roomviewmodel
    lateinit var adapter : Pokehomervadapter

    private var _binding: FragmentFragmenthomeBinding? = null
    private val binding get() = _binding!!

    private var isloading = false
    var listsum = ArrayList<Pokemonlist>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFragmenthomeBinding.inflate(inflater, container, false)
        val view = binding.root

        val repo = Apirepo()
        var Vmodelfac = Vmodelfactory(repo)
        apiviewmodel = ViewModelProvider(this,Vmodelfac).get(Apiviewmodel::class.java)
        roomviewmodel = ViewModelProvider(this).get(Roomviewmodel::class.java)

        listsum = arrayListOf()
        adapter = Pokehomervadapter()
        val recview = view.recpokehom
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(context)

        getpokemonlist()

        binding.btnPokelist.setOnClickListener {
            findNavController().navigate(HomefragmentDirections.actionFragmenthomeToPokemon())
        }

        binding.btnGofind.setOnClickListener {
            findNavController().navigate(HomefragmentDirections.actionFragmenthomeToSearchfragment())
        }

        binding.btnhomeBerry.setOnClickListener {
            findNavController().navigate(HomefragmentDirections.actionFragmenthomeToBerryfragment())
        }

        binding.btnGofav.setOnClickListener {
            findNavController().navigate(HomefragmentDirections.actionFragmenthomeToFavoritefragment())
        }

        return view
    }

    fun getpokemonlist(){
        isloading = true
        binding.pbarPokehome.visibility = View.VISIBLE

        apiviewmodel.getpokelist(0,5)
        apiviewmodel.pokelistrespon.observe(viewLifecycleOwner, Observer { listrespon->
            if(listrespon.isSuccessful){
                val data = listrespon.body()?.results
                for(i in 0 until data!!.size){
                    val nama = data[i].name
                    apiviewmodel.getpokesum(nama)
                    apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { sumrespon ->
                        if (sumrespon.isSuccessful){

                            val sum = Pokemonlist(
                                sumrespon.body()?.name.toString(),
                                sumrespon.body()?.sprites!!.other.officialArtwork.frontDefault,
                                sumrespon.body()?.height.toString(),
                                sumrespon.body()?.weight.toString(),
                                sumrespon.body()?.stats?.get(0)?.baseStat.toString(), //hp
                                sumrespon.body()?.stats?.get(1)?.baseStat.toString(), //atk
                                sumrespon.body()?.stats?.get(5)?.baseStat.toString(), //spd
                            )

                            listsum.add(sum)
                            adapter.setdata(listsum)
                            binding.pbarPokehome.visibility = View.INVISIBLE
                        }else{
                            binding.recpokehom.setPadding(10,20,10,20)
                            binding.recpokehom.setBackgroundResource(R.drawable.emptyview)
                            binding.pbarPokehome.visibility = View.INVISIBLE
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