package com.example.pokedek.view.pokemon

import android.app.Dialog
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.modedl.remote.ApiRepository
import com.example.pokedek.viewmodel.Api.Apiviewmodel
import com.example.pokedek.viewmodel.Api.VModelFactory
import com.example.pokedek.databinding.AbilitydetailbottomfragmentBinding
import com.example.pokedek.view.pokemon.PokemonDetailFragment.Companion.EXTRA_ABTONE
import com.example.pokedek.view.pokemon.PokemonDetailFragment.Companion.EXTRA_ABTWO
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class PokemonAbilityFragment : BottomSheetDialogFragment() {
    lateinit var apiviewmodel: Apiviewmodel

    private var _binding: AbilitydetailbottomfragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AbilitydetailbottomfragmentBinding.inflate(inflater, container, false)

        val nama = arguments?.getString(EXTRA_ABTONE)
        val namadua = arguments?.getString(EXTRA_ABTWO)

        val repo = ApiRepository()
        val vmf = VModelFactory(repo)
        apiviewmodel = ViewModelProvider(this,vmf)[Apiviewmodel::class.java]

        binding.AbdetailName.text = nama
        binding.AbdetailEffectDUA.text = namadua

        apiviewmodel.getPokemonAbilty(nama!!)
        apiviewmodel.pokeabtrespon.observe(viewLifecycleOwner) { responAbility ->
            val effectSum = responAbility.body()?.effectEntries?.get(1)?.effect.toString()
            val effectDetail = responAbility.body()?.effectEntries?.get(1)?.shortEffect.toString()

            "$effectSum\n$effectDetail".also { binding.AbdetailEffect.text = it }

        }

        apiviewmodel.getPokemonAbilty(namadua!!)
        apiviewmodel.pokeabtrespon.observe(viewLifecycleOwner) { responabt ->
            if (responabt.isSuccessful) {
                val effectSum = responabt.body()?.effectEntries?.get(1)?.effect.toString()
                val effectDetail = responabt.body()?.effectEntries?.get(1)?.shortEffect.toString()

                "$effectSum\n$effectDetail".also { binding.AbdetailEffectDUA.text = it }
            }
        }

        return binding.root
    }

    //full dialog config
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {

            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { full ->
                val behaviour = BottomSheetBehavior.from(full)
                setupFullHeight(full)
                behaviour.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            }
        }
        return dialog
    }

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }





}