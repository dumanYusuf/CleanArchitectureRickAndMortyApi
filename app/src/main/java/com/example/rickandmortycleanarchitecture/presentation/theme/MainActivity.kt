package com.example.rickandmortycleanarchitecture.presentation.theme

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmortycleanarchitecture.domain.model.ResultCharecterModel
import com.example.rickandmortycleanarchitecture.presentation.theme.charecter.views.CharecterScreen
import com.example.rickandmortycleanarchitecture.presentation.theme.charecterDetail.views.CharecterDetailScreen
import com.example.rickandmortycleanarchitecture.presentation.theme.ui.RickAndMortyCleanArchitectureTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLDecoder


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyCleanArchitectureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    //CharecterScreen()
                   ControlerNav()
                }
            }
        }
    }
}


@Composable
fun ControlerNav() {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CharecterScreen.route) {
       composable(Screen.CharecterScreen.route){
           CharecterScreen(navController = navController)
       }
        composable(Screen.CharecterDetailScreen.route+"/{charecter}",
            arguments = listOf(
                navArgument("charecter"){type=NavType.StringType}
            )
        ){
            val jsonMovie = it.arguments?.getString("charecter")
            val decodedJsonMovie = URLDecoder.decode(jsonMovie, "UTF-8")
            val charecter = Gson().fromJson(decodedJsonMovie, ResultCharecterModel::class.java)
            CharecterDetailScreen(charecter)
        }
    }
}




