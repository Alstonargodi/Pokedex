package com.example.ceritaku_compose.presentasion.detailpokemon

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
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
    val page = (data.toInt() + 1).toString()
    val detail = produceState<FetchRespon<SummaryPokemonRespon>>(initialValue = FetchRespon.Loading){
        value = viewModel.getPokemonSummary(name = page)
    }.value
    when(detail){
        is FetchRespon.Loading ->{
            Log.d("detail","loading")
            ProgreesBar(isShow = true)
        }
        is FetchRespon.Sucess ->{
            ProgreesBar(isShow = false)
            SummaryDetail(
                page,
            )
            Log.d("detail",detail.data.name)
        }
        is FetchRespon.Error ->{
            Log.d("detail","error")
        }
    }
}

@Composable
fun SummaryDetail(
    name : String,
){
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        HeaderDetail()
        Text(text = name)
        Box(
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxSize(),
            contentAlignment =  Alignment.TopCenter,
        ){
            ImageView(
                photoUrl = name,
                modifier = Modifier
                    .padding(8.dp)
                    .size(200.dp)
            )
            Card(
                modifier = Modifier
                    .zIndex(-1f)
                    .padding(top = 170.dp)
                    .background(Color.LightGray),
                shape = RoundedCornerShape(30.dp)
            ) {
                Column() {
                    Text(
                        text = "ability",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 35.dp),
                        color = Color.Black
                    )
                }
            }
        }
    }
}