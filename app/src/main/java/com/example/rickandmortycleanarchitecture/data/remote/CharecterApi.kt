package com.example.rickandmortycleanarchitecture.data.remote

import com.example.rickandmortycleanarchitecture.data.remote.dto.Charecters
import retrofit2.http.GET


interface CharecterApi {

    @GET("api/character?page=1")
    suspend fun getCharecter():Charecters
}