package com.mediturn.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mediturn.app.ui.components.DoctorCard
import com.mediturn.app.data.repository.DataRepository
import androidx.compose.material.icons.automirrored.filled.ArrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorsScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }

    // Cargar doctores desde el repositorio
    val doctoresFiltrados = remember(searchQuery) {
        if (searchQuery.isEmpty()) DataRepository.doctores
        else DataRepository.buscarDoctores(searchQuery)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Buscar Médicos", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF007AFF)
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Barra de búsqueda
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Buscar por nombre o especialidad") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color(0xFF007AFF),
                    unfocusedBorderColor = Color(0xFFB0B0B0)
                )
            )

            Spacer(Modifier.height(12.dp))

            // Lista de doctores
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(doctoresFiltrados) { doctor ->
                    DoctorCard(
                        name = doctor.nombre,
                        specialty = doctor.especialidad,
                        schedule = doctor.horario,
                        price = "S/${doctor.precio}",
                        onClick = { navController.navigate("detail") }
                    )
                }
            }
        }
    }
}
