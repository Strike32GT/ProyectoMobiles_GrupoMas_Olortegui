package com.mediturn.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediturn.app.data.model.Cita
import com.mediturn.app.data.repository.CitaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CitaViewModel : ViewModel(){

    private val repository = CitaRepository()

    private val _citas= MutableStateFlow<List<Cita>>(emptyList())
    val citas: StateFlow<List<Cita>> get() = _citas

    private val _cargando=MutableStateFlow(false)
    val cargando: StateFlow<Boolean> get() = _cargando

    fun loadCitas() {
        viewModelScope.launch {
            _cargando.value=true
            try {
                _citas.value=repository.getCitas()
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _cargando.value=false
            }
        }
    }
}