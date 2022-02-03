package com.example.pokedek.Ui.Pokemon

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Model.Room.Entity.Pokemon.Pokemonlist
import com.example.pokedek.R
import com.example.pokedek.Ui.Pokemon.Adapter.Pokemonrvadapter
import com.example.pokedek.Viewmodel.Api.Apiviewmodel
import com.example.pokedek.Viewmodel.Api.Vmodelfactory
import com.example.pokedek.databinding.FragmentPokemonBinding
import kotlinx.android.synthetic.main.fragment_pokemon.view.*

class Pokemonfragment : Fragment() {
    lateinit var apiviewmodel: Apiviewmodel
    lateinit var binding : FragmentPokemonBinding

    private var isloading= false
    private var adapter = Pokemonrvadapter()
    var arrayList = ArrayList<Pokemonlist>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonBinding.inflate(layoutInflater)
        val view =  binding.root


        //recyclerview
        arrayList = arrayListOf()
        val recview= view.recyclerviewpoke
        adapter = Pokemonrvadapter()
        recview.adapter = adapter
        recview.layoutManager= LinearLayoutManager(context)
        recview.animate().start()


        //api
        val repo = Apirepo()
        val vmfac = Vmodelfactory(repo)
        apiviewmodel = ViewModelProvider(this,vmfac).get(Apiviewmodel::class.java)


        binding.btnMenu.setOnClickListener {
            findNavController().navigate(PokemonfragmentDirections.actionPokemonToFragmenthome())
        }

        binding.tvsort.setOnClickListener {
            binding.layhide.visibility =
                if (binding.layhide.visibility == View.GONE)
                    View.VISIBLE
                else
                    View.GONE
        }

        binding.Pokespin.onItemSelectedListener = object : AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val position = p0?.getItemAtPosition(p2)
                when(position){
                    "Name"->{
                        pokemonlistsortname()
                    }
                    "Weight"->{
                        pokemonlistsortwidth()
                    }
                    "Height"->{
                        pokemonlistsortheight()
                    }
                    "Hp"->{
                        pokemonlistsorthp()
                    }
                    "Speed"->{
                        pokemonlistsortspeed()
                    }
                    "Attack"->{
                        pokemonlistsortatak()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                pokemonlistsortname()
            }

        }

        pokemonlistsortname()

