package com.example.rickandmortycleanarchitecture.data.di

import com.example.rickandmortycleanarchitecture.data.remote.CharecterApi
import com.example.rickandmortycleanarchitecture.data.repo.CharecterRepoImp
import com.example.rickandmortycleanarchitecture.domain.repo.CharecterRepo
import com.example.rickandmortycleanarchitecture.util.Constans
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun providesGetCharecter():CharecterApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constans.BASE_URL)
            .build().create(CharecterApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCharecterRepo(api: CharecterApi): CharecterRepo {
        return CharecterRepoImp(api)
    }

}