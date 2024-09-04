package com.example.rickandmortycleanarchitecture.domain.model

import com.example.rickandmortycleanarchitecture.data.remote.dto.Location
import com.example.rickandmortycleanarchitecture.data.remote.dto.Origin

data class ResultCharecterModel(
    val created: String,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)