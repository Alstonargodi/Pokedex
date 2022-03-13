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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedek.model.remote.ApiRepository
import com.example.pokedek.model.Room.Entity.Pokemon.PokemonSummary
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentHomeBinding

import com.example.pokedek.viewmodel.Roomviewmodel
import com.example.pokedek.viewmodel.Api.VModelFactory
import com.example.pokedek.view.pokemon.adapter.PokeHomeRvAdapter
import com.example.pokedek.viewmodel.Api.PokemonViewModel


class HomeFragment : Fragment() {

    companion object{
        const val PAGE = 0
        const val LIMIT = 10
        const val EXTRA_NAME = "HomeFragment"
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val apiViewModel by viewModels<PokemonViewModel>()
    private lateinit var roomViewModel: Roomviewmodel
    private lateinit var adapter : PokeHomeRvAdapter

    private var page = 0
    private var isLoading = false
    private var listsum = ArrayList<PokemonSummary>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val repo = ApiRepository()
        val vModelFactory = VModelFactory(repo)
        roomViewModel = ViewModelProvider(this)[Roomviewmodel::class.java]

        listsum = arrayListOf()
        adapter = PokeHomeRvAdapter()
        val recview = binding.recpokehom
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(context)


        binding.apply {
            btnPokelist.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionFragmenthomeToPokemon())
            }
            btnGofind.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionFragmenthomeToSearchfragment())
            }
            btnhomeBerry.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionFragmenthomeToBerryfragment())
            }
            btnGofav.setOnClickListener {
                val options = ActivityOptions.makeSceneTransitionAnimation(requireActivity())
                options.toBundle()
                findNavController().navigate(HomeFragmentDirections.actionFragmenthomeToFavoritefragment())
            }
            BtnItem.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionFragmenthomeToItem())
            }
            btnCompare.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionFragmenthomeToCompare())
            }
        }

        getPokemonList()
        getDataCount()
        return binding.root
    }


    private fun getPokemonList(){
        isLoading = true
        binding.pbarPokehome.visibility = View.VISIBLE

        apiViewModel.getPokemonList(PAGE, LIMIT)
        apiViewModel.pokelistrespon.observe(viewLifecycleOwner) { listRespon ->
            val data = listRespon.results
            for (element in data) {
                apiViewModel.getPokemonSummary(element.name)
                apiViewModel.pokesumrespon.observe(viewLifecycleOwner) { sumRespon ->
                    if (sumRespon.isSuccessful) {
                        sumRespon.body()?.apply {
                            val sum = PokemonSummary(
                                name,
                                sprites.other.officialArtwork.frontDefault,
                                height.toString(),
                                weight.toString(),
                                stats[0].baseStat.toString(), //hp
                                stats[1].baseStat.toString(), //atk
                                stats[5].baseStat.toString(), //spd
                                types[0].type.name,
                                abilities[0].ability.name,
                                abilities[1].ability.name,
                                stats[3].baseStat.toString(),
                                stats[4].baseStat.toString(),
                            )
                            listsum.add(sum)
                        }
                        adapter.setdata(listsum)
                        binding.pbarPokehome.visibility = View.INVISIBLE
                    } else {
                        setEmptyView()
                    }
                }
            }
        }
    }

    private fun getDataCount(){
        binding.recpokehom.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleitemcount = LinearLayoutManager(requireContext()).childCount
                val pastvisibleitem = LinearLayoutManager(requireContext()).findFirstCompletelyVisibleItemPosition()
                val total = adapter.itemCount

                if (!isLoading){
                    if ((visibleitemcount + pastvisibleitem) > total){
                        page++
                        Log.d("pagenumber",page.toString())
                    }
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun setEmptyView(){
        binding.recpokehom.apply {
            setPadding(10, 20, 10, 20)
            setBackgroundResource(R.drawable.emptyview)
        }
        binding.pbarPokehome.visibility = View.INVISIBLE
        Log.d(EXTRA_NAME, "cannot retrive sum data")
    }


}