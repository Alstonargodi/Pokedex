package com.example.pokedek.view.Item

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentItemdetailBinding


class Itemdetail : Fragment() {
    lateinit var binding : FragmentItemdetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemdetailBinding.inflate(layoutInflater)
        val view = binding.root

        val name = arguments?.get("nama")
        val effect = arguments?.get("effect")
        val link = arguments?.get("link")
        val type = arguments?.get("type")

        binding.tvTitleitem.setText(name.toString())
        binding.tvTypeitem.setText(type.toString())
        binding.tvEffectitem.setText(effect.toString())

        Glide.with(requireContext())
            .load(link)
            .into(binding.imgItemdetail)


        binding.btnItemhome.setOnClickListener {
            findNavController().navigate(ItemdetailDirections.actionItemdetailToItem())
        }

        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.detailtopitem)

        return view
    }

}