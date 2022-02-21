package com.example.pokedek.Ui.Pokemon

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Model.Room.Entity.Favorite.Favoritelist
import com.example.pokedek.R
import com.example.pokedek.Viewmodel.Api.Apiviewmodel
import com.example.pokedek.Viewmodel.Api.Vmodelfactory
import com.example.pokedek.Viewmodel.Roomviewmodel
import com.example.pokedek.databinding.FragmentPokemondetailfragmentBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_fragmenthome.*
import kotlinx.android.synthetic.main.fragment_pokemondetailfragment.view.*
import java.text.SimpleDateFormat
import java.util.*

class Pokemondetailfragment : Fragment() {
    lateinit var apiviewmodel: Apiviewmodel
    lateinit var roomviewmodel: Roomviewmodel

    private var _binding : FragmentPokemondetailfragmentBinding? = null
    private val binding get() = _binding!!

    private var canadd : Boolean = false
    private var moveslist= arrayListOf<String>()

    override fun onStart() {
        super.onStart()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
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
                    val tvweight = ValueAnimator.ofInt(0,weight.toInt()).setDuration(500)
                    tvweight.addUpdateListener { binding.tvdetailPokemWeight.setText(it.animatedValue.toString()) }
                    tvweight.start()

                    val tvheigh = ValueAnimator.ofInt(0,height.toInt()).setDuration(500)
                    tvheigh.addUpdateListener { binding.tvdetailPokemHeight.setText(it.animatedValue.toString()) }
                    tvheigh.start()

                    binding.tvdetailPokemAbsatu.setText(absatu)
                    binding.tvdetailPokemAbdua.setText(abdua)

                    //second card
                    val tvhp = ValueAnimator.ofInt(0,HP!!).setDuration(500)
                    tvhp.addUpdateListener { binding.tvdetailPokemHp.setText(it.animatedValue.toString()) }
                    tvhp.start()

                    val tvatk = ValueAnimator.ofInt(0,atk!!).setDuration(500)
                    tvatk.addUpdateListener { binding.tvdetailPokemAtk.setText(it.animatedValue.toString()) }
                    tvatk.start()

                    val tvdef = ValueAnimator.ofInt(0,def!!).setDuration(500)
                    tvdef.addUpdateListener { binding.tvdetailPokemDef.setText(it.animatedValue.toString()) }
                    tvdef.start()

                    val tvsatk = ValueAnimator.ofInt(0,satk!!).setDuration(500)
                    tvsatk.addUpdateListener { binding.tvdetailPokemSatk.setText(it.animatedValue.toString()) }
                    tvsatk.start()

                    val tvsdef = ValueAnimator.ofInt(0,sdef!!).setDuration(500)
                    tvsdef.addUpdateListener { binding.tvdetailPokemSdef.setText(it.animatedValue.toString()) }
                    tvsdef.start()

                    val tvspd = ValueAnimator.ofInt(0,spd!!).setDuration(500)
                    tvspd.addUpdateListener { binding.tvdetailPokemSpd.setText(it.animatedValue.toString()) }
                    tvspd.start()


                    //base stat card
                    ObjectAnimator.ofInt(binding.statsbarHP,"progress",HP!!).setDuration(500).start()
                    ObjectAnimator.ofInt(binding.statsbarATK,"progress",atk!!).setDuration(500).start()
                    ObjectAnimator.ofInt(binding.statsbarSatk,"progress",satk!!).setDuration(500).start()
                    ObjectAnimator.ofInt(binding.statsbarDef,"progress",def!!).setDuration(500).start()
                    ObjectAnimator.ofInt(binding.statsbarSdef,"progress",sdef!!).setDuration(500).start()
                    ObjectAnimator.ofInt(binding.statsbarSpd,"progress",spd!!).setDuration(500).start()


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

                    //todo favorite btn
                    binding.btnFav.setOnClickListener {
                        binding.btnFav.setBackgroundResource(R.drawable.bk_full)
                        addtofavorite(name, link)
                    }

                }
            }catch (e : Exception){
                Log.d("pokemondetail",e.toString())
            }
        })

        binding.btnhomBack.setOnClickListener {
            findNavController().navigate(PokemondetailfragmentDirections.actionPokemondetailfragmentToPokemon())
        }

        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.detailtopoke)

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun ProgressBar.smoothProgress(percent: Int = 80){
        val animation = ObjectAnimator.ofInt(this, "progress", percent)
        animation.duration = 400
        animation.interpolator = DecelerateInterpolator()
        animation.start()
    }


    fun addtofavorite(name : String, link : String){

        var dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.succesadddialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

        //currrent date
        val date = SimpleDateFormat("d/MMM/YYY")
        val current = date.format(Date())
        val flist= Favoritelist(
            0,
            name,
            "pokemon",
            current.toString(),
            link
        )

        object  : CountDownTimer(1000, 1000){
            override fun onTick(p0: Long) {
                dialog.show()
            }
            override fun onFinish() {
                dialog.dismiss()
            }
        }.start()

        roomviewmodel.insertfav(flist)
    }
}