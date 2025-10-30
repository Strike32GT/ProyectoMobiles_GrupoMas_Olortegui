package com.mediturn.app.data.repository

import com.mediturn.app.data.dao.PatientDao
import com.mediturn.app.data.model.Patient
import kotlinx.coroutines.flow.Flow

class PatientRepository(private val patientDao: PatientDao) {

    val allPatients: Flow<List<Patient>> = patientDao.getAllPatients()

    suspend fun insert(patient: Patient) {
        patientDao.insertPatient(patient)
    }

    suspend fun update(patient: Patient) {
        patientDao.updatePatient(patient)
    }

    suspend fun delete(patient: Patient) {
        patientDao.deletePatient(patient)
    }

    suspend fun getById(id: Int): Patient? {
        return patientDao.getPatientById(id)
    }
}
