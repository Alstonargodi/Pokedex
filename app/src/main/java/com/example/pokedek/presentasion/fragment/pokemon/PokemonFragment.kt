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
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentPokemonBinding
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse
import com.example.pokedek.presentasion.fragment.home.HomeFragmentDirections
import com.example.pokedek.presentasion.fragment.pokemon.adapter.PokemonHomeAdapter
import com.example.pokedek.presentasion.fragment.pokemon.viewmodel.PokemonHomeViewModel
import com.example.pokedek.presentasion.viewmodel.utils.ViewModelFactory
import kotlinx.coroutines.launch

class PokemonFragment : Fragment() {
    private lateinit var binding: FragmentPokemonBinding

    private val apiViewModel : PokemonHomeViewModel by viewModels{
        ViewModelFactory.getInstance()
    }

    private var dataList = ArrayList<PokemonSummaryResponse>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().window.statusBarColor = ContextCompat.getColor(
            requireContext(), R.color.detailtop)
        requireActivity().window.navigationBarColor = ContextCompat.getColor(
            requireContext(), R.color.detailbot)
        binding = FragmentPokemonBinding.inflate(inflater, container, false)

        dataList = arrayListOf()

        getPokemonList()

        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            tvsort.setOnClickListener {
                binding.layhide.visibility =
                    if (binding.layhide.visibility == View.GONE)
                        View.VISIBLE
                    else
                        View.GONE
            }

            Pokespin.onItemSelectedListener = object : AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{
                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    when(p0?.getItemAtPosition(p2)){
                        "Name"->{
                            showPokemonList(dataList.sortedBy { it.name })
                        }
                        "Weight"->{
                            showPokemonList(dataList.sortedBy { it.weight })
                        }
                        "Height"->{
                            showPokemonList(dataList.sortedBy { it.height })
                        }
                        "Hp"->{
                            showPokemonList(dataList.sortedBy { it.stats[0].baseStat })
                        }
                        "Speed"->{
                            showPokemonList(dataList.sortedBy { it.stats[5].baseStat })
                        }
                        "Attack"->{
                            showPokemonList(dataList.sortedBy { it.stats[1].baseStat })
                        }
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    showPokemonList(dataList.sortedBy { it.name })
                }
            }
        }
    }

    private fun getPokemonList(){
        lifecycleScope.launch {
            apiViewModel.getPagedListPokemon().observe(viewLifecycleOwner){
                val adapter = PokemonHomeAdapter()
                binding.recyclerviewpoke.adapter = adapter
                binding.recyclerviewpoke.layoutManager = GridLayoutManager(requireContext(),2)
                adapter.submitData(lifecycle,it)

                adapter.onClickDetail(object : PokemonHomeAdapter.OnItemClickDetail{
                    override fun onItemClickDetail(data: String) {
                        findNavController().navigate(
                            HomeFragmentDirections.actionFragmenthomeToPokemondetailfragment(data)
                        )
                    }
                })
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