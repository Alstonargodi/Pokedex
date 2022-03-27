package com.example.pokedek.view.berry

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.model.Room.Entity.Berry.Berrylist
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentBerryBinding
import com.example.pokedek.view.berry.adapter.BerryRecviewAdapter
import com.example.pokedek.viewmodel.Api.BerryViewModel
import com.example.pokedek.viewmodel.Api.ItemViewModel

class BerryFragment : Fragment() {

    private lateinit var binding : FragmentBerryBinding

    private val berryViewModel by viewModels<BerryViewModel>()
    private val itemViewModel by viewModels<ItemViewModel>()

    private lateinit var adapter : BerryRecviewAdapter

    private lateinit var layoutManager : LinearLayoutManager
    private var page : Int = 0
    private var limit : Int = 12


    private var dataList = ArrayList<Berrylist>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentBerryBinding.inflate(inflater, container, false)

        layoutManager = LinearLayoutManager(requireContext())
        adapter = BerryRecviewAdapter()
        val recview = binding.recvhiwberry
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(requireContext())


        itemViewModel.isLoading.observe(viewLifecycleOwner){
            isLoading(it)
        }
//        getBerryList()

        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.detailtopberry)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnhomBackErrymain.setOnClickListener {
//            findNavController().navigate(BerryFragmentDirections.actionBerryfragmentToFragmenthome())
            requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.detailtop)
        }

    }

//    private fun getBerryList(){
//        berryViewModel.getListBerry(page, limit)
//        berryViewModel.berryListRespon.observe(viewLifecycleOwner) { responBerry ->
//            if (responBerry.isSuccessful) {
//                val berrname = responBerry.body()?.results
//                for (i in berrname!!.indices) {
//                    val nameberry = berrname[i].name
//                    getBerrySum(nameberry)
//                }
//            } else {
//                Log.d(extra_name, "berrylistnotresponding")
//            }
//        }
//    }
//
//    private fun getBerrySum(id : String){
//        berryViewModel.getSumBerry(id)
//        berryViewModel.berrySumRespon.observe(viewLifecycleOwner) { berrysum ->
//            if (berrysum.isSuccessful) {
//                val nama = berrysum.body()?.item?.name.toString()
//                getSummaryItem(nama)
//            } else {
//                Log.d(extra_name, "fail to fetch")
//            }
//        }
//    }

//    fun getSummaryItem(name: String){
//        itemViewModel.getSummaryItem(name)
//        itemViewModel.itemSumRespon.observe(viewLifecycleOwner) { berrysum ->
//            val name = berrysum.body()?.name.toString()
//            val link = berrysum.body()?.sprites?.default.toString()
//
//            val dataTemp = Berrylist(
//                name,
//                link
//            )
//
//            dataList.add(dataTemp)
//            adapter.setdata(dataList)
//        }
//    }

    private fun isLoading(isLoading: Boolean){
        binding.Berryprogress.visibility = if (isLoading)  View.VISIBLE  else  View.GONE
    }

    companion object{
        const val extra_name = "BerryFragment"
    }

}