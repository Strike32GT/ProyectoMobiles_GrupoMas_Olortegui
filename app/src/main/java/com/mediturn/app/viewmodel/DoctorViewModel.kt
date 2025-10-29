package com.mediturn.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediturn.app.data.model.Doctor
import com.mediturn.app.data.repository.DoctorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DoctorViewModel(private val repository: DoctorRepository) : ViewModel() {

    private val _doctores = MutableStateFlow<List<Doctor>>(emptyList())
    val doctores: StateFlow<List<Doctor>> get() = _doctores

    private val _cargando = MutableStateFlow(false)
    val cargando: StateFlow<Boolean> get() = _cargando

    /**
     * 🔹 Cargar todos los doctores desde la base de datos (Room)
     */
    fun loadDoctores() {
        viewModelScope.launch {
            _cargando.value = true
            try {
                repository.getAllDoctors().collect { lista ->
                    _doctores.value = lista
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _cargando.value = false
            }
        }
    }

    /**
     * 🔹 Buscar doctores por nombre o especialidad
     */
    fun buscarDoctores(query: String) {
        viewModelScope.launch {
            _cargando.value = true
            try {
                repository.searchDoctors(query).collect { lista ->
                    _doctores.value = lista
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _cargando.value = false
            }
        }
    }

    /**
     * 🔹 Insertar un nuevo doctor (por si luego quieres añadir desde UI o seed inicial)
     */
    fun agregarDoctor(doctor: Doctor) {
        viewModelScope.launch {
            try {
                repository.insertDoctor(doctor)
                loadDoctores()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    /**
     * 🔹 Eliminar doctor
     */
    fun eliminarDoctor(doctor: Doctor) {
        viewModelScope.launch {
            try {
                repository.deleteDoctor(doctor)
                loadDoctores()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
