package com.example.pokedek.presentasion.fragment.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentHomeBinding
import com.example.pokedek.presentasion.SectionPageAdapter
import com.example.pokedek.presentasion.viewmodel.local.LocalViewModel
import com.example.pokedek.presentasion.viewmodel.utils.ViewModelFactory
import com.example.pokedek.presentasion.viewmodel.remote.PokemonViewModel
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val apiViewModel : PokemonViewModel by viewModels{ ViewModelFactory.getInstance() }
    private lateinit var pagerAdapter : SectionPageAdapter
    private lateinit var roomViewModel: LocalViewModel

    private var isLoading = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        roomViewModel = ViewModelProvider(this)[LocalViewModel::class.java]

        setPagerAdapter()

        return binding.root
    }

    private fun setPagerAdapter(){
        pagerAdapter = SectionPageAdapter(requireActivity())
        val viewpager = binding.recpokehom
        viewpager.adapter = pagerAdapter
    }


}