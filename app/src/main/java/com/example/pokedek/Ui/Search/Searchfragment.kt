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
import com.example.pokedek.R
import com.example.pokedek.Viewmodel.Apiviewmodel
import com.example.pokedek.Viewmodel.Vmodelfactory
import kotlinx.android.synthetic.main.fragment_searchfragment.view.*

class Searchfragment : Fragment() {
    lateinit var apiviewmodel: Apiviewmodel
    lateinit var adapter : Searchrvadapter

    private var isrefresh = false
    private var choice = ""
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_searchfragment, container, false)

        //adapter
        adapter = Searchrvadapter()
        val recview = view.recview_search
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(requireContext())

        if (adapter.itemCount === 0){
            recview.setBackgroundResource(R.drawable.emptyview)
        }

        val name = view.etsearch_fragment.text.toString()
        view.btn_kat_poke.setOnClickListener {
            pokemonsearch(name)
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

        val repo = Apirepo()
        val vmf = Vmodelfactory(repo)
        apiviewmodel = ViewModelProvider(this,vmf).get(Apiviewmodel::class.java)

        apiviewmodel.getberrylist()
        apiviewmodel.berrylistrespon.observe(viewLifecycleOwner, Observer { responberry->
            Log.d("berryrespon",responberry.body()?.results?.get(0)!!.name)
        })
        return view
    }


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

}