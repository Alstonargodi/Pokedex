package com.example.pokedek.presentasion.fragment.compare

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokedek.databinding.FragmentCompareBinding

class Compare : Fragment() {
    lateinit var bind : FragmentCompareBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentCompareBinding.inflate(layoutInflater)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        bind.btnlist.setOnClickListener {
//            findNavController().navigate(CompareDirections.actionCompareToListPokemon())
        }

    }
}