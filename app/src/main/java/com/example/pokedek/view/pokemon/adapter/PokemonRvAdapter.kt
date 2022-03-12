package com.example.pokedek.view.pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedek.modedl.Room.Entity.Pokemon.PokemonSum
import com.example.pokedek.R
import com.example.pokedek.view.pokemon.PokemonFragmentDirections
import kotlinx.android.synthetic.main.cv_pokemon.view.*

class PokemonRvAdapter : RecyclerView.Adapter<PokemonRvAdapter.viewHolder>() {
    private var datalist = emptyList<PokemonSum>().distinct()

    class viewHolder(view : View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cv_pokemon,parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = datalist[position]
        holder.itemView.tvpokemon_name.text = item.name
        holder.itemView.tvpokemon_height.text = item.height
        holder.itemView.tvpokemon_width.text = item.weight

        Glide.with(holder.itemView.context)
            .asBitmap()
            .load(item.image)
            .into(holder.itemView.imgpokemon_detail)

        holder.itemView.tvpokemon_name.setOnClickListener {
            holder.itemView.findNavController().navigate(PokemonFragmentDirections.actionPokemonToPokemondetailfragment(item))
        }

    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun setdata(data : List<PokemonSum>){
        datalist = data.distinct()
        notifyDataSetChanged()
    }

}