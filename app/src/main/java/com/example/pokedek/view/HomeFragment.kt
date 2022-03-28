package com.example.pokedek.view

import android.app.ActivityOptions
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentHomeBinding
import com.example.pokedek.model.remote.Fetchstatus
import com.example.pokedek.model.remote.pokemonreponse.Pokemonsum.Pokesummary
import com.example.pokedek.viewmodel.Roomviewmodel
import com.example.pokedek.viewmodel.Api.VModelFactory
import com.example.pokedek.view.pokemon.adapter.PokeHomeRvAdapter
import com.example.pokedek.viewmodel.Api.PokemonViewModel
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val apiViewModel : PokemonViewModel by viewModels{ VModelFactory.getInstance() }
    private lateinit var pagerAdapter : SectionPageAdapter
    private lateinit var roomViewModel: Roomviewmodel
    private lateinit var adapter : PokeHomeRvAdapter

    private var page = 0
    private var isLoading = false

    private var listsum = ArrayList<Pokesummary>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        roomViewModel = ViewModelProvider(this)[Roomviewmodel::class.java]

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


//        getDataCount()
        return binding.root
    }


    private suspend fun getPokemonList(){
        isLoading = true
        binding.pbarPokehome.visibility = View.VISIBLE

        apiViewModel.getListPokemon(PAGE, LIMIT).observe(viewLifecycleOwner){ status->
            when(status){
                is Fetchstatus.Loading->{
                    binding.pbarPokehome.visibility = View.VISIBLE
                }
                is Fetchstatus.Sucess->{
                    binding.pbarPokehome.visibility = View.GONE
                    listsum.add(status.data)
//                    showPokemonList(listsum.distinct())
                }
                is Fetchstatus.Error ->{
//                    setEmptyView()
                    Log.d("Home Fragment",status.error)
                }
                else -> {}
            }
        }
    }


//    private fun showPokemonList(data : List<Pokesummary>){
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