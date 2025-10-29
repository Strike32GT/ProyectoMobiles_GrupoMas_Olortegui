package com.mediturn.app.data.repository

import com.mediturn.app.data.dao.DoctorDao
import com.mediturn.app.data.model.Doctor
import kotlinx.coroutines.flow.Flow

class DoctorRepository(private val doctorDao: DoctorDao) {

    // 🔹 Obtener todos los doctores (Flow para reactividad)
    fun getAllDoctors(): Flow<List<Doctor>> = doctorDao.getAllDoctors()

    // 🔹 Buscar doctores por nombre o especialidad
    fun searchDoctors(query: String): Flow<List<Doctor>> =
        doctorDao.searchDoctors("%$query%")

    // 🔹 Insertar nuevo doctor
    suspend fun insertDoctor(doctor: Doctor) = doctorDao.insertDoctor(doctor)

    // 🔹 Actualizar información de un doctor
    suspend fun updateDoctor(doctor: Doctor) = doctorDao.updateDoctor(doctor)

    // 🔹 Eliminar un doctor
    suspend fun deleteDoctor(doctor: Doctor) = doctorDao.deleteDoctor(doctor)
}
