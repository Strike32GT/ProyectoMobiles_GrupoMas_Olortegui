package com.mediturn.app.data.remote

import com.mediturn.app.data.model.Cita
import com.mediturn.app.data.model.Doctor
import com.mediturn.app.data.model.Patient
import retrofit2.http.GET

interface ApiService{

    @GET("citas/")
    suspend fun getCitas(): List<Cita>

    @GET("doctores/")
    suspend fun getDoctores(): List<Doctor>

    @GET("pacientes")
    suspend fun getPacientes(): List<Patient>
}