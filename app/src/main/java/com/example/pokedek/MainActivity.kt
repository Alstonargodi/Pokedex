package com.example.pokedek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.pokedek.databinding.ActivityMainBinding
import com.example.pokedek.view.fragment.favorite.Favoritefragment
import com.example.pokedek.view.fragment.home.HomeFragment
import com.example.pokedek.view.fragment.search.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        immersiveCode()


        binding.bottomMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.rumah->setFragment(HomeFragment())
                R.id.search->setFragment(SearchFragment())
                R.id.favorite->setFragment(Favoritefragment())
            }
            true
        }
    }

    private fun setFragment(fragment : Fragment){
        val supfragment = supportFragmentManager
        val transfragment = supfragment.beginTransaction()
        transfragment.replace(R.id.fragmenthost,fragment)
        transfragment.commit()
    }

    private fun immersiveCode(){
        window.statusBarColor = ContextCompat.getColor(this,R.color.detailtop)
        window.navigationBarColor = ContextCompat.getColor(this,R.color.detailbot)
    }
}