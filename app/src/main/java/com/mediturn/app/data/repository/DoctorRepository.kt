package com.mediturn.app.data.repository

import com.mediturn.app.data.dao.DoctorDao
import com.mediturn.app.data.model.Doctor
import kotlinx.coroutines.flow.Flow

class DoctorRepository(private val doctorDao: DoctorDao) {


    fun getAllDoctors(): Flow<List<Doctor>> = doctorDao.getAllDoctors()


    fun searchDoctors(query: String): Flow<List<Doctor>> =
        doctorDao.searchDoctors("%$query%")


    suspend fun insertDoctor(doctor: Doctor) = doctorDao.insertDoctor(doctor)


    suspend fun updateDoctor(doctor: Doctor) = doctorDao.updateDoctor(doctor)


    suspend fun deleteDoctor(doctor: Doctor) = doctorDao.deleteDoctor(doctor)

}
