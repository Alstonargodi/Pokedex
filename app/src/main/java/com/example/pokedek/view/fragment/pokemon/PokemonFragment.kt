package com.example.pokedek.view.fragment.pokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.paging.PagingSource
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentPokemonBinding
import com.example.pokedek.model.remote.utils.Fetchstatus
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse
import com.example.pokedek.view.fragment.home.HomeFragmentDirections
import com.example.pokedek.view.fragment.pokemon.adapter.PokemonRvAdapter
import com.example.pokedek.viewmodel.remote.PokemonViewModel
import com.example.pokedek.viewmodel.utils.VModelFactory
import kotlinx.coroutines.launch

class PokemonFragment : Fragment() {
    private lateinit var binding: FragmentPokemonBinding

    private val apiViewModel : PokemonViewModel by viewModels{
        VModelFactory.getInstance()
    }

    private var isLoading= false

    private var dataList = ArrayList<PokemonSummaryResponse>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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


//            apiViewModel.getListPokemonTwo(5,5).observe(viewLifecycleOwner){
//                Log.d("pokemon list",it.next.toString())
//            }

            apiViewModel.getListPokemon().observe(viewLifecycleOwner){
                Log.d("pokemon list",it.toString())
                val adapter = PokemonRvAdapter()
                binding.recyclerviewpoke.adapter = adapter
                binding.recyclerviewpoke.layoutManager = LinearLayoutManager(requireContext())
                adapter.submitData(lifecycle,it)
            }
        }

    }

    private fun showPokemonList(data : List<PokemonSummaryResponse>){

    }

    private fun goToDetailPokemon(data : PokemonSummaryResponse){
            findNavController().navigate(HomeFragmentDirections.actionFragmenthomeToPokemondetailfragment(data))
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