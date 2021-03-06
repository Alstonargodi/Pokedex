package com.example.pokedek.view.fragment.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.pokedek.databinding.FragmentHomeBinding
import com.example.pokedek.model.remote.utils.Fetchstatus
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse
import com.example.pokedek.view.SectionPageAdapter
import com.example.pokedek.viewmodel.local.LocalViewModel
import com.example.pokedek.viewmodel.utils.VModelFactory
import com.example.pokedek.view.fragment.pokemon.adapter.PokeHomeRvAdapter
import com.example.pokedek.viewmodel.remote.PokemonViewModel
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val apiViewModel : PokemonViewModel by viewModels{ VModelFactory.getInstance() }
    private lateinit var pagerAdapter : SectionPageAdapter
    private lateinit var roomViewModel: LocalViewModel
    private lateinit var adapter : PokeHomeRvAdapter

    private var page = 0
    private var isLoading = false

    private var listsum = ArrayList<PokemonSummaryResponse>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        roomViewModel = ViewModelProvider(this)[LocalViewModel::class.java]

        lifecycleScope.launch {
            getPokemonList()
        }

        setPagerAdapter(0)
        binding.PokemonCard.setOnClickListener {
            setPagerAdapter(0)
        }

        binding.BerryCard.setOnClickListener {
            setPagerAdapter(1)
        }

        return binding.root
    }


    private suspend fun getPokemonList(){
        isLoading = true

    }


//    private fun showPokemonList(data : List<PokemonSummaryResponse>){
//        adapter = PokeHomeRvAdapter(data)
//        val recview = binding.recpokehom
//        recview.adapter = adapter
//        recview.layoutManager = LinearLayoutManager(context)
//
//    }
//

//
//    private fun setEmptyView(){
//        binding.recpokehom.apply {
//            setPadding(10, 20, 10, 20)
//            setBackgroundResource(R.drawable.emptyview)
//        }
//        binding.pbarPokehome.visibility = View.INVISIBLE
//        Log.d(EXTRA_NAME, "cannot retrive sum data")
//    }

    private fun setPagerAdapter(number : Int){
        pagerAdapter = SectionPageAdapter(requireActivity())
        val viewpager = binding.recpokehom
        viewpager.adapter = pagerAdapter
        viewpager.currentItem = number
    }


    companion object{
        const val PAGE = 0
        const val LIMIT = 10
    }

}