package com.example.pokedek.Ui.Pokemon

import android.animation.ObjectAnimator
import android.os.Bundle
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
import kotlinx.android.synthetic.main.fragment_pokemondetailfragment.view.*

class Pokemondetailfragment : Fragment() {
    lateinit var apiviewmodel: Apiviewmodel

    private var moveslist= arrayListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pokemondetailfragment, container, false)

        moveslist = arrayListOf()
        val repo = Apirepo()
        val vmodel = Vmodelfactory(repo)
        apiviewmodel = ViewModelProvider(this,vmodel).get(Apiviewmodel::class.java)

        val name = PokemondetailfragmentArgs.fromBundle(requireArguments()).pokemonname
        view.tvdetail_pokem_name.setText(name)

        apiviewmodel.getpokesum(name)
        apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { respon ->
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
                view.tvdetail_pokem_types.setText(types)
                view.tvdetail_pokem_weight.setText(weight!!)
                view.tvdetail_pokem_height.setText(height)
                view.tvdetail_pokem_absatu.setText(absatu)
                view.tvdetail_pokem_abdua.setText(abdua)

                //second card
                view.tvdetail_pokem_hp.setText(HP!!.toString())
                view.tvdetail_pokem_atk.setText(atk!!.toString())
                view.tvdetail_pokem_def.setText(def!!.toString())
                view.tvdetail_pokem_satk.setText(satk!!.toString())
                view.tvdetail_pokem_sdef.setText(sdef!!.toString())
                view.tvdetail_pokem_spd.setText(spd!!.toString())

                //base stat card
                view.statsbar_HP.progress = HP!!
                view.statsbar_ATK.progress = atk!!
                view.statsbar_def.progress = def!!
                view.statsbar_satk.progress = satk!!
                view.statsbar_sdef.progress = sdef!!
                view.statsbar_spd.progress = spd!!

                //ability pokemon dialog
                view.tvdetail_pokem_absatu.setOnClickListener {
                    val dialog = Abilitydetail_bottomfragment()
                    val sm = ( activity as AppCompatActivity).supportFragmentManager

                    val args = Bundle()
                    args.putString("nama",absatu.toString())
                    args.putString("namadua",abdua.toString())
                    dialog.setArguments(args)
                    dialog.show(sm,"abtdialog")
                }

                //moves pokemon dialog
                view.tvdetail_pokem_moves.setOnClickListener {
                    val dialog = Movesdetail_bottomfragment()
                    val sm = ( activity as AppCompatActivity).supportFragmentManager

                    val args = Bundle()
                    args.putString("nama",name)
                    dialog.setArguments(args)
                    dialog.show(sm,"movesdialog")
                }

            }
        })

        //todo favorite btn
        view.btn_fav.setOnClickListener {
            view.btn_fav.setBackgroundResource(R.drawable.bk_full)
        }

        view.btnhom_back.setOnClickListener {
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


}