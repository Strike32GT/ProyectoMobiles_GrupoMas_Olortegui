package com.mediturn.app.ui.screens

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mediturn.app.R
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp

@SuppressLint("ContextCastToActivity")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun DoctorDetailScreen(navController: NavController) {


    val windowSizeClass = calculateWindowSizeClass(activity = LocalContext.current as ComponentActivity)
    val isCompact = remember { windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact }
    val horizontalPadding = if (isCompact) 20.dp else 80.dp

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Detalle del Médico",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
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
                .verticalScroll(rememberScrollState())
                .background(Color(0xFFF8F9FB))
                .imePadding()
                .navigationBarsPadding()
        ) {
            // 🔷 Encabezado gradiente
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(Color(0xFF007AFF), Color(0xFF00C6AE))
                        )
                    )
            )

            // 🔹 Tarjeta principal del doctor
            Card(
                modifier = Modifier
                    .padding(horizontal = horizontalPadding)
                    .offset(y = (-60).dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.doctor_placeholder),
                        contentDescription = "Foto del doctor",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            "Dr. Carlos Mendoza",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color(0xFF1B1B1B)
                        )
                        Text(
                            "Cardiología",
                            color = Color(0xFF00A88B),
                            fontSize = 14.sp
                        )
                        Spacer(Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("⭐ 4.8 (156)", fontSize = 13.sp, color = Color(0xFF555555))
                            Spacer(Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFFE3F2FD))
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text("Online", fontSize = 12.sp, color = Color(0xFF007AFF))
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.height(10.dp))

            // 🔹 Tarjetas de información general
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InfoCard(icon = R.drawable.ic_experience, title = "Experiencia", value = "15 años")
                InfoCard(icon = R.drawable.ic_location, title = "Hospital", value = "Central")
                InfoCard(icon = R.drawable.ic_language, title = "Idiomas", value = "2")
            }

            Spacer(Modifier.height(16.dp))

            InfoSection(
                title = "Acerca de",
                text = "Cardiólogo especializado en enfermedades del corazón con más de 15 años de experiencia.",
                location = "Hospital Central, Lima",
                languages = "Español, Inglés",
                horizontalPadding = horizontalPadding
            )

            ScheduleSection(horizontalPadding)
            PriceSection(horizontalPadding)

            Spacer(Modifier.height(30.dp))
        }
    }
}

// -----------------------------------------------------------------------------
// COMPONENTES REUTILIZABLES
// -----------------------------------------------------------------------------

@Composable
fun InfoCard(icon: Int, title: String, value: String) {
    Card(
        modifier = Modifier
            .width(110.dp)
            .height(95.dp),
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = title,
                modifier = Modifier.size(30.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(value, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color(0xFF222222))
            Text(title, fontSize = 12.sp, color = Color(0xFF7A7A7A))
        }
    }
}

@Composable
fun InfoSection(title: String, text: String, location: String, languages: String, horizontalPadding: Dp) {
    Card(
        modifier = Modifier
            .padding(horizontal = horizontalPadding)
            .fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF222222))
            Spacer(Modifier.height(8.dp))
            Text(text, fontSize = 14.sp, color = Color(0xFF444444), lineHeight = 20.sp)
            Spacer(Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("📍", fontSize = 14.sp)
                Spacer(Modifier.width(4.dp))
                Text(location, color = Color(0xFF5A5A5A), fontSize = 13.sp)
            }
            Spacer(Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("🌐", fontSize = 14.sp)
                Spacer(Modifier.width(4.dp))
                Text(languages, color = Color(0xFF5A5A5A), fontSize = 13.sp)
            }
        }
    }
}

@Composable
fun ScheduleSection(horizontalPadding: Dp) {
    Card(
        modifier = Modifier
            .padding(horizontal = horizontalPadding, vertical = 16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Horarios Disponibles", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(Modifier.height(8.dp))

            val horarios = listOf(
                "Hoy" to listOf("3:00 PM", "4:30 PM", "6:00 PM"),
                "Mañana" to listOf("9:00 AM", "10:30 AM", "2:00 PM"),
                "Viernes" to listOf("11:00 AM", "1:00 PM", "3:30 PM")
            )

            horarios.forEach { (dia, lista) ->
                Spacer(Modifier.height(8.dp))
                Text(dia, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = Color(0xFF007AFF))
                Spacer(Modifier.height(4.dp))
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    lista.forEach {
                        AssistChip(
                            onClick = {},
                            label = { Text(it, fontSize = 13.sp) },
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = Color(0xFFE0F2F1),
                                labelColor = Color(0xFF00A88B)
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PriceSection(horizontalPadding: Dp) {
    Card(
        modifier = Modifier
            .padding(horizontal = horizontalPadding)
            .fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF00A88B).copy(alpha = 0.08f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Consulta", color = Color.Gray, fontSize = 14.sp)
                Text("S/ 150", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF007AFF))
            }
            Column(horizontalAlignment = Alignment.End) {
                Text("Próxima disponibilidad", color = Color.Gray, fontSize = 13.sp)
                Text("Hoy, 3:00 PM", fontWeight = FontWeight.SemiBold, color = Color(0xFF007AFF))
            }
        }
    }
}
