package com.example.pokedek.view.berry.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedek.model.Room.Entity.Berry.Flavourberrylist
import com.example.pokedek.R
import kotlinx.android.synthetic.main.cv_flavourberry.view.*

class BerryFlavourRecviewAdapter: RecyclerView.Adapter<BerryFlavourRecviewAdapter.viewholder>() {

    var flavourlist = emptyList<Flavourberrylist>().distinct()

    class viewholder(view : View): RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BerryFlavourRecviewAdapter.viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cv_flavourberry,parent,false))
    }

    override fun onBindViewHolder(holder: BerryFlavourRecviewAdapter.viewholder, position: Int) {
        val item = flavourlist[position]

        holder.itemView.Berryflavour_name.text = item.name
        holder.itemView.Berryflavour_pot.text = item.potecny
    }

    override fun getItemCount(): Int {
        return flavourlist.size
    }

    fun setdata(list : List<Flavourberrylist>){
        flavourlist = list.distinct()
        notifyDataSetChanged()
    }

}