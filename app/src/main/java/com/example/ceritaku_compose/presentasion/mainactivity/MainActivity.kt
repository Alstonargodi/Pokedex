package com.example.ceritaku_compose.presentasion.mainactivity

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ceritaku_compose.R
import com.example.ceritaku_compose.injection.Injection
import com.example.ceritaku_compose.presentasion.mainactivity.component.Header
import com.example.ceritaku_compose.presentasion.mainactivity.component.SearchBar
import com.example.ceritaku_compose.presentasion.mainactivity.list.PokedexListItem
import com.example.ceritaku_compose.presentasion.mainactivity.theme.CeritakucomposeTheme
import com.example.ceritaku_compose.presentasion.viewmodelfactory.ViewModelFactory
import com.example.ceritaku_compose.remote.response.ListPokemonRespon
import com.example.ceritaku_compose.remote.response.PokemonListResult
import com.example.ceritaku_compose.remote.utils.FetchRespon
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel : MainActivityViewModel by viewModels{
        ViewModelFactory.getInstance()
    }
    private var pokemonList : ListPokemonRespon? = null

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = getColor(R.color.orange)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR


        setContent {
            CeritakucomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainActivityApp()
                }

            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFF121212))
            .wrapContentSize(Alignment.Center),
    ) {
        Text(
            text = "Main",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 60.sp,
            fontStyle = FontStyle(R.font.poppinsregular)
        )
    }
}

@Composable
fun CharacterList(
    modifier: Modifier = Modifier,
    pokemonList : List<PokemonListResult>
) {
    Box(modifier = modifier) {
        LazyColumn {
            items(pokemonList.size) { data ->
                PokedexListItem(
                    name = pokemonList[data].name,
                    photoUrl = pokemonList[data].url
                )
            }
        }
    }
}

@Composable
fun MainActivityApp(
    viewModel : MainActivityViewModel = viewModel(
        factory = ViewModelFactory.getInstance()
    )
) {
    var valueVisible by remember { mutableStateOf(false) }
    var pokemonList by remember { viewModel.pokemonList }
    Column {
        Header(
            showSearch = { valueVisible = it }
        )
        SearchBar(isShow = valueVisible)

        CharacterList(pokemonList = pokemonList )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    CeritakucomposeTheme {

    }
}
