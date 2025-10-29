package com.mediturn.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointments") // Use @Entity to mark it as a database table
data class Appointment(
    @PrimaryKey(autoGenerate = true) // Add a primary key
    val id: Int = 0,
    // ... other fields of your Appointment class
    val doctorName: String,
    val appointmentDate: String,
    // etc.
)
