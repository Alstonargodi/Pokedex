package com.example.pokedek.view.fragment.berry.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedek.model.local.entity.Berry.Berrylist
import com.example.pokedek.R
import com.example.pokedek.view.fragment.berry.BerryFragmentDirections
import kotlinx.android.synthetic.main.cv_berry.view.*

class BerryRecviewAdapter: RecyclerView.Adapter<BerryRecviewAdapter.viewholder>() {

    var berrylist = ArrayList<Berrylist>().distinct()

    class viewholder(view : View): RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cv_berry,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = berrylist[position]
        holder.itemView.tvberry_name.text = item.name

        Glide.with(holder.itemView.context)
            .asBitmap()
            .load(item.link)
            .into(holder.itemView.imgberry_list)

        holder.itemView.tvberry_name.setOnClickListener {
            holder.itemView.findNavController().navigate(BerryFragmentDirections.actionBerryfragmentToBerrydetailfragment(item.name))
        }
    }

    override fun getItemCount(): Int {
       return berrylist.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun  setdata(list: ArrayList<Berrylist>){
        berrylist = list.distinct()
        notifyDataSetChanged()
    }


}