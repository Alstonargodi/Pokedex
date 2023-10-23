package com.example.ceritaku_compose.presentasion.detailpokemon

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ceritaku_compose.R
import com.example.ceritaku_compose.presentasion.detailpokemon.typeslist.TypeList
import com.example.ceritaku_compose.presentasion.home.component.ImageView
import com.example.ceritaku_compose.presentasion.home.component.ProgreesBar
import com.example.ceritaku_compose.presentasion.home.theme.CeritakucomposeTheme
import com.example.ceritaku_compose.presentasion.home.viewmodel.HomeActivityViewModel
import com.example.ceritaku_compose.presentasion.mainactivity.MainActivityApp
import com.example.ceritaku_compose.presentasion.viewmodelfactory.ViewModelFactory
import com.example.ceritaku_compose.remote.response.PokemonListResult
import com.example.ceritaku_compose.remote.response.SummaryPokemonRespon
import com.example.ceritaku_compose.remote.response.Type
import com.example.ceritaku_compose.remote.response.TypeX
import com.example.ceritaku_compose.remote.utils.FetchRespon
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
                imageUrl = "",
                types = detail.data.types,
                name = detail.data.name,
            )
        }
        is FetchRespon.Error ->{
            Log.d("detail","error")
        }
    }
}

@Composable
fun SummaryDetail(
    imageUrl : String,
    types : List<Type>,
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
                .fillMaxSize()
                .background(color = Color(0xFFFFFFFF)),
            contentAlignment =  Alignment.TopCenter,
        ){
            Image(
                painter = painterResource(id = R.drawable.ball),
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .width(133.dp)
                    .height(141.dp)
            )
            val colors = listOf("Red", "Green", "Blue")
            colors[2]

            //card detail
            Card(
                modifier = Modifier
                    .padding(top = 200.dp)
                    .width(346.dp)
                    .height(55.dp)
                    .background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(size = 5.dp))
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .width(346.dp)
                        .height(55.dp)
                        .background(
                            color = Color(0xFFD9D9D9),
                            shape = RoundedCornerShape(size = 5.dp)
                        )
                        .padding(start = 3.dp, top = 1.dp, end = 4.dp, bottom = 2.dp)
                ) {
                    BoxText()
                    Image(
                        painter = painterResource(id = R.drawable.line),
                        contentDescription = "image description",
                        contentScale = ContentScale.None,
                        modifier = Modifier
                            .padding(1.dp)
                            .width(2.dp)
                            .height(52.dp)
                            .background(color = Color(0xFFFFFFFF))
                    )
                    BoxText()
                    Image(
                        painter = painterResource(id = R.drawable.line),
                        contentDescription = "image description",
                        contentScale = ContentScale.None,
                        modifier = Modifier
                            .padding(1.dp)
                            .width(2.dp)
                            .height(52.dp)
                            .background(color = Color(0xFFFFFFFF))
                    )
                    BoxText()
                }
            }

            //types list
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp,Alignment.CenterVertically),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(top = 300.dp)
                    .width(344.dp)
                    .height(120.dp)
                    .background(color = Color(0xFFDBCFCF))
            ) {
                Text(
                    text = "Weight",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppinsregular)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                )
                TypeList(
                    typeList = types,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxSize()
                )
            }

            // progress bar
            LinearProgressBar()
        }
    }
}

@Composable
fun LinearProgressBar(){
    Column(
        verticalArrangement = Arrangement.spacedBy(25.dp,Alignment.CenterVertically),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(top = 300.dp)
            .width(344.dp)
            .height(120.dp)
            .background(color = Color(0xFFDBCFCF))
    ){
        Text(
            text = "Base stat",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppinsregular)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )

        Row(
            modifier = Modifier
                .width(344.dp)
                .height(15.dp)
                .background(color = Color(0xFFC99B9B))
        ){
            Text(
                text = "TEST",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.poppinsregular)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                ),
                modifier = Modifier
                    .width(43.dp)
                    .height(15.dp)
            )
            LinearProgressIndicator(
                    modifier =Modifier
                        .padding(1.dp)
                        .width(249.dp)
                        .height(15.dp)
                        .background(color = Color(0xFFFFFFFF)),
                    progress = 0.5F
            )
            Text(
                text = "TEST",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.poppinsregular)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                ),
                modifier = Modifier
                    .width(43.dp)
                    .height(15.dp)
            )
        }




    }
}

suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}

@Composable
fun BoxText(){
    Column(
        verticalArrangement = Arrangement.spacedBy(11.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(106.dp)
            .height(52.dp)
            .background(color = Color(0xFFFFFFFF))
    ) {
        // Child views.
        Text(
            text = "00",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppinsregular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .width(106.dp)
                .height(19.dp)
        )
        Text(
            text = "Weight",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppinsregular)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,

            ),
            modifier = Modifier
                .width(106.dp)
                .height(22.dp)

        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview(
    viewModel : HomeActivityViewModel = viewModel(
        factory = ViewModelFactory.getInstance()
    )
) {
    CeritakucomposeTheme {
        SummaryDetail(
            imageUrl = "",
            types = listOf(Type(1, TypeX("a","a"))),
            name =""
        )
    }
}