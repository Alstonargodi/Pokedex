package com.example.pokedek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.Model.Apirepo
import com.example.pokedek.Viewmodel.Viewmodelapi
import com.example.pokedek.Viewmodel.Vmodelfactory

class MainActivity : AppCompatActivity() {
    lateinit var viewmodelapi: Viewmodelapi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var repo = Apirepo()
        var vmodelfactory = Vmodelfactory(repo)
        viewmodelapi = ViewModelProvider(this,vmodelfactory).get(Viewmodelapi::class.java)


        viewmodelapi.getlist()
        viewmodelapi.listapirespon.observe(this, Observer {
            val data = it.body()?.results?.get(0)?.url
//            Log.d("nama",data.toString())
        })


        viewmodelapi.getdata(2)
        viewmodelapi.sumapirespon.observe(this, Observer {
            val data = it.body()?.name

            Log.d("nama",data.toString())
        })

    }
}