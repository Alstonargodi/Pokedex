package com.example.pokedek.view.pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedek.model.Room.Entity.Pokemon.PokeMoveParcel
import com.example.pokedek.R
import kotlinx.android.synthetic.main.cv_pokemoves.view.*

class Pokemonmovesrvadapter: RecyclerView.Adapter<Pokemonmovesrvadapter.viewholder>() {
    var moveslist = emptyList<PokeMoveParcel>()

    class viewholder(view : View): RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cv_pokemoves,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val pos = moveslist[position]
        holder.itemView.tvcvpokemoves_nama.text = pos.name
        holder.itemView.tvcvpokemoves_effect.text = pos.effect
    }

    override fun getItemCount(): Int {
        return moveslist.size
    }

    fun setdata(list : List<PokeMoveParcel>){
        moveslist = list
        notifyDataSetChanged()
    }

}