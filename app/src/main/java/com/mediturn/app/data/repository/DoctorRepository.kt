package com.mediturn.app.data.repository

import com.mediturn.app.data.model.Doctor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DoctorRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://127.0.0.1:8000/api/doctores/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    suspend fun getDoctores(): List<Doctor>{
        return apiService.getDoctores()
    }
}