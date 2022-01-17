package com.example.pokedek.Ui.Search

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Model.Room.Entity.Search.Searchlist
import com.example.pokedek.R
import com.example.pokedek.Viewmodel.Apiviewmodel
import com.example.pokedek.Viewmodel.Vmodelfactory
import com.example.pokedek.databinding.FragmentSearchfragmentBinding
import kotlinx.android.synthetic.main.fragment_searchfragment.view.*
import java.util.*
import kotlin.collections.ArrayList

class Searchfragment : Fragment() {
    private var _binding: FragmentSearchfragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var apiviewmodel: Apiviewmodel
    lateinit var adapter : Searchrvadapter

    private var isrefresh = false
    private var choice = ""

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




        binding.etsearchFragment.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    adapter.filter.filter(newText)
                    return false
                }
        })

        pokemonlist()

        binding.btnKatPoke.setOnClickListener {
            datalist.clear()
            pokemonlist()
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
        //adapter
        val recview = binding.recviewSearch
        recview.layoutManager = LinearLayoutManager(requireContext())
//        binding.pbarSearchpoke.visibility = View.VISIBLE
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
                        datalist.add(nama)
//                        binding.pbarSearchpoke.visibility = View.INVISIBLE
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
//        binding.pbarSearchpoke.visibility = View.VISIBLE
        apiviewmodel.getberrylist(0,10)
        apiviewmodel.berrylistrespon.observe(viewLifecycleOwner, Observer { blistsearch ->
            try {
                if (blistsearch.isSuccessful){
                    val data = blistsearch.body()?.results
                    for (i in data!!.indices){
                        val name = data[i].name

                        val list = Searchlist(
                            name
                        )

                        datalist.add(name)
//                        binding.pbarSearchpoke.visibility = View.INVISIBLE
//                        adapter.setdata(datalist)
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


    //test
    private fun getListOfCountries() {


        val isoCountryCodes = Locale.getISOCountries()
        val countryListWithEmojis = ArrayList<String>()
        for (countryCode in isoCountryCodes) {
            val locale = Locale("", countryCode)
            val countryName = locale.displayCountry
            val flagOffset = 0x1F1E6
            val asciiOffset = 0x41
            val firstChar = Character.codePointAt(countryCode, 0) - asciiOffset + flagOffset
            val secondChar = Character.codePointAt(countryCode, 1) - asciiOffset + flagOffset
            val flag =
                (String(Character.toChars(firstChar)) + String(Character.toChars(secondChar)))
            countryListWithEmojis.add("$countryName $flag")
        }

    }
}