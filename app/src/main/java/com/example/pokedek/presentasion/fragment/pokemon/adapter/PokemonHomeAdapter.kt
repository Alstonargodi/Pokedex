package com.example.pokedek.presentasion.fragment.pokemon.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedek.databinding.CvPokemonBinding
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListResult
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse

class PokemonHomeAdapter : PagingDataAdapter<PokemonListResult, PokemonHomeAdapter.ViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickDetail : OnItemClickDetail

    fun onClickDetail(onClickDetail: OnItemClickDetail){
        this.onItemClickDetail = onClickDetail
    }

    class ViewHolder(var binding : CvPokemonBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item : PokemonListResult, id : Int){
            binding.tvpokemonName.text = item.name
            Log.d("Pokemon Fragment",item.name)

            val imgUrl =
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png"
            Glide.with(binding.root)
                .asBitmap()
                .load(imgUrl)
                .into(binding.imgpokemonDetail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(CvPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item,position)

            holder.binding.imgpokemonDetail.setOnClickListener {
                onItemClickDetail.onItemClickDetail(item.name)
            }
        }
    }


    interface OnItemClickDetail{
        fun onItemClickDetail(data : String)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PokemonListResult>() {
            override fun areItemsTheSame(oldItem: PokemonListResult, newItem: PokemonListResult): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: PokemonListResult, newItem: PokemonListResult): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }



}