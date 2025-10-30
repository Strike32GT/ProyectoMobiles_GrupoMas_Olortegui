package com.mediturn.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointments")
data class Appointment(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val doctorName: String,
    val appointmentDate: String,
)
