package com.example.pokedek.view.pokemon

import android.app.Dialog
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.modedl.remote.ApiRepository
import com.example.pokedek.viewmodel.Api.Apiviewmodel
import com.example.pokedek.viewmodel.Api.VModelFactory
import com.example.pokedek.databinding.AbilitydetailbottomfragmentBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class Abilitydetail_bottomfragment : BottomSheetDialogFragment() {
    lateinit var apiviewmodel: Apiviewmodel

    private var _binding: AbilitydetailbottomfragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AbilitydetailbottomfragmentBinding.inflate(inflater, container, false)

        val nama = arguments?.getString("ABTOne")
        val namadua = arguments?.getString("ABTTwo")

        val repo = ApiRepository()
        val vmf = VModelFactory(repo)
        apiviewmodel = ViewModelProvider(this,vmf).get(Apiviewmodel::class.java)

        binding.AbdetailName.setText(nama)
        binding.AbdetailEffectDUA.setText(namadua)

        apiviewmodel.getPokemonAbilty(nama!!)
        apiviewmodel.pokeabtrespon.observe(viewLifecycleOwner, Observer { responabt ->
            if (responabt.isSuccessful){
                val effect = responabt.body()?.effectEntries?.get(1)?.effect.toString()
                val effectmore = responabt.body()?.effectEntries?.get(1)?.shortEffect.toString()

                binding.AbdetailEffect.setText(effect)
                binding.AbdetailEffectmore.setText(effectmore)

            }
        })

        apiviewmodel.getPokemonAbilty(namadua!!)
        apiviewmodel.pokeabtrespon.observe(viewLifecycleOwner, Observer { responabt ->
            if (responabt.isSuccessful){
                val effect = responabt.body()?.effectEntries?.get(1)?.effect.toString()
                val effectmore = responabt.body()?.effectEntries?.get(1)?.shortEffect.toString()

                binding.AbdetailEffectDUA.setText(effect)
                binding.AbdetailEffectmoredua.setText(effectmore)

            }
        })

        return binding.root
    }

    //full dialog config
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {

            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { it ->
                val behaviour = BottomSheetBehavior.from(it)
                setupFullHeight(it)
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