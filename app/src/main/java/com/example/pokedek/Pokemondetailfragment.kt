package com.example.pokedek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Viewmodel.Apiviewmodel
import com.example.pokedek.Viewmodel.Vmodelfactory
import kotlinx.android.synthetic.main.fragment_pokemondetailfragment.view.*


class Pokemondetailfragment : Fragment() {
    lateinit var apiviewmodel: Apiviewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pokemondetailfragment, container, false)

        val repo = Apirepo()
        val vmodel = Vmodelfactory(repo)
        apiviewmodel = ViewModelProvider(this,vmodel).get(Apiviewmodel::class.java)

        val name = PokemondetailfragmentArgs.fromBundle(requireArguments()).pokemonname
        val link = PokemondetailfragmentArgs.fromBundle(requireArguments()).link
        view.tvdetail_pokem_name.setText(name)

        Glide.with(requireContext())
            .asBitmap()
            .load(link)
            .into(view.imgdetail_pokem)

        apiviewmodel.getdata(name)
        apiviewmodel.sumapirespon.observe(viewLifecycleOwner, Observer { respon ->
            if (respon.isSuccessful){
                val types = respon.body()?.types?.get(0)?.type?.name
                val weight = respon.body()?.weight.toString()
                val height = respon.body()?.height.toString()

                view.tvdetail_pokem_types.setText(types)
                view.tvdetail_pokem_weight.setText(weight!!)

            }

        })

        return view
    }

}