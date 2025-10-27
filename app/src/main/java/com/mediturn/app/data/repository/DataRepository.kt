package com.mediturn.app.data.repository

import com.mediturn.app.data.model.*

object DataRepository {

    // Lista simulada de doctores
    val doctores = listOf(
        Doctor(1, "Dr. Carlos Mendoza", "Cardiología", 12, 150.0, "Hoy 3:00 PM"),
        Doctor(2, "Dra. María González", "Pediatría", 8, 120.0, "Lun 10:00 AM"),
        Doctor(3, "Dr. Jorge Ramírez", "Neurología", 15, 200.0, "Mar 9:30 AM"),
        Doctor(4, "Dra. Ana Torres", "Medicina General", 10, 100.0, "Mié 4:00 PM"),
        Doctor(5, "Dr. Luis Vargas", "Cardiología", 9, 130.0, "Hoy 5:00 PM")
    )

    // Lista simulada de pacientes
    val pacientes = listOf(
        Patient(1, "Diego Olortegui", 20, "Masculino"),
        Patient(2, "Nicole Flores", 21, "Femenino")
    )

    // Slots disponibles
    val slots = listOf(
        Slot(1, "2025-10-26", "10:00 AM", true),
        Slot(2, "2025-10-26", "3:00 PM", true),
        Slot(3, "2025-10-27", "11:30 AM", false)
    )

    // Citas simuladas
    val citas = listOf(
        Appointment(
            id = 1,
            doctor = doctores[0],
            paciente = pacientes[0],
            slot = slots[1],
            tipo = "Teleconsulta"
        ),
        Appointment(
            id = 2,
            doctor = doctores[1],
            paciente = pacientes[0],
            slot = slots[0],
            tipo = "Presencial"
        )
    )

    // Función para filtrar doctores por nombre o especialidad
    fun buscarDoctores(query: String): List<Doctor> {
        return doctores.filter {
            it.nombre.contains(query, ignoreCase = true) ||
                    it.especialidad.contains(query, ignoreCase = true)
        }
    }


    // Función para simular reservar cita
    fun reservarCita(doctorId: Int, pacienteId: Int, slotId: Int, tipo: String): Appointment {
        val doctor = doctores.first { it.id == doctorId }
        val paciente = pacientes.first { it.id == pacienteId }
        val slot = slots.first { it.id == slotId }
        return Appointment(citas.size + 1, doctor, paciente, slot, tipo)
    }
}
