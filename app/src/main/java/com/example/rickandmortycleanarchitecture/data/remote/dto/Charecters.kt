package com.example.rickandmortycleanarchitecture.data.remote.dto

import com.example.rickandmortycleanarchitecture.domain.model.ResultCharecterModel


data class Charecters(
    val info: İnfo,
    val results: List<ResultCharecter>
)



fun Charecters.toCharecterList():List<ResultCharecterModel>{
   return results.map {ResultCharecterModel(it.created,it.gender,it.id,it.image,it.location,it.name,it.species,it.type,it.url,it.status)}
}