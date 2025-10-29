package com.mediturn.app.data.repository

import com.mediturn.app.data.dao.CitaDao
import com.mediturn.app.data.model.Cita
import kotlinx.coroutines.flow.Flow

class CitaRepository(private val citaDao: CitaDao) {

    fun getAllCitas(): Flow<List<Cita>> = citaDao.getAllCitas()

    suspend fun insertCita(cita: Cita) = citaDao.insertCita(cita)

    suspend fun updateCita(cita: Cita) = citaDao.updateCita(cita)

    suspend fun deleteCita(cita: Cita) = citaDao.deleteCita(cita)
}
