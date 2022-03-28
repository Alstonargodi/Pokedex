package com.example.pokedek.view.item

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.model.Room.Entity.Item.ItemList
import com.example.pokedek.R
import com.example.pokedek.view.item.adapter.Itemrvadapter
import com.example.pokedek.viewmodel.Api.ItemViewModel
import com.example.pokedek.databinding.FragmentItemBinding
import java.lang.Exception


class ItemFragment : Fragment() {

    private val  itemViewModel by viewModels<ItemViewModel>()


    lateinit var binding : FragmentItemBinding
    lateinit var adapter : Itemrvadapter


    private var Itemlistsum = ArrayList<ItemList>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemBinding.inflate(layoutInflater)
        val view = binding.root


        Itemlistsum = arrayListOf()
        adapter = Itemrvadapter()
        val recview = binding.Recviewitem
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(requireContext())


        binding.btnItemsort.setOnClickListener {
            binding.Sortlayout.visibility =
                if (binding.Sortlayout.visibility == View.GONE)
                    View.VISIBLE
                else
                    View.GONE
        }

        binding.Itemspinner.onItemSelectedListener = object : AdapterView.OnItemClickListener , AdapterView.OnItemSelectedListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                 val position = p0?.getItemAtPosition(p2)
                 when(position){
                     "all"->{
                         Itemlistsum.clear()
                         readitem("",10)
                     }
                     "Berries"->{
                         Itemlistsum.clear()
                         readitem("medicine",10000)
                     }
                     "Pokeballs"->{
                         Itemlistsum.clear()
                         readitem("balls",10000)
                     }
                 }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                readitem("",10)
            }

        }

        readitem("",10)


        return view
    }

    fun readitem(cari: String,item : Int){
        binding.itemprogressbar.visibility = View.VISIBLE

//        itemViewModel.getListItem(0,item)
//        itemViewModel.itemListRespon.observe(viewLifecycleOwner, Observer { responlist ->
//            try {
//                if (responlist.isSuccessful){
//                    val data = responlist.body()?.results
//                    for (i in data!!.indices){
//                        val nama = data[i].name
//
//                        itemViewModel.getSummaryItem(nama)
//                        itemViewModel.itemSumRespon.observe(viewLifecycleOwner, Observer { responsum ->
//                            try {
//                                if (responsum.isSuccessful){
//
//                                    val name = responsum.body()?.name.toString()
//                                    val type = responsum.body()?.category?.name.toString()
//
//                                    val fetch = ItemList(
//                                        responsum.body()?.name.toString(),
//                                        responsum.body()?.sprites?.default.toString(),
//                                        responsum.body()?.category?.name.toString(),
//                                        responsum.body()?.effectEntries?.get(0)?.effect.toString()
//                                    )
//
//                                    if(type.contains(cari)){
//                                        Itemlistsum.add(fetch)
//                                        adapter.setdata(Itemlistsum)
//                                        binding.itemprogressbar.visibility = View.GONE
//                                    }else if (cari.isEmpty()){
//                                        Itemlistsum.add(fetch)
//                                        adapter.setdata(Itemlistsum)
//                                        binding.itemprogressbar.visibility = View.GONE
//                                    }
//
//                                }else{
//                                    Log.d("itemsum","cannot fetch data")
//                                }
//                            }catch (e : Exception){
//                                Log.d("itemsum",e.toString())
//                            }
//                        })
//                    }
//                }else{
//                    Log.d("itemlist","cannot fetch data")
//                }
//            }catch (e : Exception){
//                Log.d("itemlist",e.toString())
//            }
//        })
    }


}