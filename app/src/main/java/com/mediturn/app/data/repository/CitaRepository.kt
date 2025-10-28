package com.mediturn.app.data.repository

import com.mediturn.app.data.model.Cita
import com.mediturn.app.data.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CitaRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://127.0.0.1:8000/api/citas/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    suspend fun getCitas(): List<Cita>{
        return apiService.getCitas()
    }
}