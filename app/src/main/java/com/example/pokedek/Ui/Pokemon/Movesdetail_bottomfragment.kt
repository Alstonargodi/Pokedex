package com.example.pokedek.Ui.Pokemon

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Model.Room.Entity.Pokemon.Pokemonmoves
import com.example.pokedek.Ui.Pokemon.Adapter.Pokemonmovesrvadapter
import com.example.pokedek.Viewmodel.Api.Apiviewmodel
import com.example.pokedek.Viewmodel.Api.Vmodelfactory
import com.example.pokedek.databinding.MovesdetailbottomfragmentBinding

class Movesdetail_bottomfragment : BottomSheetDialogFragment() {
    lateinit var  apiviewmodel: Apiviewmodel

    private var _binding: MovesdetailbottomfragmentBinding? = null
    private val binding get() = _binding!!

    private var movelist = arrayListOf<Pokemonmoves>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = MovesdetailbottomfragmentBinding.inflate(inflater, container, false)

        //viewmodel
        val repo = Apirepo()
        val vmf = Vmodelfactory(repo)
        apiviewmodel = ViewModelProvider(this,vmf).get(Apiviewmodel::class.java)

        //adapter
        val adapter = Pokemonmovesrvadapter()
        val recview = binding.recviewMovesdetail
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(requireContext())

        val nama = arguments?.getString("nama")

        movelist = arrayListOf()
        apiviewmodel.getpokesum(nama!!)
        apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { respon ->
            if (respon.isSuccessful){
                //moves pokemon
                val mov = respon.body()?.moves
                for (i in mov!!.indices){
                    val move = mov[i].move.name

                    apiviewmodel.getpokemoves(move)
                    apiviewmodel.pokemovesrespon.observe(viewLifecycleOwner, Observer { moves ->
                        if (moves.isSuccessful){
                            val effect = moves.body()?.effectEntries?.get(0)?.effect
                            val shorteffect = moves.body()?.effectEntries?.get(0)?.shortEffect

                            val datamoves = Pokemonmoves(
                                effect.toString(),
                                "",
                                shorteffect.toString()
                            )

                            movelist.add(datamoves)
                            val filter = movelist.distinct()
                            adapter.setdata(filter)

                        }
                    })
                }
            }
        })
        return binding.root
    }

}