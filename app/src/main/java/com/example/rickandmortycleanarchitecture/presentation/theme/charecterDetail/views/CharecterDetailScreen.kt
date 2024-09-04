package com.example.rickandmortycleanarchitecture.presentation.theme.charecterDetail.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmortycleanarchitecture.data.remote.dto.ResultCharecter
import com.example.rickandmortycleanarchitecture.domain.model.ResultCharecterModel
import com.example.rickandmortycleanarchitecture.presentation.theme.charecter.GetCharecterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CharecterDetailScreen(charecter:ResultCharecterModel,viewModel:GetCharecterViewModel= hiltViewModel()) {

    val context= LocalContext.current
    val state=viewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = charecter.name)})
        },
        content = {innerPadidng->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadidng)) {
                Card (
                    modifier = Modifier.fillMaxWidth()
                ){
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = rememberAsyncImagePainter(model =charecter.image , imageLoader = ImageLoader(context) ),
                        contentDescription ="" , contentScale = ContentScale.Crop)
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "type: ${charecter.type}", fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "created: ${charecter.created}", fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "gender: ${charecter.gender}", fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "location: ${charecter.location}", fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "species: ${charecter.species}", fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "statues: ${charecter.status}", fontSize = 20.sp)
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