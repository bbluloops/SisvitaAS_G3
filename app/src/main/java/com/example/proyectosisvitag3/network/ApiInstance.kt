package com.example.proyectosisvitag3.ui.theme.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://sisvitag3-prueba.onrender.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInstance by lazy{
        retrofit.create(ApiService::class.java)
    }
}