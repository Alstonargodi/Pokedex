package com.example.pokedek.Ui.Favorite

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.Model.Room.Entity.Favorite.Favoritelist
import com.example.pokedek.R
import com.example.pokedek.Ui.Favorite.Adapter.Favoritervadapter
import com.example.pokedek.Viewmodel.Roomviewmodel
import com.example.pokedek.databinding.FragmentFavoritefragmentBinding


class Favoritefragment : Fragment() {
    private var _binding: FragmentFavoritefragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var roomviewmodel: Roomviewmodel
    lateinit var adapter : Favoritervadapter

    override fun onStart() {
        favoritelist()
        super.onStart()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritefragmentBinding.inflate(inflater,container,false)

        //adapter
        adapter = Favoritervadapter()
        val recview = binding.Favoriterecylerview
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(requireContext())

        //room
        roomviewmodel = ViewModelProvider(this).get(Roomviewmodel::class.java)
        favoritelist()

        return binding.root
    }

    fun favoritelist(){
        roomviewmodel.readfavlistbynew.observe(viewLifecycleOwner, Observer { favrespon ->
            try {
                if (favrespon.isNotEmpty()){
                    adapter.setdata(favrespon)
                }else if (favrespon.isEmpty()){
                    binding.Favoriterecylerview.setBackgroundResource(R.drawable.emptyview)
                }
            }catch (e : Exception){
                Log.d("favoritelist",e.toString())
            }
        })
    }
}