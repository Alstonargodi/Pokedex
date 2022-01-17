package com.example.pokedek

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Viewmodel.Apiviewmodel
import com.example.pokedek.Viewmodel.Vmodelfactory
import com.example.pokedek.databinding.FragmentBerrydetailfragmentBinding
import com.example.pokedek.databinding.FragmentBerryfragmentBinding


class Berrydetailfragment : Fragment() {
    private var _binding: FragmentBerrydetailfragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var apiviewmodel: Apiviewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentBerrydetailfragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        //api
        val repo = Apirepo()
        val vmf = Vmodelfactory(repo)
        apiviewmodel = ViewModelProvider(this,vmf).get(Apiviewmodel::class.java)

        val nama = BerrydetailfragmentArgs.fromBundle(requireArguments()).name
        val link = BerrydetailfragmentArgs.fromBundle(requireArguments()).link
        binding.tvdetailBerryName.setText(nama)
        Glide.with(requireContext())
            .asBitmap()
            .load(link)
            .into(binding.imgdetailBerry)

        binding.btnhomBackBerry.setOnClickListener {
            findNavController().navigate(BerrydetailfragmentDirections.actionBerrydetailfragmentToBerryfragment())
        }

        getberrydetail()

        return view
    }

    fun getberrydetail(){

        val nama = BerrydetailfragmentArgs.fromBundle(requireArguments()).name
        val link = BerrydetailfragmentArgs.fromBundle(requireArguments()).link
        binding.tvdetailBerryName.setText(nama)
        Glide.with(requireContext())
            .asBitmap()
            .load(link)
            .into(binding.imgdetailBerry)

        apiviewmodel.getitemsum(nama)
        apiviewmodel.itemsumrespon.observe(viewLifecycleOwner, Observer { itemberry ->
            if (itemberry.isSuccessful){
                val effect = itemberry.body()?.effectEntries?.get(0)?.effect.toString()
                val cost = itemberry.body()?.cost.toString()
                binding.tvdetailBerryEffect.setText(effect)
                binding.tvdetailBerryCost.setText(cost)
            }else{
                Log.d("itemberry","cannot get data itemberry")
            }
        })

    }

}