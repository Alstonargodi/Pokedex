package com.example.pokedek.view.pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedek.R
import com.example.pokedek.databinding.CvPokemonBinding
import com.example.pokedek.model.remote.pokemonreponse.Pokemonsum.Pokesummary
import com.example.pokedek.view.HomeFragmentDirections
import kotlinx.android.synthetic.main.cv_pokemon.view.*

class PokemonRvAdapter(private val dataList : List<Pokesummary>) : RecyclerView.Adapter<PokemonRvAdapter.viewHolder>() {
    private lateinit var onItemClickDetail : OnItemClickDetail

    class viewHolder(var binding : CvPokemonBinding):RecyclerView.ViewHolder(binding.root)

    fun onClickDetail(onClickDetail: OnItemClickDetail){
        this.onItemClickDetail = onClickDetail
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder =
        viewHolder(CvPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = dataList[position]
        holder.itemView.tvpokemon_name.text = item.name
        holder.itemView.tvpokemon_height.text = item.height.toString()
        holder.itemView.tvpokemon_width.text = item.weight.toString()

        Glide.with(holder.itemView.context)
            .asBitmap()
            .load(item.sprites.other.officialArtwork.frontDefault)
            .into(holder.itemView.imgpokemon_detail)

        holder.itemView.tvpokemon_name.setOnClickListener {
//            holder.itemView.findNavController().navigate(HomeFragmentDirections.actionFragmenthomeToPokemondetailfragment(item.name))


            onItemClickDetail.onItemClickDetail(item)
        }

    }

    override fun getItemCount(): Int = dataList.size


    interface OnItemClickDetail{
        fun onItemClickDetail(data : Pokesummary)
    }



}