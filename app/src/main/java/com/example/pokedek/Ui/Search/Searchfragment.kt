package com.example.pokedek.Ui.Search

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Model.Room.Entity.Search.Searchlist
import com.example.pokedek.R
import com.example.pokedek.Ui.Search.Adapter.Searchrvadapter
import com.example.pokedek.Viewmodel.Api.Apiviewmodel
import com.example.pokedek.Viewmodel.Api.Vmodelfactory
import com.example.pokedek.databinding.FragmentSearchfragmentBinding
import kotlinx.android.synthetic.main.fragment_searchfragment.view.*
import kotlin.collections.ArrayList

class Searchfragment : Fragment() {
    private var _binding: FragmentSearchfragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var apiviewmodel: Apiviewmodel
    lateinit var adapter : Searchrvadapter

    private var datalist = ArrayList<String>()
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


        //searchview
        binding.etsearchFragment.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    adapter.filter.filter(newText)
                    return false
                }
        })

        val textviewsrc = binding.etsearchFragment.findViewById<TextView>(R.id.search_src_text)
        textviewsrc.setTextColor(Color.WHITE)




        listall()

        binding.btnKatPoke.setOnClickListener {
            datalist.clear()
            pokemonlist()
            view.btn_kat_poke.setTextColor(R.color.pokemon)
            view.btn_kat_nature.setTextColor(R.color.plain)
            view.btn_kat_berry.setTextColor(R.color.plain)
            view.btn_kat_item.setTextColor(R.color.plain)
        }

        binding.btnKatNature.setOnClickListener {
            view.btn_kat_nature.setTextColor(R.color.nature)
            view.btn_kat_poke.setTextColor(R.color.plain)
            view.btn_kat_berry.setTextColor(R.color.plain)
            view.btn_kat_item.setTextColor(R.color.plain)
        }

        binding.btnKatBerry.setOnClickListener {
            val name = binding.etsearchFragment.toString()
            if (name.isNotEmpty()){
                berrysearch(name)
            }
            datalist.clear()
            berrylist()
            view.btn_kat_berry.setTextColor(R.color.berry)
            view.btn_kat_poke.setTextColor(R.color.plain)
            view.btn_kat_nature.setTextColor(R.color.plain)
            view.btn_kat_item.setTextColor(R.color.plain)
        }

        binding.btnKatItem.setOnClickListener {
            view.btn_kat_item.setTextColor(R.color.item)
            view.btn_kat_nature.setTextColor(R.color.plain)
            view.btn_kat_berry.setTextColor(R.color.plain)
            view.btn_kat_item.setTextColor(R.color.plain)
        }

        return view
    }

    @SuppressLint("ResourceAsColor")
    fun listall(){
        binding.btnKatPoke.setTextColor(R.color.white)
        binding.btnKatBerry.setTextColor(R.color.white)
        binding.btnKatNature.setTextColor(R.color.white)
        binding.btnKatItem.setTextColor(R.color.white)
        binding.btnKatAll.setTextColor(R.color.black)

        pokemonlist()
        berrylist()
    }

    //pokemon
    fun pokemonsearch(id : String){
        apiviewmodel.getpokesum(id)
        apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { psumsearch ->
            if (psumsearch.isSuccessful){
                val name = psumsearch.body()?.name
                val link = psumsearch.body()?.sprites!!.other.officialArtwork.frontDefault

                findNavController().navigate(SearchfragmentDirections.actionSearchfragmentToPokemondetailfragment(name.toString()))
            }else{
                Log.d("sumsearchrespom","not success")
            }
        })
    }
    fun pokemonlist(){
        //adapter
        val recview = binding.recviewSearch
        recview.layoutManager = LinearLayoutManager(requireContext())
        binding.pbarSearchpoke.visibility = View.VISIBLE

        apiviewmodel.getpokelist(0,1000)
        apiviewmodel.pokelistrespon.observe(viewLifecycleOwner, Observer {  plistsearch ->
            try {
                if (plistsearch.isSuccessful){

                    val data = plistsearch.body()?.results
                    for (i in data!!.indices){
                        val nama = data[i].name + " pokemon"

                        val list= Searchlist(
                            nama
                        )
                        datalist.add(nama)
                        binding.pbarSearchpoke.visibility = View.INVISIBLE
                        adapter = Searchrvadapter(datalist)
                        recview.adapter = adapter
                    }
                }
            }catch (e : Exception){
                Log.d("list",e.toString())
            }
        })
    }

    //berry
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
    fun berrylist(){
        binding.pbarSearchpoke.visibility = View.VISIBLE
        val recview = binding.recviewSearch
        recview.layoutManager = LinearLayoutManager(requireContext())

        apiviewmodel.getberrylist(0,1000)
        apiviewmodel.berrylistrespon.observe(viewLifecycleOwner, Observer { blistsearch ->
            try {
                if (blistsearch.isSuccessful){
                    val data = blistsearch.body()?.results
                    for (i in data!!.indices){
                        val name = data[i].name + "-berry"

                        val list = Searchlist(
                            name
                        )

                        datalist.add(name)
                        binding.pbarSearchpoke.visibility = View.INVISIBLE
                        adapter = Searchrvadapter(datalist)
                        recview.adapter = adapter
                    }
                }
            }catch (e : Exception){
                Log.d("list",e.toString())
            }
        })
    }

    fun itemsearch(id : String){
        apiviewmodel.getitemsum(id)
        apiviewmodel.itemsumrespon.observe(viewLifecycleOwner, Observer { itsumsearch ->


        })
    }


}