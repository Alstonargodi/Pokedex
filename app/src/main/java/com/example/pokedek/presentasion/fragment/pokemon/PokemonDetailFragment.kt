package com.example.pokedek.presentasion.fragment.pokemon

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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pokedek.R
import com.example.pokedek.databinding.ActivityMainBinding
import com.example.pokedek.databinding.FragmentPokemondetailBinding
import com.example.pokedek.model.local.entity.favorite.Favoritelist
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse
import com.example.pokedek.model.remote.utils.Fetchstatus
import com.example.pokedek.presentasion.fragment.pokemon.viewmodel.PokemonDetailViewModel
import com.example.pokedek.presentasion.viewmodel.local.LocalViewModel
import com.example.pokedek.presentasion.viewmodel.utils.ViewModelFactory
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class PokemonDetailFragment : Fragment() {

    private val detailViewModel : PokemonDetailViewModel by viewModels{
        ViewModelFactory.getInstance()
    }
    private val localViewModel by viewModels<LocalViewModel>()

    private lateinit var binding : FragmentPokemondetailBinding
    private lateinit var mainBinding : ActivityMainBinding
    private var name = ""
    private var link = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.detailtopoke)
        requireActivity().window.navigationBarColor = ContextCompat.getColor(requireContext(), R.color.detailbot)

        binding = FragmentPokemondetailBinding.inflate(inflater,container,false)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.root

        val characterName = PokemonDetailFragmentArgs.fromBundle(requireArguments()).characterName
        binding.textView.text = characterName
        name = characterName
        lifecycleScope.launch {
            getPokemonDetail(characterName)
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding.bottomMenu.visibility = View.GONE
        binding.btnBackhome.setOnClickListener {
            findNavController().navigate(
                PokemonDetailFragmentDirections.actionPokemondetailfragmentToPokemon()
            )
        }
        binding.btnShare.setOnClickListener {
            binding.btnShare.setBackgroundResource(R.drawable.bk_full)
            setFavorite()
        }
    }

    private suspend fun getPokemonDetail(name : String){
       detailViewModel.getPokemonSummary(name).observe(viewLifecycleOwner){response->
           when(response){
               is Fetchstatus.Loading->{
                    //loading view
               }
               is Fetchstatus.Sucess->{
                   showPokemonDetail(response.data)
               }
               is Fetchstatus.Error->{
                   //error view
               }
           }
       }
    }

    private fun showPokemonDetail(data : PokemonSummaryResponse){
        data.apply {
            binding.apply {
                link = sprites.other.officialArtwork.frontDefault
                Glide.with(requireContext())
                    .load(sprites.other.officialArtwork.frontDefault)
                    .into(imgdetailPokem)

                /*
                 text animation

                 update listener when
                 value changing
                 */
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
                        val abilityDialog = PokemonAbilityDialogFragment()
                        val supportManager = (activity as AppCompatActivity).supportFragmentManager

                        val args = Bundle()
                        args.putString(EXTRA_ABTONE,get(0).ability.name)
                        args.putString(EXTRA_ABTWO,get(1).ability.name)
                        abilityDialog.arguments = args
                        abilityDialog.show(supportManager, EXTRA_ABTDETAIL)
                    }
                }

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

            //detail character move
            binding.tvdetailPokemMoves.setOnClickListener {
                val dialog = PokemonMovesDialogFragment()
                val supportFragmentManager = (activity as AppCompatActivity).supportFragmentManager

                val args = Bundle()
                args.putString(EXTRA_NAME, data.name)
                dialog.arguments = args
                dialog.show(supportFragmentManager,EXTRA_MOVEDETAIL)
            }
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