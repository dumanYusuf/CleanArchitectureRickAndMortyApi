package com.example.rickandmortycleanarchitecture.presentation.theme.charecter.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmortycleanarchitecture.presentation.theme.Screen
import com.example.rickandmortycleanarchitecture.presentation.theme.charecter.GetCharecterViewModel
import com.google.gson.Gson
import kotlinx.coroutines.delay
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CharecterScreen(
    viewModel: GetCharecterViewModel= hiltViewModel(),
    navController: NavController
) {
    val state=viewModel.state.value
    val context= LocalContext.current
    
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Rick And Morty")})
        },
        content = {innerPadding->
            LazyVerticalGrid(
                modifier = Modifier.padding(innerPadding),
                columns = GridCells.Fixed(2)) {
                items(viewModel.state.value.charecterList){charecter->
                    Card (modifier = Modifier
                        .padding(10.dp)
                        .size(250.dp)){
                        Image(
                            modifier = Modifier
                                .size(250.dp)
                                .clickable {
                                    val charecterObject = Gson().toJson(charecter)
                                    val encodedMovieObject =
                                        URLEncoder.encode(charecterObject, "UTF-8")
                                    navController.navigate(Screen.CharecterDetailScreen.route + "/$encodedMovieObject")
                                },
                            painter = rememberAsyncImagePainter(
                                model = charecter.image, imageLoader = ImageLoader(context)
                            ), contentDescription = null, contentScale = ContentScale.Crop)
                    }
                }
            }
            if (state.error.isNotBlank()){
                Text(
                    text = state.error,
                    color = Color.Red,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Box (modifier = Modifier.fillMaxSize()){
                if (state.isLoading){
                    CircularProgressIndicator(
                        color = Color.Red, modifier = Modifier.align(alignment = Alignment.Center).size(50.dp)
                    )
                }
            }
        }

    )
}


