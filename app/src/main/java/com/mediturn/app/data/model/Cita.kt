package com.mediturn.app.data.model

data class Cita(
    val id: Int,
    val doctor: String,
    val especialidad: String,
    val fecha: String,
    val hora: String,
    val tipo: String
)