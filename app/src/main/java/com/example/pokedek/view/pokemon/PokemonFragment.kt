package com.example.pokedek.view.pokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentPokemonBinding
import com.example.pokedek.modedl.Api.Repo.ApiRepo
import com.example.pokedek.modedl.Room.Entity.Pokemon.Pokemonlist
import com.example.pokedek.view.pokemon.Adapter.Pokemonrvadapter
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

    lateinit var apiViewModel: Apiviewmodel
    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!

    private var isLoading= false
    private var adapter = Pokemonrvadapter()
    private var dataList = ArrayList<Pokemonlist>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)

        dataList = arrayListOf()
        val recView = binding.recyclerviewpoke
        adapter = Pokemonrvadapter()
        recView.adapter = adapter
        recView.layoutManager= LinearLayoutManager(context)
        recView.animate().start()

        val repo = ApiRepo()
        val vmFac = VModelFactory(repo)
        apiViewModel = ViewModelProvider(this,vmFac)[Apiviewmodel::class.java]

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
                            adapter.setdata(dataList.sortedBy { it.nama })
                        }
                        "Weight"->{
                            adapter.setdata(dataList.sortedBy { it.berat })
                        }
                        "Height"->{
                            adapter.setdata(dataList.sortedBy { it.tinggi })
                        }
                        "Hp"->{
                            adapter.setdata(dataList.sortedBy { it.hp })
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

        apiViewModel.getpokelist(PAGE, LIMIT)
        apiViewModel.pokelistrespon.observe(viewLifecycleOwner) { ListRespon ->
            if(ListRespon.isSuccessful){
                val data = ListRespon.body()?.results
                for(i in 0 until data!!.size){
                    apiViewModel.getpokesum(data[i].name)

                    apiViewModel.pokesumrespon.observe(viewLifecycleOwner) { SumRespon ->
                        if (SumRespon.isSuccessful){
                            SumRespon.body()?.apply {
                                val sum = Pokemonlist(
                                    name,
                                    sprites.other.officialArtwork.frontDefault,
                                    height.toString(),
                                    weight.toString(),
                                    stats[0].baseStat.toString(), //hp
                                    stats[1].baseStat.toString(), //atk
                                    stats[5].baseStat.toString(), //spd
                                )
                                dataList.add(sum)
                                adapter.setdata(dataList.sortedBy { it.nama })
                                binding.progressbarpoke.visibility = View.INVISIBLE
                            }

                        }else{
                            setEmptyView()
                        }
                    }
                }
            }else{
                setEmptyView()
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