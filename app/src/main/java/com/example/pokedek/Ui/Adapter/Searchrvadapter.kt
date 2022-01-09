package com.example.pokedek.Ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedek.Model.Room.Entity.Pokemonlist
import com.example.pokedek.R
import java.util.*
import kotlin.collections.ArrayList

class Searchrvadapter: RecyclerView.Adapter<Searchrvadapter.viewholder>() {
    val datalist = ArrayList<String>()
    var charpokelist = ArrayList<String>()

    class viewholder(view : View): RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cvrec_search,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = datalist[position]
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun getFilter(): Filter{
        return object : Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                var char = p0.toString()
                if (char.isEmpty()){
                    charpokelist = datalist
                }else{
                    val resultlist = ArrayList<String>()
                    for (row in datalist){
                        if (row.lowercase(Locale.ROOT).contains(char.lowercase(Locale.ROOT))){
                            resultlist.add(row)
                        }
                    }
                    charpokelist = resultlist
                }
                val filterresult = FilterResults()
                filterresult.values = charpokelist
                return filterresult
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                charpokelist = p1?.values as ArrayList<String>
                notifyDataSetChanged()
            }

        }
    }

}