package com.example.pokedek.Ui.Pokemon

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.R
import com.example.pokedek.Viewmodel.Api.Apiviewmodel
import com.example.pokedek.Viewmodel.Api.Vmodelfactory
import com.example.pokedek.Viewmodel.Roomviewmodel
import com.example.pokedek.databinding.FragmentPokemondetailfragmentBinding
import kotlinx.android.synthetic.main.fragment_pokemondetailfragment.view.*
import java.lang.Exception

class Pokemondetailfragment : Fragment() {
    lateinit var apiviewmodel: Apiviewmodel
    lateinit var roomviewmodel: Roomviewmodel

    private var _binding : FragmentPokemondetailfragmentBinding? = null
    private val binding get() = _binding!!

    private var moveslist= arrayListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemondetailfragmentBinding.inflate(inflater,container,false)
        val view = binding.root

        //Api
        moveslist = arrayListOf()
        val repo = Apirepo()
        val vmodel = Vmodelfactory(repo)
        apiviewmodel = ViewModelProvider(this,vmodel).get(Apiviewmodel::class.java)

        //Room
        roomviewmodel = ViewModelProvider(this).get(Roomviewmodel::class.java)


        val name = PokemondetailfragmentArgs.fromBundle(requireArguments()).pokemonname
        binding.tvdetailPokemName.setText(name)

        apiviewmodel.getpokesum(name)
        apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { respon ->
            try {
                if (respon.isSuccessful){
                    val types = respon.body()?.types?.get(0)?.type?.name
                    val weight = respon.body()?.weight.toString()
                    val height = respon.body()?.height.toString()
                    val absatu = respon.body()?.abilities?.get(0)?.ability?.name
                    val abdua = respon.body()?.abilities?.get(1)?.ability?.name

                    val HP = respon.body()?.stats?.get(0)?.baseStat
                    val atk = respon.body()?.stats?.get(1)?.baseStat
                    val def = respon.body()?.stats?.get(2)?.baseStat
                    val satk = respon.body()?.stats?.get(3)?.baseStat
                    val sdef = respon.body()?.stats?.get(4)?.baseStat
                    val spd = respon.body()?.stats?.get(5)?.baseStat
                    val link = respon.body()?.sprites!!.other.officialArtwork.frontDefault

                    Glide.with(requireContext())
                        .asBitmap()
                        .load(link)
                        .into(view.imgdetail_pokem)

                    //first card
                    binding.tvdetailPokemTypes.setText(types)
                    binding.tvdetailPokemWeight.setText(weight!!)
                    binding.tvdetailPokemHeight.setText(height)
                    binding.tvdetailPokemAbsatu.setText(absatu)
                    binding.tvdetailPokemAbdua.setText(abdua)

                    //second card
                    binding.tvdetailPokemHp.setText(HP!!.toString())
                    binding.tvdetailPokemAtk.setText(atk!!.toString())
                    binding.tvdetailPokemDef.setText(def!!.toString())
                    binding.tvdetailPokemSatk.setText(satk!!.toString())
                    binding.tvdetailPokemSdef.setText(sdef!!.toString())
                    binding.tvdetailPokemSpd.setText(spd!!.toString())

                    //base stat card
                    binding.statsbarHP.progress = HP!!
                    binding.statsbarATK.progress = atk!!
                    binding.statsbarDef.progress = def!!
                    binding.statsbarSatk.progress = satk!!
                    binding.statsbarSdef.progress = sdef!!
                    binding.statsbarSpd.progress = spd!!

                    //ability pokemon dialog
                    binding.tvdetailPokemAbsatu.setOnClickListener {
                        val dialog = Abilitydetail_bottomfragment()
                        val sm = ( activity as AppCompatActivity).supportFragmentManager

                        val args = Bundle()
                        args.putString("nama",absatu.toString())
                        args.putString("namadua",abdua.toString())
                        dialog.setArguments(args)
                        dialog.show(sm,"abtdialog")
                    }

                    //moves pokemon dialog
                    binding.tvdetailPokemMoves.setOnClickListener {
                        val dialog = Movesdetail_bottomfragment()
                        val sm = ( activity as AppCompatActivity).supportFragmentManager

                        val args = Bundle()
                        args.putString("nama",name)
                        dialog.setArguments(args)
                        dialog.show(sm,"movesdialog")
                    }

                }
            }catch (e : Exception){
                Log.d("pokemondetail",e.toString())
            }
        })

        //todo favorite btn
        binding.btnFav.setOnClickListener {
            view.btn_fav.setBackgroundResource(R.drawable.bk_full)

        }

        binding.btnhomBack.setOnClickListener {
            findNavController().navigate(PokemondetailfragmentDirections.actionPokemondetailfragmentToPokemon())
        }

        return view
    }

    fun ProgressBar.smoothProgress(percent: Int = 80){
        val animation = ObjectAnimator.ofInt(this, "progress", percent)
        animation.duration = 400
        animation.interpolator = DecelerateInterpolator()
        animation.start()
    }

    fun addtofavorite(){


    }


}