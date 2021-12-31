package com.example.pokedek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.Model.Apirepo
import com.example.pokedek.Model.Pokemonsum.Pokesummary
import com.example.pokedek.Model.Recview.Pokesum
import com.example.pokedek.Ui.Rvpokehomadapter
import com.example.pokedek.Viewmodel.Viewmodelapi
import com.example.pokedek.Viewmodel.Vmodelfactory
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var viewmodelapi: Viewmodelapi

    var listsum = ArrayList<Pokesum>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var repo = Apirepo()
        var vmodelfactory = Vmodelfactory(repo)
        viewmodelapi = ViewModelProvider(this,vmodelfactory).get(Viewmodelapi::class.java)


        listsum = arrayListOf()
        val adapter = Rvpokehomadapter()
        val recview = recpokehom
        recview.adapter = adapter
        recview.layoutManager = LinearLayoutManager(this)

        viewmodelapi.getlist()
        viewmodelapi.listapirespon.observe(this, Observer {
            val data = it.body()?.results
            for(i in 0 until data!!.size){
                val nama = data[i].name
                viewmodelapi.getdata(nama)
                viewmodelapi.sumapirespon.observe(this, Observer {
                    if (it.isSuccessful){
                        val sum = Pokesum(
                            it.body()?.name.toString(),
                            it.body()?.sprites!!.other.officialArtwork.frontDefault
                        )

                        listsum.add(sum)
                        adapter.setdata(listsum)
                    }
                })

            }
        })

    }
}