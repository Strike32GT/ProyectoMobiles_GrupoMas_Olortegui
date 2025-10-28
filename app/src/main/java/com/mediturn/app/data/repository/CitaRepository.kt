package com.mediturn.app.data.repository

import com.mediturn.app.data.dao.CitaDao
import com.mediturn.app.data.model.Cita

class CitaRepository (private val citaDao: CitaDao){

    suspend fun getAllCitas(): List<Cita>{
        return citaDao.getAllCitas()
    }

    suspend fun insertaCita(cita: Cita){
        return citaDao.insertCita(cita)
    }

    suspend fun updateCita(cita: Cita){
        citaDao.updateCita(cita)
    }

    suspend fun deleteCita(cita: Cita){
        citaDao.deleteCita(cita)
    }
}