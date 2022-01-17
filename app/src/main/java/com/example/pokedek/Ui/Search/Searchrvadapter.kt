package com.example.pokedek.Ui.Search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedek.Model.Room.Entity.Pokemon.Pokemondetail
import com.example.pokedek.Model.Room.Entity.Search.Searchlist
import com.example.pokedek.R
import kotlinx.android.synthetic.main.cvrec_search.view.*
import kotlin.collections.ArrayList

class Searchrvadapter: RecyclerView.Adapter<Searchrvadapter.viewholder>() {
    var datalist = ArrayList<Searchlist>().distinct()


    class viewholder(view : View): RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cvrec_search,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = datalist[position]
        holder.itemView.tv_listsearch.text = item.name
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun setdata(list : ArrayList<Searchlist>){
        datalist = list.distinct()
        notifyDataSetChanged()
    }

}