package com.example.pokedek.view.pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedek.model.Room.Entity.Pokemon.PokemonSummary
import com.example.pokedek.R
import kotlinx.android.synthetic.main.cv_pokehom.view.*

class PokeHomeRvAdapter: RecyclerView.Adapter<PokeHomeRvAdapter.viewholder>() {

    var datalist = emptyList<PokemonSummary>().distinct()

    class viewholder(view : View): RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cv_pokehom,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = datalist[position]
        holder.itemView.homepoke_name.text = item.name

        Glide.with(holder.itemView.context)
            .asBitmap()
            .load(item.image)
            .into(holder.itemView.homepoke_img)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun setdata(data : List<PokemonSummary>){
        datalist = data.distinct()
        notifyDataSetChanged()
    }
}