package com.mediturn.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mediturn.app.R
import com.mediturn.app.ui.components.BottomNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeMediTurn(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavBar(navController, "home") }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color(0xFFF6F9FC))
        ) {
            // 🔷 Encabezado con gradiente
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .clip(RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp))
                    .background(
                        Brush.verticalGradient(
                            listOf(Color(0xFF007AFF), Color(0xFF00C6AE))
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 24.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                "MediTurn",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                            Text(
                                "Tu salud, nuestra prioridad",
                                color = Color.White.copy(alpha = 0.9f),
                                fontSize = 14.sp
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Perfil",
                            tint = Color.White,
                            modifier = Modifier.size(34.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // 🔍 Barra de búsqueda
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("Buscar médico o especialidad...") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = null,
                                tint = Color(0xFF007AFF)
                            )
                        },
                        shape = RoundedCornerShape(30.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent
                        )
                    )
                }
            }

            Spacer(Modifier.height(28.dp))

            // 🔹 Botones principales
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    HomeMainButtonIcon(Icons.Default.Search, "Buscar Médicos") {
                        navController.navigate("doctors")
                    }
                }
                Box(modifier = Modifier.weight(1f)) {
                    HomeMainButtonIcon(Icons.Default.CalendarToday, "Mis Citas") {
                        navController.navigate("citas")
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            // 🔹 Especialidades
            Text(
                text = "Especialidades",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 24.dp)
            )

            Spacer(Modifier.height(12.dp))

            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                val specialties = listOf(
                    "Cardiología" to R.drawable.ic_heart,
                    "Neurología" to R.drawable.ic_brain,
                    "Oftalmología" to R.drawable.ic_eye,
                    "Medicina General" to R.drawable.ic_stethoscope,
                    "Pediatría" to R.drawable.ic_baby,
                    "Farmacología" to R.drawable.ic_pill
                )
                specialties.forEach { (name, icon) ->
                    SpecialtyCard(name, icon)
                }
            }

            Spacer(Modifier.height(28.dp))
            TipCard()
            Spacer(Modifier.height(36.dp))
        }
    }
}

@Composable
fun HomeMainButtonIcon(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .height(100.dp)
            .shadow(4.dp, RoundedCornerShape(20.dp))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                icon,
                contentDescription = title,
                tint = Color(0xFF00A88B),
                modifier = Modifier.size(36.dp)
            )
            Spacer(Modifier.height(6.dp))
            Text(
                title,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color(0xFF2E2E2E)
            )
        }
    }
}

@Composable
fun SpecialtyCard(name: String, icon: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .width(150.dp)
            .height(70.dp)
            .shadow(3.dp, RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = name,
                modifier = Modifier
                    .size(34.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Fit
            )
            Spacer(Modifier.width(8.dp))
            Text(name, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun TipCard() {
    Card(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF007AFF)),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("💡 Consejo del día", color = Color.White, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(4.dp))
            Text(
                "Recuerda beber al menos 8 vasos de agua al día para mantener tu cuerpo hidratado y saludable.",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 13.sp
            )
        }
    }
}
