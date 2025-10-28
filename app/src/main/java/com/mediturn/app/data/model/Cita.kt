package com.mediturn.app.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "citas")
data class Cita(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,

    @ColumnInfo(name = "doctor")
    val doctor: String,

    @ColumnInfo(name = "especialidad")
    val especialidad: String,

    @ColumnInfo(name = "fecha")
    val fecha: String,

    @ColumnInfo(name = "hora")
    val hora: String,

    @ColumnInfo(name = "tipo")
    val tipo: String
)