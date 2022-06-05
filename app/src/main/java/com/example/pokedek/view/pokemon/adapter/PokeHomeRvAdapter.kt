package com.example.pokedek.view.pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedek.R
import com.example.pokedek.model.remote.response.pokemonreponse.Pokemonsum.Pokesummary
import kotlinx.android.synthetic.main.cv_pokehom.view.*

class PokeHomeRvAdapter(private val data : List<Pokesummary>): RecyclerView.Adapter<PokeHomeRvAdapter.viewholder>() {

    class viewholder(view : View): RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cv_pokehom,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = data[position]
        holder.itemView.homepoke_name.text = item.name

        Glide.with(holder.itemView.context)
            .load(item.sprites.other.officialArtwork.frontDefault)
            .into(holder.itemView.homepoke_img)
    }

    override fun getItemCount(): Int = data.size



}