package com.example.rickandmortycleanarchitecture.data.repo

import com.example.rickandmortycleanarchitecture.data.remote.CharecterApi
import com.example.rickandmortycleanarchitecture.data.remote.dto.Charecters
import com.example.rickandmortycleanarchitecture.domain.repo.CharecterRepo
import javax.inject.Inject
import javax.inject.Singleton

class CharecterRepoImp @Inject constructor(private val api:CharecterApi):CharecterRepo {
    override suspend fun getCharecters(): Charecters {
        return api.getCharecter()
    }
}