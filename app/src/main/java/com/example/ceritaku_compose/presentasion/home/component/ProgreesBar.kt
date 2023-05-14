package com.example.ceritaku_compose.presentasion.home.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ProgreesBar(
    isShow : Boolean
){
    AnimatedVisibility(visible = isShow) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
        )
    }
}