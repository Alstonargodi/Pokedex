package com.example.pokedek.presentasion.fragment.search

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.R
import com.example.pokedek.presentasion.fragment.search.Adapter.Searchrvadapter
import com.example.pokedek.databinding.FragmentSearchfragmentBinding
import com.example.pokedek.viewmodel.remote.BerryViewModel
import com.example.pokedek.viewmodel.remote.ItemViewModel
import com.example.pokedek.viewmodel.remote.PokemonViewModel
import kotlinx.android.synthetic.main.fragment_searchfragment.view.*
import kotlin.collections.ArrayList

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchfragmentBinding? = null
    private val binding get() = _binding!!

    private val pokeViewModel by viewModels<PokemonViewModel>()
    private val berryViewModel by viewModels<BerryViewModel>()
    private val itemViewModel by viewModels<ItemViewModel>()

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

//       val textviewsrc = binding.etsearchFragment.findViewById<TextView>(R.id.search_src_text)
//        textviewsrc.setTextColor(Color.WHITE)

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
//                berrysearch(name)
            }
            datalist.clear()
//            berrylist()
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
//        berrylist()
    }

    //pokemon
//    fun pokemonsearch(id : String){
//        pokeViewModel.getPokemonSummary(id)
//        pokeViewModel.pokesumrespon.observe(viewLifecycleOwner, Observer { psumsearch ->
//            if (psumsearch.isSuccessful){
//                val name = psumsearch.body()?.name
//                val link = psumsearch.body()?.sprites!!.other.officialArtwork.frontDefault
//
////                findNavController().navigate(SearchfragmentDirections.actionSearchfragmentToPokemondetailfragment(name.toString()))
//            }else{
//                Log.d("sumsearchrespom","not success")
//            }
//        })
//    }
    fun pokemonlist(){
        //adapter
        val recview = binding.recviewSearch
        recview.layoutManager = LinearLayoutManager(requireContext())
        binding.pbarSearchpoke.visibility = View.VISIBLE

//        pokeViewModel.getPokemonList(0,1000)
//        pokeViewModel.pokelistrespon.observe(viewLifecycleOwner, Observer {  plistsearch ->
//            try {
//                if (plistsearch.isSuccessful){
//
//                    val data = plistsearch.body()?.berryListResults
//                    for (i in data!!.indices){
//                        val nama = data[i].name + " pokemon"
//
//                        val list= Searchlist(
//                            nama
//                        )
//                        datalist.add(nama)
//                        binding.pbarSearchpoke.visibility = View.INVISIBLE
//                        adapter = Searchrvadapter(datalist)
//                        recview.adapter = adapter
//                    }
//                }
//            }catch (e : Exception){
//                Log.d("list",e.toString())
//            }
//        })
    }

    //berry
//    fun berrysearch(id: String){
//        berryViewModel.getSumBerry(id)
//        berryViewModel.berrySummaryRespon.observe(viewLifecycleOwner, Observer { bsumserach ->
//            if (bsumserach.isSuccessful){
//                Log.d("berry",bsumserach.body()?.name.toString())
//            }else{
//                Log.d("sumsearchrespom","not success")
//            }
//        })
//    }
//    fun berrylist(){
//        binding.pbarSearchpoke.visibility = View.VISIBLE
//        val recview = binding.recviewSearch
//        recview.layoutManager = LinearLayoutManager(requireContext())
//
//        berryViewModel.getListBerry(0,1000)
//        berryViewModel.berryListRespon.observe(viewLifecycleOwner, Observer { blistsearch ->
//            try {
//                if (blistsearch.isSuccessful){
//                    val data = blistsearch.body()?.berryListResults
//                    for (i in data!!.indices){
//                        val name = data[i].name + "-berry"
//
//                        val list = Searchlist(
//                            name
//                        )
//
//                        datalist.add(name)
//                        binding.pbarSearchpoke.visibility = View.INVISIBLE
//                        adapter = Searchrvadapter(datalist)
//                        recview.adapter = adapter
//                    }
//                }
//            }catch (e : Exception){
//                Log.d("list",e.toString())
//            }
//        })
//    }

//    fun itemsearch(id : String){
//        pokeViewModel.getitemsum(id)
//        pokeViewModel.itemsumrespon.observe(viewLifecycleOwner, Observer { itsumsearch ->
//
//
//        })
//    }


}