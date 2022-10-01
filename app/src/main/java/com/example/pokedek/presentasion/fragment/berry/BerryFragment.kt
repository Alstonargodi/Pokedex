package com.example.pokedek.presentasion.fragment.berry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.model.local.entity.Berry.Berrylist
import com.example.pokedek.databinding.FragmentBerryBinding
import com.example.pokedek.presentasion.fragment.berry.adapter.BerryRecviewAdapter
import com.example.pokedek.presentasion.viewmodel.remote.BerryViewModel
import com.example.pokedek.presentasion.viewmodel.remote.ItemViewModel

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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

//    private fun getBerryList(){
//        berryViewModel.getListBerry(page, limit)
//        berryViewModel.berryListRespon.observe(viewLifecycleOwner) { responBerry ->
//            if (responBerry.isSuccessful) {
//                val berrname = responBerry.body()?.berryListResults
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
//        berryViewModel.berrySummaryRespon.observe(viewLifecycleOwner) { berrysum ->
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