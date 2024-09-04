package com.example.rickandmortycleanarchitecture.presentation.theme.charecter

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycleanarchitecture.domain.use_case.getCharecterUseCase.GetCharecterUseCase
import com.example.rickandmortycleanarchitecture.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class GetCharecterViewModel  @Inject constructor(private val useCase:GetCharecterUseCase):ViewModel(){


    private val _state= mutableStateOf<GetCharecterState>(GetCharecterState())
    val state: State<GetCharecterState> =_state

    private var job:Job ?=null

    init {
        carecterGet()
    }

    private fun carecterGet(){
        job?.cancel()
       job=useCase.getCharectersResource().onEach {
            when(it){
                is Resource.Success->{
                    _state.value= GetCharecterState(charecterList = it.data ?: emptyList())
                    Log.e("data sucssess","${it.data}")
                }
                is Resource.Error->{
                    _state.value= GetCharecterState(error = it.message ?:"")
                    Log.e("data erroe","${it.message}")
                }
                is Resource.Loading->{
                    _state.value= GetCharecterState(isLoading = true)
                    Log.e("data erroe","loading")
                }
            }
        }.launchIn(viewModelScope)
    }
}