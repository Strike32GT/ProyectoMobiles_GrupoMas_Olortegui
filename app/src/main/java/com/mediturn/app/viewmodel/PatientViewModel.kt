package com.mediturn.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediturn.app.data.model.Patient
import com.mediturn.app.data.repository.PatientRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PatientViewModel(private val repository: PatientRepository) : ViewModel() {

    val allPatients: StateFlow<List<Patient>> =
        repository.allPatients.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addPatient(patient: Patient) {
        viewModelScope.launch {
            repository.insert(patient)
        }
    }

    fun updatePatient(patient: Patient) {
        viewModelScope.launch {
            repository.update(patient)
        }
    }

    fun deletePatient(patient: Patient) {
        viewModelScope.launch {
            repository.delete(patient)
        }
    }

    fun getPatientById(id: Int, onResult: (Patient?) -> Unit) {
        viewModelScope.launch {
            val result = repository.getById(id)
            onResult(result)
        }
    }
}
