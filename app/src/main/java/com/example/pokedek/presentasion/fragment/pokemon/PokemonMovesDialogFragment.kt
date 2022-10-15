package com.example.pokedek.presentasion.fragment.pokemon

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.pokedek.model.local.entity.pokemon.PokeMoveParcel
import com.example.pokedek.presentasion.fragment.pokemon.adapter.PokemonMovesAdapter
import com.example.pokedek.databinding.MovesdetailbottomfragmentBinding
import com.example.pokedek.presentasion.viewmodel.remote.PokemonViewModel

class PokemonMovesDialogFragment : BottomSheetDialogFragment() {
    private val pokeViewModel by viewModels<PokemonViewModel>()

    private lateinit var binding : MovesdetailbottomfragmentBinding

    private var movelist = arrayListOf<PokeMoveParcel>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MovesdetailbottomfragmentBinding.inflate(inflater, container, false)


        val adapter = PokemonMovesAdapter()
        val recView = binding.recviewMovesdetail
        recView.adapter = adapter
        recView.layoutManager = LinearLayoutManager(requireContext())

        val nama = arguments?.getString(PokemonDetailFragment.EXTRA_NAME)

        movelist = arrayListOf()
//        pokeViewModel.apply {
//            getPokemonSummary(nama!!)
//            pokesumrespon.observe(viewLifecycleOwner) { responData ->
//                //moves pokemon
//                val mov = responData.body()?.moves
//                for (i in mov!!.indices) {
//                    val move = mov[i].move.name
//
//                    getPokemonMoves(move)
//                    pokemovesrespon.observe(viewLifecycleOwner) { moves ->
//                        val entries = moves.body()?.effectEntries
//                        for (i in entries!!.indices){
//                            val effectMain = entries[i].effect
//                            val effectShort = entries[i].shortEffect
//
//                            val datamoves = PokeMoveParcel(
//                                effectMain,
//                                "",
//                                effectShort
//                            )
//
//                            movelist.add(datamoves)
//                            val filter = movelist.distinct()
//                            adapter.setdata(filter)
//                        }
//
//                    }
//                }
//            }
//        }

        return binding.root
    }

}