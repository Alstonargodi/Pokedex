package com.example.pokedek.Ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedek.Model.Room.Entity.Pokemonlist
import com.example.pokedek.R
import kotlinx.android.synthetic.main.cv_pokemon.view.*

class Pokemonrvadapter : RecyclerView.Adapter<Pokemonrvadapter.viewholder>() {
    var datalist = emptyList<Pokemonlist>()

    class viewholder(view : View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cv_pokemon,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = datalist[position]
        holder.itemView.tvpokemon_name.text = item.nama
        holder.itemView.tvpokemon_height.text = item.tinggi
        holder.itemView.tvpokemon_width.text = item.berat

    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun setdata(data : List<Pokemonlist>){
        datalist = data
        notifyDataSetChanged()
    }

}