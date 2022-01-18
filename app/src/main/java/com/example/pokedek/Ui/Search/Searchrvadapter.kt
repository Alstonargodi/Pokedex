package com.example.pokedek.Ui.Search

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedek.R
import com.example.pokedek.databinding.CvrecSearchBinding
import kotlinx.android.synthetic.main.cvrec_search.view.*
import java.util.*
import kotlin.collections.ArrayList

class Searchrvadapter(private var datalist : ArrayList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(),Filterable {

    var arrList = ArrayList<String>()
    lateinit var mContext: Context

    class RecHolder(var viewBinding: CvrecSearchBinding) : RecyclerView.ViewHolder(viewBinding.root)
    init {
        arrList = datalist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CvrecSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val sch = RecHolder(binding)
        mContext = parent.context
        return sch
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val countryHolder = holder as RecHolder
        countryHolder.viewBinding.tvListsearch.text = arrList[position]

        holder.viewBinding.tvListsearch.setOnClickListener {
            val name = arrList[position]

            if (name.contains("pokemon")){
                val filname = name.replace("pokemon","").filter { !it.isWhitespace() }
                holder.itemView.findNavController().navigate(SearchfragmentDirections.actionSearchfragmentToPokemondetailfragment(filname))

            }else if (name.contains("-berry")){
                val filname = name
                holder.itemView.findNavController().navigate(SearchfragmentDirections.actionSearchfragmentToBerrydetailfragment(filname))
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                var charsearch = p0.toString()
                if (charsearch.isEmpty()){
                    arrList = datalist
                }else{
                    val resultlist = ArrayList<String>()
                    for (row in datalist){
                        if (row.lowercase(Locale.ROOT).contains(charsearch.lowercase(Locale.ROOT))){
                            resultlist.add(row)
                        }
                    }
                    arrList = resultlist
                }
                val filterresult = FilterResults()
                filterresult.values = arrList
                return filterresult
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                arrList = p1?.values as ArrayList<String>
                notifyDataSetChanged()
            }

        }
    }


}