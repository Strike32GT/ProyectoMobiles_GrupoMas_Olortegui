package com.mediturn.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doctors")
data class Doctor(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val especialidad: String,
    val experiencia: Int,
    val precio: Double,
    val horario: String,
    val disponible: Boolean = true
)
