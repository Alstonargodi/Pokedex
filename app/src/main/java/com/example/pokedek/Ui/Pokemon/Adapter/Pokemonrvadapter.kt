package com.example.pokedek.Ui.Pokemon.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedek.Model.Room.Entity.Pokemon.Pokemonlist
import com.example.pokedek.R
import com.example.pokedek.Ui.Pokemon.PokemonfragmentDirections
import kotlinx.android.synthetic.main.cv_pokemon.view.*

class Pokemonrvadapter : RecyclerView.Adapter<Pokemonrvadapter.viewholder>() {
    var datalist = emptyList<Pokemonlist>().distinct()

    class viewholder(view : View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cv_pokemon,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = datalist[position]
        holder.itemView.tvpokemon_name.text = item.nama
        holder.itemView.tvpokemon_height.text = item.tinggi
        holder.itemView.tvpokemon_width.text = item.berat

        Glide.with(holder.itemView.context)
            .asBitmap()
            .load(item.link)
            .into(holder.itemView.imgpokemon_detail)

        holder.itemView.tvpokemon_name.setOnClickListener {
            holder.itemView.findNavController().navigate(PokemonfragmentDirections.actionPokemonToPokemondetailfragment(item.nama))
        }

    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun setdata(data : List<Pokemonlist>){
        datalist = data.distinct()
        notifyDataSetChanged()
    }

}