package com.example.pokedek.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pokedek.view.berry.BerryFragment
import com.example.pokedek.view.item.ItemFragment
import com.example.pokedek.view.pokemon.PokemonFragment

class SectionPageAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0 ->PokemonFragment()
           1 ->BerryFragment()
           2 ->ItemFragment()
           else -> Fragment()
       }
    }
}