package com.example.ceritaku_compose.presentasion.detailpokemon

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ceritaku_compose.presentasion.home.component.ImageView
import com.example.ceritaku_compose.presentasion.home.component.ProgreesBar
import com.example.ceritaku_compose.presentasion.home.viewmodel.HomeActivityViewModel
import com.example.ceritaku_compose.presentasion.viewmodelfactory.ViewModelFactory
import com.example.ceritaku_compose.remote.response.PokemonListResult
import com.example.ceritaku_compose.remote.response.SummaryPokemonRespon
import com.example.ceritaku_compose.remote.utils.FetchRespon

@Composable
fun DetailPokemon(
    viewModel : HomeActivityViewModel = viewModel(
        factory = ViewModelFactory.getInstance()
    ),
    data : String,
){
    Log.d("detail",data)
    val detail = produceState<FetchRespon<SummaryPokemonRespon>>(initialValue = FetchRespon.Loading){
        value = viewModel.getPokemonSummary(name = data)
    }.value
    when(detail){
        is FetchRespon.Loading ->{
            Log.d("detail","loading")
            ProgreesBar(isShow = true)
        }
        is FetchRespon.Sucess ->{
            ProgreesBar(isShow = false)
            SummaryDetail(
                data,
            )
            Log.d("detail","berhasil")
        }
        is FetchRespon.Error ->{
            Log.d("detail","error")
        }
        else -> {

        }
    }
}

@Composable
fun SummaryDetail(
    name : String,
){
    Column {
        HeaderDetail()
        Box{
            ImageView(
                photoUrl = name,
                modifier = Modifier
                    .padding(8.dp)
                    .size(60.dp)
            )
        }
    }
}