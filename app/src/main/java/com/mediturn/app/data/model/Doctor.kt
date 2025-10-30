package com.mediturn.app.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import androidx.versionedparcelable.ParcelField

@Parcelize
@Entity(tableName = "doctors")
data class Doctor(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "nombre")
    val nombre: String,

    @ColumnInfo(name = "especialidad")
    val especialidad: String,

    @ColumnInfo(name = "experiencia")
    val experiencia: Int,

    @ColumnInfo(name = "precio")
    val precio: Double,

    @ColumnInfo(name = "horario")
    val horario: String,

    @ColumnInfo(name = "disponible")
    val disponible: Boolean = true
) : Parcelable
