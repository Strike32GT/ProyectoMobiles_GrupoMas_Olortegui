package com.mediturn.app.data.model

data class Doctor(
    val id: Int,
    val nombre: String,
    val especialidad: String,
    val experiencia: Int,
    val precio: Double,
    val horario: String,
    val disponible: Boolean = true
)
