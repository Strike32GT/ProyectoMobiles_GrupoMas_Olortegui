package com.mediturn.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "patients")
data class Patient(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val edad: Int,
    val genero: String
)
