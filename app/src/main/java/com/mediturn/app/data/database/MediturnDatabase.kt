package com.mediturn.app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mediturn.app.data.dao.CitaDao
import com.mediturn.app.data.dao.DoctorDao
import com.mediturn.app.data.dao.PatientDao
import com.mediturn.app.data.model.Appointment
import com.mediturn.app.data.model.Cita
import com.mediturn.app.data.model.Doctor
import com.mediturn.app.data.model.Patient
import com.mediturn.app.data.model.Slot

@Database(entities = [Doctor::class, Patient::class, Appointment::class, Slot::class, Cita::class], version = 1)
abstract class MediturnDatabase : RoomDatabase(){
    abstract fun doctorDao(): DoctorDao
    abstract fun patientDao(): PatientDao
    abstract fun citaDao(): CitaDao

    companion object{
        @Volatile private var INSTANCE: MediturnDatabase?=null

        fun getDataBase(context: Context): MediturnDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MediturnDatabase::class.java,
                    "mediturn_database"
                )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}