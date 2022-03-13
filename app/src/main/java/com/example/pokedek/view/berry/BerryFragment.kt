package com.example.pokedek.view.berry

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
import com.example.pokedek.model.remote.ApiRepository
import com.example.pokedek.model.Room.Entity.Berry.Berrylist
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentBerryBinding
import com.example.pokedek.view.berry.Adapter.Berryrvadapter
import com.example.pokedek.viewmodel.Api.Apiviewmodel
import com.example.pokedek.viewmodel.Api.VModelFactory

class BerryFragment : Fragment() {

    private lateinit var binding : FragmentBerryBinding

    private lateinit var apiViewModel: Apiviewmodel
    private lateinit var adapter : Berryrvadapter

    private lateinit var layoutManager : LinearLayoutManager
    private var page : Int = 5
    private var limit : Int = 12


    private var dataList = ArrayList<Berrylist>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentBerryBinding.inflate(inflater, container, false)


        //api
        dataList = arrayListOf()
        val repo = ApiRepository()
        val vmodelfactory = VModelFactory(repo)
        apiViewModel = ViewModelProvider(this,vmodelfactory)[Apiviewmodel::class.java]


        layoutManager = LinearLayoutManager(requireContext())
        adapter = Berryrvadapter()
        val recview = binding.recvhiwberry
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(requireContext())


        getBerryList()

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

    private fun getBerryList(){
        apiViewModel.getberrylist(page, limit)
        apiViewModel.berrylistrespon.observe(viewLifecycleOwner) { responBerry ->
            if (responBerry.isSuccessful) {
                val berrname = responBerry.body()?.results
                for (i in berrname!!.indices) {
                    val nameberry = berrname[i].name
                    getBerrySum(nameberry)
                }
            } else {
                Log.d(extra_name, "berrylistnotresponding")
            }
        }
    }

    private fun getBerrySum(id : String){
        apiViewModel.getberrysum(id)
        apiViewModel.berrysumrespon.observe(viewLifecycleOwner, Observer { berrysum ->
            if (berrysum.isSuccessful){
                val nama = berrysum.body()?.item?.name.toString()
                getberrysummore(nama)
            }else{
                Log.d(extra_name,"fail to fetch")
            }
        })
    }

    fun getberrysummore(id: String){
        apiViewModel.getitemsum(id)
        apiViewModel.itemsumrespon.observe(viewLifecycleOwner, Observer { berrysum ->
            var name = berrysum.body()?.name.toString()
            var link = berrysum.body()?.sprites?.default.toString()

            var databer = Berrylist(
                name,
                link
            )

            dataList.add(databer)
            val filter = dataList
            adapter.setdata(dataList)
        })
    }

    companion object{
        const val extra_name = "BerryFragment"
    }

}