package com.mediturn.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mediturn.app.data.model.Cita

@Dao
interface CitaDao{

    @Query("SELECT * FROM citas ORDER BY fecha, hora")
    suspend fun getAllCitas(): List<Cita>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCita(cita: Cita)

    @Update
    suspend fun updateCita(cita: Cita)

    @Delete
    suspend fun deleteCita(cita: Cita)
}