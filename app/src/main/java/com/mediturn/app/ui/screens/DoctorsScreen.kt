package com.mediturn.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mediturn.app.data.database.MediturnDatabase
import com.mediturn.app.data.model.Doctor
import com.mediturn.app.data.repository.DoctorRepository
import com.mediturn.app.ui.components.DoctorCard
import com.mediturn.app.viewmodel.DoctorViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorsScreen(navController: NavController, initialQuery: String? = null) {


    val context = LocalContext.current
    val doctorDao = remember { MediturnDatabase.getDataBase(context).doctorDao() }
    val repository = remember { DoctorRepository(doctorDao) }
    val viewModel = remember { DoctorViewModel(repository) }

    // 🔹 Estado UI
    val doctores by viewModel.doctores.collectAsState()
    val cargando by viewModel.cargando.collectAsState()
    var searchQuery by remember { mutableStateOf(initialQuery ?: "") }

    val coroutineScope = rememberCoroutineScope()

    // 🔹 Cargar lista al iniciar pantalla
    LaunchedEffect(Unit) {
        viewModel.loadDoctores()
        delay(500)

        val listaActual=viewModel.doctores.value

        if(listaActual.isEmpty()){
            viewModel.agregarDoctor(
                Doctor(
                    nombre = "Dr. Carlos Mendoza",
                    especialidad = "Cardiologia",
                    experiencia = 8,
                    horario = "9:00 - 15:00",
                    precio = 150.0
                )
            )

            viewModel.agregarDoctor(
                Doctor(
                    nombre = "Dra. María Gonzales",
                    especialidad = "Pediatria",
                    experiencia = 10,
                    horario = "10:00 - 17:00",
                    precio = 120.0
                )
            )

            viewModel.agregarDoctor(
                Doctor(
                    nombre = "Dr. Jorge Ramirez",
                    especialidad = "Neurologia",
                    experiencia = 10,
                    horario = "10:00 - 17:00",
                    precio = 120.0
                )
            )

            viewModel.agregarDoctor(
                Doctor(
                    nombre = "Dra. Ana Torres",
                    especialidad = "Medicina General",
                    experiencia = 7,
                    horario = "8:00 - 17:00",
                    precio = 120.0
                )
            )

            viewModel.agregarDoctor(
                Doctor(
                    nombre = "Dr. Luis Vargas",
                    especialidad = "Oftalmologia",
                    experiencia = 9,
                    horario = "11:00 - 18:00",
                    precio = 160.0
                )
            )
        }
        if(!searchQuery.isBlank()){
            viewModel.buscarDoctores(searchQuery)
        }
    }

    LaunchedEffect(searchQuery) {
        delay(300)
        if(searchQuery.isBlank()){
            viewModel.loadDoctores()
        }else{
            viewModel.buscarDoctores(searchQuery)
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Buscar Médicos",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF007AFF), Color(0xFF00C6AE))
                    )
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFFF6F9FC))
                .imePadding()
                .navigationBarsPadding()
                .padding(horizontal = 16.dp)
        ) {

            // 🔹 Barra de búsqueda
            OutlinedTextField(
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                },
                label = { Text("Buscar por nombre o especialidad") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color(0xFF007AFF),
                    unfocusedBorderColor = Color(0xFFB0B0B0),
                    cursorColor = Color(0xFF007AFF)
                )
            )

            Spacer(Modifier.height(12.dp))

            // 🔹 Estado de carga o resultados
            when {
                cargando -> {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = Color(0xFF00C6AE))
                    }
                }

                doctores.isEmpty() -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No se encontraron resultados",
                            color = Color.Gray,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                else -> {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        contentPadding = PaddingValues(bottom = 16.dp)
                    ) {
                        items(doctores) { doctor ->
                            DoctorCard(
                                name = doctor.nombre,
                                specialty = doctor.especialidad,
                                schedule = doctor.horario,
                                price = "S/${doctor.precio}",
                                onClick = {
                                    // 🔹 Navegar al detalle del médico
                                    navController.currentBackStackEntry?.savedStateHandle?.set("doctor", doctor)
                                    navController.navigate("detail")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
