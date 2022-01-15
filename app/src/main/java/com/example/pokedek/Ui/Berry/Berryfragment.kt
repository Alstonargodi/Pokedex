package com.example.pokedek.Ui.Berry

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
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedek.Model.Api.Berry.Berysum.Berrysum
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Model.Room.Entity.Berry.Berrylist
import com.example.pokedek.R
import com.example.pokedek.Viewmodel.Apiviewmodel
import com.example.pokedek.Viewmodel.Vmodelfactory
import com.example.pokedek.databinding.FragmentBerryfragmentBinding
import kotlinx.android.synthetic.main.fragment_berryfragment.view.*

class Berryfragment : Fragment() {
    private var _binding: FragmentBerryfragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var apiviewmodel: Apiviewmodel
    lateinit var adapter : Berryrvadapter

    lateinit var layoutManager : LinearLayoutManager
    private var page : Int = 5
    private var limit : Int = 12
    private var isloading = false
    private var datalist = ArrayList<Berrylist>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentBerryfragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        //api
        datalist = arrayListOf()
        val repo = Apirepo()
        val vmodelfactory = Vmodelfactory(repo)
        apiviewmodel = ViewModelProvider(this,vmodelfactory).get(Apiviewmodel::class.java)

        //adapter
        layoutManager = LinearLayoutManager(requireContext())
        adapter = Berryrvadapter()
        val recview = binding.recvhiwberry
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(requireContext())

        //todo pagination berry list
        recview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visiblecount = layoutManager.childCount
                val pastvisible = layoutManager.findFirstCompletelyVisibleItemPosition()
                val itemtotal = adapter.itemCount

                page++
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        binding.btnhomBackErrymain.setOnClickListener {
            findNavController().navigate(BerryfragmentDirections.actionBerryfragmentToFragmenthome())
        }

        getberrylist()

        return view
    }

    fun getberrylist(){
        Log.d("berrylist","berrylist")
        apiviewmodel.getberrylist(0,page)
        apiviewmodel.berrylistrespon.observe(viewLifecycleOwner, Observer { berrylist->
            if (berrylist.isSuccessful){
                val berrname = berrylist.body()?.results
                for (i in berrname!!.indices){
                    val nameberry = berrname[i].name.toString()
                    getberrysum(nameberry)
                }
            }else{
                Log.d("berrylist","berrylistnotresponding")
            }
        })
    }

    fun getberrysum(id : String){
        apiviewmodel.getberrysum(id)
        apiviewmodel.berrysumrespon.observe(viewLifecycleOwner, Observer { berrysum ->
            if (berrysum.isSuccessful){
                val nama = berrysum.body()?.item?.name.toString()
                getberrysummore(nama)
            }else{
                Log.d("getberrysum","fail to fetch")
            }
        })
    }

    fun getberrysummore(id: String){
        apiviewmodel.getitemsum(id)
        apiviewmodel.itemsumrespon.observe(viewLifecycleOwner, Observer { berrysum ->
            var name = berrysum.body()?.name.toString()
            var link = berrysum.body()?.sprites?.default.toString()

            var databer = Berrylist(
                name,
                link
            )

            datalist.add(databer)
            val filter = datalist
            adapter.setdata(datalist)
        })
    }

}