package com.example.pokedek.view.pokemon

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pokedek.modedl.Room.Entity.Favorite.Favoritelist
import com.example.pokedek.R
import com.example.pokedek.viewmodel.Api.Apiviewmodel
import com.example.pokedek.viewmodel.Roomviewmodel
import com.example.pokedek.databinding.FragmentPokemondetailfragmentBinding
import kotlinx.android.synthetic.main.fragment_pokemondetailfragment.view.*
import java.text.SimpleDateFormat
import java.util.*

class PokemonDetailFragment : Fragment() {
    companion object{
        const val EXTRA_NAME = "progress"
    }
    private val apiViewModel by viewModels<Apiviewmodel>()
    private lateinit var localViewModel: Roomviewmodel

    private lateinit var binding : FragmentPokemondetailfragmentBinding
    private var moveslist= arrayListOf<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemondetailfragmentBinding.inflate(inflater,container,false)

        //Api
        moveslist = arrayListOf()

        //Room
        localViewModel = ViewModelProvider(this)[Roomviewmodel::class.java]
        val data = PokemonDetailFragmentArgs.fromBundle(requireArguments()).dataDetail
        binding.tvdetailPokemName.text = data.name

        apiViewModel.getPokemonSummary(data.name)
        apiViewModel.pokesumrespon.observe(viewLifecycleOwner) { respon ->
            respon.body()?.apply {
                binding.apply {

                    Glide.with(requireContext())
                        .asBitmap()
                        .load(sprites.other.officialArtwork.frontDefault)
                        .into(imgdetailPokem)

                    //First Card
                    tvdetailPokemTypes.text = types[0].type.name
                    val tvWieght = ValueAnimator.ofInt(0, weight).setDuration(500)
                    tvWieght.addUpdateListener { tvdetailPokemWeight.text = it.animatedValue.toString() }
                    tvWieght.start()

                    val tvheigh = ValueAnimator.ofInt(0, height).setDuration(500)
                    tvheigh.addUpdateListener { tvdetailPokemHeight.text = it.animatedValue.toString() }
                    tvheigh.start()

                    abilities.apply {
                        tvdetailPokemAbsatu.text = get(0).ability.name
                        tvdetailPokemAbdua.text = get(1).ability.name

                        tvdetailPokemAbsatu.setOnClickListener {
                            val dialog = Abilitydetail_bottomfragment()
                            val sm = (activity as AppCompatActivity).supportFragmentManager

                            val args = Bundle()
                            args.putString("ABTOne",get(0).ability.name)
                            args.putString("ABTTwo",get(1).ability.name)
                            dialog.arguments = args
                            dialog.show(sm, "abtdialog")
                        }
                    }


                    btnFav.setOnClickListener {
                        binding.btnFav.setBackgroundResource(R.drawable.bk_full)
                        addtofavorite(data.name,sprites.other.officialArtwork.frontDefault)
                    }

                    //Second Card
                    stats.apply {
                        val tvhp = ValueAnimator.ofInt(0,get(0).baseStat).setDuration(500)
                        ObjectAnimator.ofInt(statsbarHP,EXTRA_NAME,get(0).baseStat).setDuration(500).start()
                        tvhp.addUpdateListener { tvdetailPokemHp.text = it.animatedValue.toString() }
                        tvhp.start()

                        val tvatk = ValueAnimator.ofInt(0,get(1).baseStat).setDuration(500)
                        ObjectAnimator.ofInt(statsbarATK,EXTRA_NAME,get(1).baseStat).setDuration(500).start()
                        tvatk.addUpdateListener { tvdetailPokemAtk.text = it.animatedValue.toString() }
                        tvatk.start()

                        val tvdef = ValueAnimator.ofInt(0,get(2).baseStat).setDuration(500)
                        ObjectAnimator.ofInt(statsbarDef,EXTRA_NAME,get(2).baseStat).setDuration(500).start()
                        tvdef.addUpdateListener { tvdetailPokemDef.text = it.animatedValue.toString() }
                        tvdef.start()

                        val tvsatk = ValueAnimator.ofInt(0,get(3).baseStat).setDuration(500)
                        ObjectAnimator.ofInt(statsbarSatk,EXTRA_NAME,get(3).baseStat).setDuration(500).start()
                        tvsatk.addUpdateListener { tvdetailPokemSatk.text = it.animatedValue.toString() }
                        tvsatk.start()

                        val tvsdef = ValueAnimator.ofInt(0,get(4).baseStat).setDuration(500)
                        ObjectAnimator.ofInt(statsbarSdef,EXTRA_NAME,get(4).baseStat).setDuration(500).start()
                        tvsdef.addUpdateListener { tvdetailPokemSdef.text = it.animatedValue.toString() }
                        tvsdef.start()

                        val tvspd = ValueAnimator.ofInt(0,get(5).baseStat).setDuration(500)
                        ObjectAnimator.ofInt(statsbarSpd,EXTRA_NAME,get(5).baseStat).setDuration(500).start()
                        tvspd.addUpdateListener { tvdetailPokemSpd.text = it.animatedValue.toString() }
                        tvspd.start()
                    }
                }
            }

            //moves pokemon dialog
            binding.tvdetailPokemMoves.setOnClickListener {
                val dialog = Movesdetail_bottomfragment()
                val sm = (activity as AppCompatActivity).supportFragmentManager

                val args = Bundle()
                args.putString("nama", data.name)
                dialog.arguments = args
                dialog.show(sm, "movesdialog")
            }

        }
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.detailtopoke)
        setValueDetail()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnhomBack.setOnClickListener {
            findNavController().navigate(PokemonDetailFragmentDirections.actionPokemondetailfragmentToPokemon())
        }

    }


    fun ProgressBar.smoothProgress(percent: Int = 80){
        val animation = ObjectAnimator.ofInt(this, "progress", percent)
        animation.duration = 400
        animation.interpolator = DecelerateInterpolator()
        animation.start()
    }


    @SuppressLint("SimpleDateFormat")
    fun addtofavorite(name : String, link : String){

        var dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.succesadddialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

        //currrent date
        val date = SimpleDateFormat("d/MMM/yyy")
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

        localViewModel.insertfav(flist)
    }


    private fun setValueDetail(){
        val data = PokemonDetailFragmentArgs.fromBundle(requireArguments()).dataDetail

    }
}