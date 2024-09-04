package com.example.rickandmortycleanarchitecture.domain.repo

import com.example.rickandmortycleanarchitecture.data.remote.dto.Charecters

interface CharecterRepo{

    suspend fun getCharecters():Charecters
}