        return view
    }

    fun pokemonlistsortname(){
        isloading = true
        view?.progressbarpoke?.visibility = View.VISIBLE

        apiviewmodel.getpokelist(0,10)
        apiviewmodel.pokelistrespon.observe(viewLifecycleOwner, Observer { pokelist ->
            if(pokelist.isSuccessful){
                val data = pokelist.body()?.results
                for(i in 0 until data!!.size){
                    val nama = data[i].name
                    apiviewmodel.getpokesum(nama)

                    apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { sumrespon ->
                        if (sumrespon.isSuccessful){

                            val sum = Pokemonlist(
                                sumrespon.body()?.name.toString(),
                                sumrespon.body()?.sprites!!.other.officialArtwork.frontDefault,
                                sumrespon.body()?.height.toString(),
                                sumrespon.body()?.weight.toString(),
                                sumrespon.body()?.stats?.get(0)?.baseStat.toString(), //hp
                                sumrespon.body()?.stats?.get(1)?.baseStat.toString(), //atk
                                sumrespon.body()?.stats?.get(5)?.baseStat.toString(), //spd
                            )

                            sumrespon.body()?.stats?.get(0)?.baseStat //hp
                            sumrespon.body()?.stats?.get(1)?.baseStat //atk
                            sumrespon.body()?.stats?.get(5)?.baseStat //spd

                            arrayList.add(sum)
                            adapter.setdata(arrayList.sortedBy { it.nama })
                            view?.progressbarpoke?.visibility = View.INVISIBLE

                        }else{
                            view?.recyclerviewpoke?.setPadding(10,20,10,20)
                            view?.recyclerviewpoke?.setBackgroundResource(R.drawable.emptyview)
                            view?.progressbarpoke?.visibility = View.INVISIBLE
                            Log.d("homepoke","cannot retrive sum data")
                        }
                    })
                }
            }else{
                Log.d("homepoke","cannot retrive list data")
            }
        })
    }

    fun pokemonlistsortheight(){
        isloading = true
        view?.progressbarpoke?.visibility = View.VISIBLE

        apiviewmodel.getpokelist(0,10)
        apiviewmodel.pokelistrespon.observe(viewLifecycleOwner, Observer { pokelist ->
            if(pokelist.isSuccessful){
                val data = pokelist.body()?.results
                for(i in 0 until data!!.size){
                    val nama = data[i].name
                    apiviewmodel.getpokesum(nama)

                    apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { sumrespon ->
                        if (sumrespon.isSuccessful){

                            val sum = Pokemonlist(
                                sumrespon.body()?.name.toString(),
                                sumrespon.body()?.sprites!!.other.officialArtwork.frontDefault,
                                sumrespon.body()?.height.toString(),
                                sumrespon.body()?.weight.toString(),
                                sumrespon.body()?.stats?.get(0)?.baseStat.toString(), //hp
                                sumrespon.body()?.stats?.get(1)?.baseStat.toString(), //atk
                                sumrespon.body()?.stats?.get(5)?.baseStat.toString(), //spd
                            )

                            sumrespon.body()?.stats?.get(0)?.baseStat //hp
                            sumrespon.body()?.stats?.get(1)?.baseStat //atk
                            sumrespon.body()?.stats?.get(5)?.baseStat //spd

                            arrayList.add(sum)
                            adapter.setdata(arrayList.sortedBy { it.tinggi })
                            view?.progressbarpoke?.visibility = View.INVISIBLE

                        }else{
                            view?.recyclerviewpoke?.setPadding(10,20,10,20)
                            view?.recyclerviewpoke?.setBackgroundResource(R.drawable.emptyview)
                            view?.progressbarpoke?.visibility = View.INVISIBLE
                            Log.d("homepoke","cannot retrive sum data")
                        }
                    })
                }
            }else{
                Log.d("homepoke","cannot retrive list data")
            }
        })
    }

    fun pokemonlistsortwidth(){
        isloading = true
        view?.progressbarpoke?.visibility = View.VISIBLE

        apiviewmodel.getpokelist(0,10)
        apiviewmodel.pokelistrespon.observe(viewLifecycleOwner, Observer { pokelist ->
            if(pokelist.isSuccessful){
                val data = pokelist.body()?.results
                for(i in 0 until data!!.size){
                    val nama = data[i].name
                    apiviewmodel.getpokesum(nama)

                    apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { sumrespon ->
                        if (sumrespon.isSuccessful){

                            val sum = Pokemonlist(
                                sumrespon.body()?.name.toString(),
                                sumrespon.body()?.sprites!!.other.officialArtwork.frontDefault,
                                sumrespon.body()?.height.toString(),
                                sumrespon.body()?.weight.toString(),
                                sumrespon.body()?.stats?.get(0)?.baseStat.toString(), //hp
                                sumrespon.body()?.stats?.get(1)?.baseStat.toString(), //atk
                                sumrespon.body()?.stats?.get(5)?.baseStat.toString(), //spd
                            )

                            sumrespon.body()?.stats?.get(0)?.baseStat //hp
                            sumrespon.body()?.stats?.get(1)?.baseStat //atk
                            sumrespon.body()?.stats?.get(5)?.baseStat //spd

                            arrayList.add(sum)
                            adapter.setdata(arrayList.sortedBy { it.berat })
                            view?.progressbarpoke?.visibility = View.INVISIBLE

                        }else{
                            view?.recyclerviewpoke?.setPadding(10,20,10,20)
                            view?.recyclerviewpoke?.setBackgroundResource(R.drawable.emptyview)
                            view?.progressbarpoke?.visibility = View.INVISIBLE
                            Log.d("homepoke","cannot retrive sum data")
                        }
                    })
                }
            }else{
                Log.d("homepoke","cannot retrive list data")
            }
        })
    }

    fun pokemonlistsorthp(){
        isloading = true
        view?.progressbarpoke?.visibility = View.VISIBLE

        apiviewmodel.getpokelist(0,10)
        apiviewmodel.pokelistrespon.observe(viewLifecycleOwner, Observer { pokelist ->
            if(pokelist.isSuccessful){
                val data = pokelist.body()?.results
                for(i in 0 until data!!.size){
                    val nama = data[i].name
                    apiviewmodel.getpokesum(nama)

                    apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { sumrespon ->
                        if (sumrespon.isSuccessful){

                            val sum = Pokemonlist(
                                sumrespon.body()?.name.toString(),
                                sumrespon.body()?.sprites!!.other.officialArtwork.frontDefault,
                                sumrespon.body()?.height.toString(),
                                sumrespon.body()?.weight.toString(),
                                sumrespon.body()?.stats?.get(0)?.baseStat.toString(), //hp
                                sumrespon.body()?.stats?.get(1)?.baseStat.toString(), //atk
                                sumrespon.body()?.stats?.get(5)?.baseStat.toString(), //spd
                            )

                            sumrespon.body()?.stats?.get(0)?.baseStat //hp
                            sumrespon.body()?.stats?.get(1)?.baseStat //atk
                            sumrespon.body()?.stats?.get(5)?.baseStat //spd

                            arrayList.add(sum)
                            adapter.setdata(arrayList.sortedBy { it.hp })
                            view?.progressbarpoke?.visibility = View.INVISIBLE

                        }else{
                            view?.recyclerviewpoke?.setPadding(10,20,10,20)
                            view?.recyclerviewpoke?.setBackgroundResource(R.drawable.emptyview)
                            view?.progressbarpoke?.visibility = View.INVISIBLE
                            Log.d("homepoke","cannot retrive sum data")
                        }
                    })
                }
            }else{
                Log.d("homepoke","cannot retrive list data")
            }
        })
    }

    fun pokemonlistsortspeed(){
        isloading = true
        view?.progressbarpoke?.visibility = View.VISIBLE

        apiviewmodel.getpokelist(0,10)
        apiviewmodel.pokelistrespon.observe(viewLifecycleOwner, Observer { pokelist ->
            if(pokelist.isSuccessful){
                val data = pokelist.body()?.results
                for(i in 0 until data!!.size){
                    val nama = data[i].name
                    apiviewmodel.getpokesum(nama)

                    apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { sumrespon ->
                        if (sumrespon.isSuccessful){

                            val sum = Pokemonlist(
                                sumrespon.body()?.name.toString(),
                                sumrespon.body()?.sprites!!.other.officialArtwork.frontDefault,
                                sumrespon.body()?.height.toString(),
                                sumrespon.body()?.weight.toString(),
                                sumrespon.body()?.stats?.get(0)?.baseStat.toString(), //hp
                                sumrespon.body()?.stats?.get(1)?.baseStat.toString(), //atk
                                sumrespon.body()?.stats?.get(5)?.baseStat.toString(), //spd
                            )

                            sumrespon.body()?.stats?.get(0)?.baseStat //hp
                            sumrespon.body()?.stats?.get(1)?.baseStat //atk
                            sumrespon.body()?.stats?.get(5)?.baseStat //spd

                            arrayList.add(sum)
                            adapter.setdata(arrayList.sortedBy { it.speed })
                            view?.progressbarpoke?.visibility = View.INVISIBLE

                        }else{
                            view?.recyclerviewpoke?.setPadding(10,20,10,20)
                            view?.recyclerviewpoke?.setBackgroundResource(R.drawable.emptyview)
                            view?.progressbarpoke?.visibility = View.INVISIBLE
                            Log.d("homepoke","cannot retrive sum data")
                        }
                    })
                }
            }else{
                Log.d("homepoke","cannot retrive list data")
            }
        })
    }

    fun pokemonlistsortatak(){
        isloading = true
        view?.progressbarpoke?.visibility = View.VISIBLE

        apiviewmodel.getpokelist(0,10)
        apiviewmodel.pokelistrespon.observe(viewLifecycleOwner, Observer { pokelist ->
            if(pokelist.isSuccessful){
                val data = pokelist.body()?.results
                for(i in 0 until data!!.size){
                    val nama = data[i].name
                    apiviewmodel.getpokesum(nama)

                    apiviewmodel.pokesumrespon.observe(viewLifecycleOwner, Observer { sumrespon ->
                        if (sumrespon.isSuccessful){

                            val sum = Pokemonlist(
                                sumrespon.body()?.name.toString(),
                                sumrespon.body()?.sprites!!.other.officialArtwork.frontDefault,
                                sumrespon.body()?.height.toString(),
                                sumrespon.body()?.weight.toString(),
                                sumrespon.body()?.stats?.get(0)?.baseStat.toString(), //hp
                                sumrespon.body()?.stats?.get(1)?.baseStat.toString(), //atk
                                sumrespon.body()?.stats?.get(5)?.baseStat.toString(), //spd
                            )

                            sumrespon.body()?.stats?.get(0)?.baseStat //hp
                            sumrespon.body()?.stats?.get(1)?.baseStat //atk
                            sumrespon.body()?.stats?.get(5)?.baseStat //spd

                            arrayList.add(sum)
                            adapter.setdata(arrayList.sortedBy { it.attack })
                            view?.progressbarpoke?.visibility = View.INVISIBLE

                        }else{
                            view?.recyclerviewpoke?.setPadding(10,20,10,20)
                            view?.recyclerviewpoke?.setBackgroundResource(R.drawable.emptyview)
                            view?.progressbarpoke?.visibility = View.INVISIBLE
                            Log.d("homepoke","cannot retrive sum data")
                        }
                    })
                }
            }else{
                Log.d("homepoke","cannot retrive list data")
            }
        })
    }

}