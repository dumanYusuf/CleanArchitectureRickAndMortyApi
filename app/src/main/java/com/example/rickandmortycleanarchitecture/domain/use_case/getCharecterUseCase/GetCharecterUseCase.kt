package com.example.rickandmortycleanarchitecture.domain.use_case.getCharecterUseCase

import android.util.Log
import com.example.rickandmortycleanarchitecture.data.remote.dto.toCharecterList
import com.example.rickandmortycleanarchitecture.domain.model.ResultCharecterModel
import com.example.rickandmortycleanarchitecture.domain.repo.CharecterRepo
import com.example.rickandmortycleanarchitecture.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetCharecterUseCase @Inject constructor(private val repo:CharecterRepo) {


    fun getCharectersResource():Flow<Resource<List<ResultCharecterModel>>> = flow{
        try {
            emit(Resource.Loading())
            val charecterList = repo.getCharecters()

            if (charecterList.results.isNotEmpty()) {
                emit(Resource.Success(charecterList.toCharecterList()))
            } else {
                emit(Resource.Error("Error: Empty results"))
            }
        } catch (e: IOException) {
            emit(Resource.Error("Exception: ${e.localizedMessage}"))
        }

        catch (e:Exception){
            Log.e("useCase","Error Use Case:${e.message}")
        }
    }
}