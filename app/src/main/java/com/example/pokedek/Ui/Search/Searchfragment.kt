package com.example.pokedek.Ui.Search

import android.annotation.SuppressLint
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
import com.example.pokedek.Model.Room.Entity.Search.Searchlist
import com.example.pokedek.R
import com.example.pokedek.Viewmodel.Apiviewmodel
import com.example.pokedek.Viewmodel.Vmodelfactory
import com.example.pokedek.databinding.FragmentBerryfragmentBinding
import com.example.pokedek.databinding.FragmentSearchfragmentBinding
import kotlinx.android.synthetic.main.fragment_searchfragment.view.*

class Searchfragment : Fragment() {
    private var _binding: FragmentSearchfragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var apiviewmodel: Apiviewmodel
    lateinit var adapter : Searchrvadapter

    private var isrefresh = false
    private var choice = ""

    private var datalist = ArrayList<Searchlist>()
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentSearchfragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        //api
        val repo = Apirepo()
        val vmf = Vmodelfactory(repo)
        apiviewmodel = ViewModelProvider(this,vmf).get(Apiviewmodel::class.java)

        //adapter
        adapter = Searchrvadapter()
        val recview = binding.recviewSearch
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(requireContext())

        pokemonlist()

        view.btn_kat_poke.setOnClickListener {
            val name = view.etsearch_fragment.text.toString()
            if (name.isNotEmpty()){
                pokemonsearch(name)
            }
            view.btn_kat_poke.setTextColor(R.color.pokemon)
            view.btn_kat_nature.setTextColor(R.color.plain)
            view.btn_kat_berry.setTextColor(R.color.plain)
            view.btn_kat_item.setTextColor(R.color.plain)
        }

        view.btn_kat_nature.setOnClickListener {
            view.btn_kat_nature.setTextColor(R.color.nature)
            view.btn_kat_poke.setTextColor(R.color.plain)
            view.btn_kat_berry.setTextColor(R.color.plain)
            view.btn_kat_item.setTextColor(R.color.plain)
        }

        view.btn_kat_berry.setOnClickListener {
            val name = view.etsearch_fragment.text.toString()
            berrysearch(name)
            view.btn_kat_berry.setTextColor(R.color.berry)
            view.btn_kat_poke.setTextColor(R.color.plain)
            view.btn_kat_nature.setTextColor(R.color.plain)
            view.btn_kat_item.setTextColor(R.color.plain)
        }

        view.btn_kat_item.setOnClickListener {
            view.btn_kat_item.setTextColor(R.color.item)
            view.btn_kat_nature.setTextColor(R.color.plain)
            view.btn_kat_berry.setTextColor(R.color.plain)
            view.btn_kat_item.setTextColor(R.color.plain)
        }


        return view
    }


    //pokemon
    fun pokemonsearch(id : String){
        apiviewmodel.getpokesum(id)
        apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { psumsearch ->
            if (psumsearch.isSuccessful){
                val name = psumsearch.body()?.name
                val link = psumsearch.body()?.sprites!!.other.officialArtwork.frontDefault

                findNavController().navigate(SearchfragmentDirections.actionSearchfragmentToPokemondetailfragment(name.toString(),link.toString()))
            }else{
                Log.d("sumsearchrespom","not success")
            }
        })
    }
    fun pokemonlist(){
        apiviewmodel.getpokelist(0,30)
        apiviewmodel.pokelistrespon.observe(viewLifecycleOwner, Observer {  plistsearch ->
            try {
                if (plistsearch.isSuccessful){
                    val data = plistsearch.body()?.results
                    for (i in data!!.indices){
                        val nama = data[i].name

                        val list= Searchlist(
                            nama
                        )
                        datalist.add(list)
                        binding.pbarSearchpoke.visibility = View.INVISIBLE
                        adapter.setdata(datalist)
                    }
                }
            }catch (e : Exception){
                Log.d("list",e.toString())
            }
        })
    }

    fun berrysearch(id: String){
        apiviewmodel.getberrysum(id)
        apiviewmodel.berrysumrespon.observe(viewLifecycleOwner, Observer { bsumserach ->
            if (bsumserach.isSuccessful){
                Log.d("berry",bsumserach.body()?.name.toString())
            }else{
                Log.d("sumsearchrespom","not success")
            }
        })
    }

    fun itemsearch(id : String){
        apiviewmodel.getitemsum(id)
        apiviewmodel.itemsumrespon.observe(viewLifecycleOwner, Observer { itsumsearch ->


        })
    }

}