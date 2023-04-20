package com.example.myapplication4.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter

@Composable
fun picture(shareViewModel:ShareViewModel){
    var wide = shareViewModel.wide.toString()
    var long = shareViewModel.long.toString()
    var type = shareViewModel.type.toString()

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = rememberAsyncImagePainter("https://loremflickr.com/"+wide+"/"+long+"/"+type+"/"),
            contentDescription = type
        )
    }

}