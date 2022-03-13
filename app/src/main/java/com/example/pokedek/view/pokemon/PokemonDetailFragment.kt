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
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pokedek.R
import com.example.pokedek.databinding.FragmentPokemondetailfragmentBinding
import com.example.pokedek.model.Room.Entity.Favorite.Favoritelist
import com.example.pokedek.viewmodel.Api.PokemonViewModel
import com.example.pokedek.viewmodel.Roomviewmodel
import java.text.SimpleDateFormat
import java.util.*

class PokemonDetailFragment : Fragment() {
    private val apiViewModel by viewModels<PokemonViewModel>()
    private val localViewModel by viewModels<Roomviewmodel>()

    private lateinit var binding : FragmentPokemondetailfragmentBinding

    private var name = ""
    private var link = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemondetailfragmentBinding.inflate(inflater,container,false)


        val data = PokemonDetailFragmentArgs.fromBundle(requireArguments()).dataDetail
        binding.tvdetailPokemName.text = data.name
        name = data.name

        apiViewModel.getPokemonSummary(data.name)
        apiViewModel.pokesumrespon.observe(viewLifecycleOwner) { responDetail ->
            responDetail.body()?.apply {
                binding.apply {
                    link = sprites.other.officialArtwork.frontDefault

                    Glide.with(requireContext())
                        .asBitmap()
                        .load(sprites.other.officialArtwork.frontDefault)
                        .into(imgdetailPokem)

                    //First Card
                    tvdetailPokemTypes.text = types[0].type.name
                    val tvWeight = ValueAnimator.ofInt(0, weight).setDuration(500)
                    tvWeight.addUpdateListener { tvdetailPokemWeight.text = it.animatedValue.toString() }
                    tvWeight.start()

                    val tvHeight = ValueAnimator.ofInt(0, height).setDuration(500)
                    tvHeight.addUpdateListener { tvdetailPokemHeight.text = it.animatedValue.toString() }
                    tvHeight.start()

                    abilities.apply {
                        tvdetailPokemAbsatu.text = get(0).ability.name
                        tvdetailPokemAbdua.text = get(1).ability.name

                        tvdetailPokemAbsatu.setOnClickListener {
                            val abilityDialog = PokemonAbilityFragment()
                            val supportManager = (activity as AppCompatActivity).supportFragmentManager

                            val args = Bundle()
                            args.putString(EXTRA_ABTONE,get(0).ability.name)
                            args.putString(EXTRA_ABTWO,get(1).ability.name)
                            abilityDialog.arguments = args
                            abilityDialog.show(supportManager, EXTRA_ABTDETAIL)
                        }
                    }

                    //Second Card
                    stats.apply {
                        val tvHealth = ValueAnimator.ofInt(0,get(0).baseStat).setDuration(500)
                        ObjectAnimator.ofInt(statsbarHP,EXTRA_NAME,get(0).baseStat).setDuration(500).start()
                        tvHealth.addUpdateListener { tvdetailPokemHp.text = it.animatedValue.toString() }
                        tvHealth.start()

                        val tvAttack = ValueAnimator.ofInt(0,get(1).baseStat).setDuration(500)
                        ObjectAnimator.ofInt(statsbarATK,EXTRA_NAME,get(1).baseStat).setDuration(500).start()
                        tvAttack.addUpdateListener { tvdetailPokemAtk.text = it.animatedValue.toString() }
                        tvAttack.start()

                        val tvDefence = ValueAnimator.ofInt(0,get(2).baseStat).setDuration(500)
                        ObjectAnimator.ofInt(statsbarDef,EXTRA_NAME,get(2).baseStat).setDuration(500).start()
                        tvDefence.addUpdateListener { tvdetailPokemDef.text = it.animatedValue.toString() }
                        tvDefence.start()

                        val tvsAttack = ValueAnimator.ofInt(0,get(3).baseStat).setDuration(500)
                        ObjectAnimator.ofInt(statsbarSatk,EXTRA_NAME,get(3).baseStat).setDuration(500).start()
                        tvsAttack.addUpdateListener { tvdetailPokemSatk.text = it.animatedValue.toString() }
                        tvsAttack.start()

                        val tvsDefence = ValueAnimator.ofInt(0,get(4).baseStat).setDuration(500)
                        ObjectAnimator.ofInt(statsbarSdef,EXTRA_NAME,get(4).baseStat).setDuration(500).start()
                        tvsDefence.addUpdateListener { tvdetailPokemSdef.text = it.animatedValue.toString() }
                        tvsDefence.start()

                        val tvSpeed = ValueAnimator.ofInt(0,get(5).baseStat).setDuration(500)
                        ObjectAnimator.ofInt(statsbarSpd,EXTRA_NAME,get(5).baseStat).setDuration(500).start()
                        tvSpeed.addUpdateListener { tvdetailPokemSpd.text = it.animatedValue.toString() }
                        tvSpeed.start()
                    }
                }
            }

            //moves pokemon dialog
            binding.tvdetailPokemMoves.setOnClickListener {
                val dialog = PokemonMovesFragment()
                val supportFragmentManager = (activity as AppCompatActivity).supportFragmentManager

                val args = Bundle()
                args.putString(EXTRA_NAME, data.name)
                dialog.arguments = args
                dialog.show(supportFragmentManager,EXTRA_MOVEDETAIL)
            }

        }
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.detailtopoke)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnhomBack.setOnClickListener {
            findNavController().navigate(PokemonDetailFragmentDirections.actionPokemondetailfragmentToPokemon())
        }

        binding.btnFav.setOnClickListener {
            binding.btnFav.setBackgroundResource(R.drawable.bk_full)
            setFavorite()
        }

    }



    @SuppressLint("SimpleDateFormat")
    private fun setFavorite(){
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.succesadddialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

        val dateFormat = SimpleDateFormat("d/MMM/yyy")
        val currentDate = dateFormat.format(Date())

        val favoriteTemp= Favoritelist(
            0,
            name,
            "pokemon",
            currentDate.toString(),
            link
        )

        object: CountDownTimer(1000, 1000){
            override fun onTick(p0: Long) { dialog.show() }
            override fun onFinish() { dialog.dismiss() }
        }.start()

        localViewModel.insertfav(favoriteTemp)
    }

    companion object{
        const val EXTRA_NAME = "progress"
        const val EXTRA_ABTONE = "abilityone"
        const val EXTRA_ABTWO = "abilitytwo"
        const val EXTRA_ABTDETAIL = "abtdialog"
        const val EXTRA_MOVEDETAIL = "movedetail"
    }

}