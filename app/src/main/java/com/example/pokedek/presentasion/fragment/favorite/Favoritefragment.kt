package com.example.pokedek.presentasion.fragment.favorite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.R
import com.example.pokedek.presentasion.fragment.favorite.Adapter.Favoritervadapter
import com.example.pokedek.presentasion.viewmodel.local.LocalViewModel
import com.example.pokedek.databinding.FragmentFavoritefragmentBinding

class Favoritefragment : Fragment() {
    private var _binding: FragmentFavoritefragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var localViewModel: LocalViewModel
    lateinit var adapter : Favoritervadapter
    private var type = ""


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritefragmentBinding.inflate(layoutInflater)
        localViewModel = ViewModelProvider(this)[LocalViewModel::class.java]
        //adapter
        adapter = Favoritervadapter()
        val recyclerView = binding.Favoriterecylerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.btnTogglesort.setOnClickListener {
            binding.Wishlistspinner.visibility =
                if (binding.Wishlistspinner.visibility == View.GONE)
                    View.VISIBLE
                else
                    View.GONE
        }


        type = "pokemon"
        favoriteListView("pokemon")

        binding.Wishlistspinner.onItemSelectedListener = object : AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {}
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when(p0?.getItemAtPosition(p2)){
                    "New Items"->{
                        favoriteListView(type)
                    }
                    "Old Items"->{
                        favoriteListOld(type)
                    }
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                favoriteListView("caterpie")
            }
        }

        //room
        favoriteListView("")

        return binding.root
    }

    fun favoriteListView(tipe : String){
        if(tipe.isNotEmpty()){
            localViewModel.readnew(tipe).observe(viewLifecycleOwner){ response ->
                try {
                    if (response != null) {
                        adapter.setdata(response)
                    } else {
                        binding.Favoriterecylerview.setBackgroundResource(R.drawable.emptyview)
                    }
                } catch (e: Exception) {
                    Log.d("favoritelist", e.toString())
                }
            }
        }else if (tipe.isEmpty()){
            localViewModel.readfavlistbynew.observe(viewLifecycleOwner, Observer { response ->
                try {
                    if (response != null) {
                        adapter.setdata(response)
                    } else {
                        binding.Favoriterecylerview.setBackgroundResource(R.drawable.emptyview)
                    }
                } catch (e: Exception) {
                    Log.d("favoritelist", e.toString())
                }
            })

        }
    }

    fun favoriteListOld(tipe: String){
        if (tipe.isNotEmpty()){
            localViewModel.readold(tipe).observe(viewLifecycleOwner) { response ->
                try {
                    if (response != null) {
                        adapter.setdata(response)
                    } else {
                        binding.Favoriterecylerview.setBackgroundResource(R.drawable.emptyview)
                    }
                } catch (e: Exception) {
                    Log.d("favoritelist", e.toString())
                }
            }
        }else if (tipe.isEmpty()){
            localViewModel.readfavlistbyold.observe(viewLifecycleOwner, Observer { response ->
                try {
                    if (response != null) {
                        adapter.setdata(response)
                    } else {
                        binding.Favoriterecylerview.setBackgroundResource(R.drawable.emptyview)
                    }
                } catch (e: Exception) {
                    Log.d("favoritelist", e.toString())
                }
            })

        }
    }
}