package com.example.pokedek.view.Item.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedek.modedl.Room.Entity.Item.ItemList
import com.example.pokedek.R
import com.example.pokedek.view.Item.ItemDirections
import kotlinx.android.synthetic.main.cv_item.view.*

class Itemrvadapter : RecyclerView.Adapter<Itemrvadapter.viewholder>() {
    var datalist = emptyList<ItemList>().distinct()

    class viewholder(view : View): RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.cv_item,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = datalist[position]

        holder.itemView.tv_item_name.text = item.nama
        holder.itemView.tv_item_type.text = item.type

        Glide.with(holder.itemView.context)
            .load(item.link)
            .into(holder.itemView.item_image)

        holder.itemView.Childlayout.setOnClickListener {
//            holder.itemView.findNavController().navigate(ItemDirections.actionItemToItemdetail(
//                item.nama,
//                item.link,
//                item.effect,
//                item.type
//            ))
        }
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun setdata(add : List<ItemList>){
        datalist = add.distinct()
        notifyDataSetChanged()
    }
}