package com.example.pokedek.view.fragment.berry

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pokedek.model.local.entity.Berry.Flavourberrylist
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentBerrydetailBinding
import com.example.pokedek.view.fragment.berry.adapter.BerryFlavourRecviewAdapter
import com.example.pokedek.viewmodel.remote.BerryViewModel
import com.example.pokedek.viewmodel.remote.ItemViewModel
import java.lang.Exception


class BerryDetailFragment : Fragment() {
    private var _binding: FragmentBerrydetailBinding? = null
    private val binding get() = _binding!!

    private val berryViewModel by viewModels<BerryViewModel>()
    private val itemViewModel by viewModels<ItemViewModel>()

    lateinit var adapter : BerryFlavourRecviewAdapter
    private var berryflavlist = ArrayList<Flavourberrylist>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =  FragmentBerrydetailBinding.inflate(inflater, container, false)
        val view = binding.root

        //flavour
        berryflavlist = arrayListOf()
        adapter = BerryFlavourRecviewAdapter()
        val recview = binding.Berryrecview
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(context)



        val nama = BerryDetailFragmentArgs.fromBundle(requireArguments()).name
        binding.tvdetailBerryName.text = nama

        binding.btnhomBackBerry.setOnClickListener {
            findNavController().navigate(BerryDetailFragmentDirections.actionBerrydetailfragmentToBerryfragment())
        }

        getberrydetail()
//        getberrysum()

        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.detailtopberry)

        return view
    }

    fun getberrydetail(){
        val nama = BerryDetailFragmentArgs.fromBundle(requireArguments()).name
        binding.tvdetailBerryName.setText(nama)

//        itemViewModel.getSummaryItem(nama)
        itemViewModel.itemSumRespon.observe(viewLifecycleOwner) { itemberry ->
            try {
                if (itemberry.isSuccessful) {
                    val link = itemberry.body()?.sprites?.default.toString()
                    val effect = itemberry.body()?.effectEntries?.get(0)?.effect.toString()
                    val cost = itemberry.body()?.cost.toString()

                    binding.tvdetailBerryEffect.setText(effect)
                    binding.tvdetailBerryCost.setText(cost)

                    Glide.with(requireContext())
                        .asBitmap()
                        .load(link)
                        .into(binding.imgdetailBerry)
                } else {
                    Log.d("berrydetail", "cannot get data itemberry")
                }
            } catch (e: Exception) {
                Log.d("berrydetail", "$e")
            }
        }
    }

//    fun getberrysum(){
//        val nama = BerryDetailFragmentArgs.fromBundle(requireArguments()).name
//        val filter = nama.replace("-berry","").filter { !it.isWhitespace() }
//        berryViewModel.getSumBerry(filter)
//        berryViewModel.berrySummaryRespon.observe(viewLifecycleOwner) { berrysum ->
//            try {
//                if (berrysum.isSuccessful) {
//                    val size = berrysum.body()?.size.toString()
//                    val power = berrysum.body()?.naturalGiftPower.toString()
//                    val flavour = berrysum.body()?.flavors
//
//                    binding.tvdetailBerrySize.setText(size)
//                    binding.tvdetailBerryPower.setText(power)
//
//                    for (i in flavour!!.indices) {
//                        val name = flavour[i].flavor.name
//                        val poten = flavour[i].potency.toString()
//
//                        val data = Flavourberrylist(
//                            name,
//                            poten
//                        )
//
//                        berryflavlist.add(data)
//                        adapter.setdata(berryflavlist.sortedByDescending { it.potecny })
//
//                    }
//                } else {
//                    Log.d("berrysum", "fail fetch berry data")
//                }
//            } catch (e: Exception) {
//                Log.d("berrysum", "$e")
//            }
//        }
//    }

}