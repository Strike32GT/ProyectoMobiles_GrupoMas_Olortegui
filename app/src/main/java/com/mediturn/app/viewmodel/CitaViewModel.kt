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

class CitaViewModel (application: Application): AndroidViewModel(application){

    private val repository : CitaRepository

    private val _citas= MutableStateFlow<List<Cita>>(emptyList())
    val citas: StateFlow<List<Cita>> get() = _citas

    private val _cargando=MutableStateFlow(false)
    val cargando: StateFlow<Boolean> get() = _cargando

    init {
        val dao= MediturnDatabase.getDataBase(application).citaDao()
        repository= CitaRepository(dao)
    }
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
}