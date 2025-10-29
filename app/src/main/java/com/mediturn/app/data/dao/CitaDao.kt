package com.mediturn.app.data.dao

import androidx.room.*
import com.mediturn.app.data.model.Cita
import kotlinx.coroutines.flow.Flow

@Dao
interface CitaDao {

    @Query("SELECT * FROM citas ORDER BY fecha, hora")
    fun getAllCitas(): Flow<List<Cita>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCita(cita: Cita)

    @Update
    suspend fun updateCita(cita: Cita)

    @Delete
    suspend fun deleteCita(cita: Cita)
}
