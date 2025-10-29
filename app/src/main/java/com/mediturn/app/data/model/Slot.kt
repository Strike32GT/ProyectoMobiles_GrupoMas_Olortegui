package com.mediturn.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "slots") // The tableName is optional but good practice
data class Slot(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val time: String,
    val isAvailable: Boolean

)
