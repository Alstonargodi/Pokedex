package com.example.ceritaku_compose.presentasion.detailpokemon

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ceritaku_compose.presentasion.mainactivity.component.ProgreesBar
import com.example.ceritaku_compose.presentasion.mainactivity.viewmodel.MainActivityViewModel
import com.example.ceritaku_compose.presentasion.viewmodelfactory.ViewModelFactory
import com.example.ceritaku_compose.remote.response.SummaryPokemonRespon
import com.example.ceritaku_compose.remote.utils.FetchRespon

@Composable
fun DetailPokemon(
    viewModel : MainActivityViewModel = viewModel(
        factory = ViewModelFactory.getInstance()
    ),
    name : String,
){
    val detail = produceState<FetchRespon<SummaryPokemonRespon>>(initialValue = FetchRespon.Loading){
        value = viewModel.getPokemonSummary(name = name)
    }.value
    when(detail){
        is FetchRespon.Loading ->{
            Log.d("detail","loading")
            ProgreesBar(isShow = true)
        }
        is FetchRespon.Sucess ->{
            ProgreesBar(isShow = false)
            Log.d("detail",detail.data.height.toString())
        }
        is FetchRespon.Error ->{

        }
        else -> {

        }
    }
}