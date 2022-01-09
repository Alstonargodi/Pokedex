package com.example.pokedek

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Viewmodel.Apiviewmodel
import com.example.pokedek.Viewmodel.Vmodelfactory
import kotlinx.android.synthetic.main.fragment_searchfragment.view.*

class Searchfragment : Fragment() {
    lateinit var apiviewmodel: Apiviewmodel

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_searchfragment, container, false)

        view.btn_kat_poke.setOnClickListener {
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

}