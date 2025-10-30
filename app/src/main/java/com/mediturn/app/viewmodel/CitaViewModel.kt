package com.mediturn.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediturn.app.data.model.Cita
import com.mediturn.app.data.repository.CitaRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CitaViewModel(private val repository: CitaRepository) : ViewModel() {

    private val _citas = MutableStateFlow<List<Cita>>(emptyList())
    val citas: StateFlow<List<Cita>> = _citas.asStateFlow()

    private val _cargando = MutableStateFlow(false)
    val cargando: StateFlow<Boolean> = _cargando.asStateFlow()

    fun loadCitas() {
        viewModelScope.launch {
            _cargando.value = true
            repository.getAllCitas().collect { lista ->
                _citas.value = lista
                _cargando.value = false
            }
        }
    }

    fun agregarCita(doctor: String, especialidad: String, hora: String, tipo: String, fecha : String = LocalDate.now().format(
        DateTimeFormatter.ISO_LOCAL_DATE)) {
        viewModelScope.launch {
            val nuevaCita = Cita(
                doctor = doctor,
                especialidad = especialidad,
                hora = hora,
                fecha = fecha,
                tipo = tipo
            )
            repository.insertCita(nuevaCita)
        }
    }
}
