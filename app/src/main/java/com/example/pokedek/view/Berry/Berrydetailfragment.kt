package com.example.pokedek.view.Berry

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pokedek.modedl.Api.Repo.ApiRepo
import com.example.pokedek.modedl.Room.Entity.Berry.Flavourberrylist
import com.example.pokedek.R
import com.example.pokedek.view.Berry.Adapter.Berryflavourrvadapter
import com.example.pokedek.viewmodel.Api.Apiviewmodel
import com.example.pokedek.viewmodel.Api.VModelFactory
import com.example.pokedek.databinding.FragmentBerrydetailfragmentBinding
import java.lang.Exception


class Berrydetailfragment : Fragment() {
    private var _binding: FragmentBerrydetailfragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var apiviewmodel: Apiviewmodel
    lateinit var adapter : Berryflavourrvadapter
    private var berryflavlist = ArrayList<Flavourberrylist>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentBerrydetailfragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        //flavour
        berryflavlist = arrayListOf()
        adapter = Berryflavourrvadapter()
        val recview = binding.Berryrecview
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(context)
        //api
        val repo = ApiRepo()
        val vmf = VModelFactory(repo)
        apiviewmodel = ViewModelProvider(this,vmf).get(Apiviewmodel::class.java)

        val nama = BerrydetailfragmentArgs.fromBundle(requireArguments()).name
        binding.tvdetailBerryName.setText(nama)

        binding.btnhomBackBerry.setOnClickListener {
            findNavController().navigate(BerrydetailfragmentDirections.actionBerrydetailfragmentToBerryfragment())
        }

        getberrydetail()
        getberrysum()

        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.detailtopberry)

        return view
    }

    fun getberrydetail(){
        val nama = BerrydetailfragmentArgs.fromBundle(requireArguments()).name
        binding.tvdetailBerryName.setText(nama)

        apiviewmodel.getitemsum(nama)
        apiviewmodel.itemsumrespon.observe(viewLifecycleOwner, Observer { itemberry ->
            try {
                if (itemberry.isSuccessful){
                    val link = itemberry.body()?.sprites?.default.toString()
                    val effect = itemberry.body()?.effectEntries?.get(0)?.effect.toString()
                    val cost = itemberry.body()?.cost.toString()

                    binding.tvdetailBerryEffect.setText(effect)
                    binding.tvdetailBerryCost.setText(cost)

                    Glide.with(requireContext())
                        .asBitmap()
                        .load(link)
                        .into(binding.imgdetailBerry)
                }else{
                    Log.d("berrydetail","cannot get data itemberry")
                }
            }catch (e : Exception){
                Log.d("berrydetail","$e")
            }
        })
    }

    fun getberrysum(){
        val nama = BerrydetailfragmentArgs.fromBundle(requireArguments()).name
        val filter = nama.replace("-berry","").filter { !it.isWhitespace() }
        apiviewmodel.getberrysum(filter)
        apiviewmodel.berrysumrespon.observe(viewLifecycleOwner, Observer { berrysum->
            try {
                if (berrysum.isSuccessful){
                    val size = berrysum.body()?.size.toString()
                    val power = berrysum.body()?.naturalGiftPower.toString()
                    val flavour = berrysum.body()?.flavors

                    binding.tvdetailBerrySize.setText(size)
                    binding.tvdetailBerryPower.setText(power)

                    for (i in flavour!!.indices ){
                        val name = flavour[i].flavor.name
                        val poten = flavour[i].potency.toString()

                        val data = Flavourberrylist(
                            name,
                            poten
                        )

                        berryflavlist.add(data)
                        adapter.setdata(berryflavlist.sortedByDescending { it.potecny })

                    }
                }else{
                    Log.d("berrysum","fail fetch berry data")
                }
            }catch (e : Exception){
                Log.d("berrysum","$e")
            }
        })
    }

}