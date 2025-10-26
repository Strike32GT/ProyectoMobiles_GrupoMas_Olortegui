package com.mediturn.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mediturn.app.ui.components.DoctorCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorsScreen(navController: NavController) {
    val doctors = listOf(
        "Dr. Carlos Mendoza",
        "Dra. María González",
        "Dr. Jorge Ramírez",
        "Dra. Ana Torres",
        "Dr. Luis Vargas"
    )

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
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(doctors) { doctor ->
                DoctorCard(
                    name = doctor,
                    specialty = "Cardiología",
                    schedule = "Hoy 3:00 PM",
                    price = "S/150",
                    onClick = { navController.navigate("detail") }
                )
            }
        }
    }
}
