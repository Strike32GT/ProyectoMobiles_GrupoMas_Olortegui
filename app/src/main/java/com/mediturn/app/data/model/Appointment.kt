package com.mediturn.app.data.model

data class Appointment(
    val id: Int,
    val doctor: Doctor,
    val paciente: Patient,
    val slot: Slot,
    val tipo: String // Ej: "Teleconsulta" o "Presencial"
)
