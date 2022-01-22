package com.example.pokedek.Ui.Favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokedek.Viewmodel.Roomviewmodel
import com.example.pokedek.databinding.FragmentFavoritefragmentBinding


class Favoritefragment : Fragment() {
    private var _binding: FragmentFavoritefragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var roomviewmodel: Roomviewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritefragmentBinding.inflate(inflater,container,false)



        return binding.root
    }

}