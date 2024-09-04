package com.example.rickandmortycleanarchitecture.presentation.theme.charecter

import com.example.rickandmortycleanarchitecture.domain.model.ResultCharecterModel

data class GetCharecterState(
     val isLoading:Boolean=false,
     val charecterList:List<ResultCharecterModel> = emptyList(),
     val error:String="NO Connection"
 )