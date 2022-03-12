package com.example.pokedek.view.pokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentPokemonBinding
import com.example.pokedek.modedl.remote.ApiRepository
import com.example.pokedek.modedl.Room.Entity.Pokemon.PokemonSum
import com.example.pokedek.view.pokemon.adapter.PokemonRvAdapter
import com.example.pokedek.viewmodel.Api.Apiviewmodel
import com.example.pokedek.viewmodel.Api.VModelFactory

class PokemonFragment : Fragment() {

    companion object{
        const val PAGE = 0
        const val LIMIT = 10

        const val LEFT = 10
        const val TOP = 20
        const val RIGHT = 10
        const val BOTTOM = 20

        const val EXTRA_NAME = "PokemonFragment"
    }

    private val apiViewModel by viewModels<Apiviewmodel>()

    private lateinit var binding: FragmentPokemonBinding


    private var isLoading= false
    private var adapter = PokemonRvAdapter()
    private var dataList = ArrayList<PokemonSum>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonBinding.inflate(inflater, container, false)

        dataList = arrayListOf()
        val recView = binding.recyclerviewpoke
        adapter = PokemonRvAdapter()
        recView.adapter = adapter
        recView.layoutManager= LinearLayoutManager(context)
        recView.animate().start()


        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnMenu.setOnClickListener {
                findNavController().navigate(PokemonFragmentDirections.actionPokemonToFragmenthome())
                requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.detailtop)
            }

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
                            adapter.setdata(dataList.sortedBy { it.name })
                        }
                        "Weight"->{
                            adapter.setdata(dataList.sortedBy { it.weight })
                        }
                        "Height"->{
                            adapter.setdata(dataList.sortedBy { it.height })
                        }
                        "Hp"->{
                            adapter.setdata(dataList.sortedBy { it.power })
                        }
                        "Speed"->{
                            adapter.setdata(dataList.sortedBy { it.speed })
                        }
                        "Attack"->{
                            adapter.setdata(dataList.sortedBy { it.attack })
                        }
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    getPokemonList()
                }
            }
        }

        getPokemonList()
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.detailtopoke)
    }

    private fun getPokemonList(){
        isLoading = true
        binding.progressbarpoke.visibility = View.VISIBLE

        apiViewModel.getPokemonList(PAGE, LIMIT)
        apiViewModel.pokelistrespon.observe(viewLifecycleOwner) { ListRespon ->
            val data = ListRespon.results
            for(element in data){
                apiViewModel.getPokemonSummary(element.name)
                apiViewModel.pokesumrespon.observe(viewLifecycleOwner) { SumRespon ->
                    if (SumRespon.isSuccessful){
                        SumRespon.body()?.apply {
                            val sum = PokemonSum(
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
                            dataList.add(sum)
                            adapter.setdata(dataList.sortedBy { it.name })
                            binding.progressbarpoke.visibility = View.INVISIBLE
                        }
                    }else{
                        setEmptyView()
                    }
                }
            }
        }
    }

    private fun setEmptyView(){
        binding.recyclerviewpoke.apply {
            setPadding(LEFT, TOP, RIGHT, BOTTOM)
            setBackgroundResource(R.drawable.emptyview)
        }
        binding.progressbarpoke.visibility = View.INVISIBLE
        Log.d(EXTRA_NAME, "cannot retrive sum data")
    }
}