package com.mediturn.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediturn.app.data.database.MediturnDatabase
import com.mediturn.app.data.model.Cita
import com.mediturn.app.data.repository.CitaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CitaViewModel (private val repository: CitaRepository): ViewModel(){

    private val _citas= MutableStateFlow<List<Cita>>(emptyList())
    val citas: StateFlow<List<Cita>> get() = _citas

    private val _cargando=MutableStateFlow(false)
    val cargando: StateFlow<Boolean> get() = _cargando

    fun loadCitas() {
        viewModelScope.launch {
            _cargando.value=true
            try {
                _citas.value=repository.getAllCitas()
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _cargando.value=false
            }
        }
    }

    fun agregarCita(doctor: String, especialidad: String, hora: String, tipo: String){
        viewModelScope.launch {
            val fecha = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)
            val nuevaCita = Cita(doctor = doctor, especialidad = especialidad, hora = hora, fecha = fecha, tipo = tipo)
            repository.insertaCita(nuevaCita)
            loadCitas()
        }
    }
}