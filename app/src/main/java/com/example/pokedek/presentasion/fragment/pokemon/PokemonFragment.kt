package com.example.pokedek.presentasion.fragment.pokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentPokemonBinding
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse
import com.example.pokedek.presentasion.fragment.home.HomeFragmentDirections
import com.example.pokedek.presentasion.fragment.pokemon.adapter.LoadingListAdapter
import com.example.pokedek.presentasion.fragment.pokemon.adapter.PokemonHomeAdapter
import com.example.pokedek.presentasion.fragment.pokemon.viewmodel.PokemonHomeViewModel
import com.example.pokedek.presentasion.viewmodel.utils.ViewModelFactory
import kotlinx.coroutines.launch

class PokemonFragment : Fragment() {
    private lateinit var binding: FragmentPokemonBinding

    private val apiViewModel : PokemonHomeViewModel by viewModels{
        ViewModelFactory.getInstance(requireContext())
    }

    private var dataList = ArrayList<PokemonSummaryResponse>()
    private var pokemonRecyclerViewAdapter = PokemonHomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        requireActivity().window.navigationBarColor = ContextCompat.getColor(requireContext(), R.color.detailbot)
        binding = FragmentPokemonBinding.inflate(inflater, container, false)

        dataList = arrayListOf()

        getPokemonList()

        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun getPokemonList(){
        lifecycleScope.launch {
            apiViewModel.getPagedListPokemon().observe(viewLifecycleOwner){
                val adapter = pokemonRecyclerViewAdapter.withLoadStateFooter(
                    footer = LoadingListAdapter{
                        pokemonRecyclerViewAdapter.retry()
                    }
                )
                pokemonRecyclerViewAdapter.submitData(lifecycle,it)
                binding.recyclerviewpoke.adapter = adapter
                binding.recyclerviewpoke.layoutManager = GridLayoutManager(requireContext(),2)


                pokemonRecyclerViewAdapter.onClickDetail(object : PokemonHomeAdapter.OnItemClickDetail{
                    override fun onItemClickDetail(data: String) {
                        findNavController().navigate(
                            HomeFragmentDirections.actionFragmenthomeToPokemondetailfragment(data)
                        )
                    }
                })
            }
        }
    }

    private fun showPokemonItem(){
        lifecycleScope.launch {
            apiViewModel.getPokemonMediator().observe(viewLifecycleOwner){ response ->
                binding.recyclerviewpoke.adapter = pokemonRecyclerViewAdapter.withLoadStateFooter(
                    footer = LoadingListAdapter{
                        pokemonRecyclerViewAdapter.retry()
                    }
                )
                pokemonRecyclerViewAdapter.submitData(requireActivity().lifecycle,response)
            }
        }
    }


    private fun showPokemonList(data : List<PokemonSummaryResponse>){

    }
    private fun setEmptyView(){
        binding.recyclerviewpoke.apply {
            setPadding(LEFT, TOP, RIGHT, BOTTOM)
            setBackgroundResource(R.drawable.emptyview)
        }
        Log.d(EXTRA_NAME, "cannot retrive sum data")
    }

    companion object{
        const val PAGE = 0
        const val LIMIT = 5

        const val LEFT = 10
        const val TOP = 20
        const val RIGHT = 10
        const val BOTTOM = 20

        const val EXTRA_NAME = "PokemonFragment"
    }
}