package com.example.pokedek.Ui.Search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedek.Model.Room.Entity.Pokemon.Pokemondetail
import com.example.pokedek.R
import kotlin.collections.ArrayList

class Searchrvadapter: RecyclerView.Adapter<Searchrvadapter.viewholder>() {
    var datalist = ArrayList<Pokemondetail>()


    class viewholder(view : View): RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cvrec_search,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = datalist[position]
    }

    override fun getItemCount(): Int {
        return datalist.size
    }



    fun setdata(list : ArrayList<Pokemondetail>){
        datalist = list
        notifyDataSetChanged()
    }

}