package com.example.pokedek.Ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedek.Model.Room.Entity.Pokemonlist
import com.example.pokedek.R
import kotlinx.android.synthetic.main.cv_pokehom.view.*

class Rvpokehomadapter: RecyclerView.Adapter<Rvpokehomadapter.viewholder>() {

    var datalist = emptyList<Pokemonlist>()

    class viewholder(view : View): RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cv_pokehom,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = datalist[position]
        holder.itemView.homepoke_name.text = item.nama

        Glide.with(holder.itemView.context)
            .asBitmap()
            .load(item.link)
            .into(holder.itemView.homepoke_img)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun setdata(data : List<Pokemonlist>){
        datalist = data
        notifyDataSetChanged()
    }
}