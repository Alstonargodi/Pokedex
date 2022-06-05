package com.example.pokedek.view.fragment.compare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedek.model.remote.response.itemresponse.itemsummaryresponse.Pokemon
import com.example.pokedek.R

class Listpokeadapter: RecyclerView.Adapter<Listpokeadapter.viewholder>() {

    var datalist = emptyList<Pokemon>()

    class viewholder(view : View):RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cv_pokemon,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return datalist.size
    }


}