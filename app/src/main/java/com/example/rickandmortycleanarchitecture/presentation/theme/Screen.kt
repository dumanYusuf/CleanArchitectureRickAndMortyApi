package com.example.rickandmortycleanarchitecture.presentation.theme

sealed class Screen( val route:String) {

    object CharecterScreen: Screen("charecter_screen")
    object CharecterDetailScreen: Screen("charecter_screen_detail")
}