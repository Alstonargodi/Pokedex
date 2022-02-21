package com.example.pokedek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        immersivemode()
    }

    private fun immersivemode(){
        window.statusBarColor = ContextCompat.getColor(this,R.color.detailtop)
        window.navigationBarColor = ContextCompat.getColor(this,R.color.detailbot)
    }
}