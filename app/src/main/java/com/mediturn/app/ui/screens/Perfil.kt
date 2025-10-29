package com.mediturn.app.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mediturn.app.R
import com.mediturn.app.ui.components.BottomNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Perfil(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavBar(navController, "perfil") }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color(0xFFF6F9FC))
                .imePadding()
                .navigationBarsPadding()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
            ) {
                // Fondo con gradiente y curva inferior
                Canvas(modifier = Modifier.matchParentSize()) {
                    val gradient = Brush.verticalGradient(
                        listOf(Color(0xFF007AFF), Color(0xFF00CBA9))
                    )
                    drawRoundRect(
                        brush = gradient,
                        size = size.copy(height = size.height + 100f),
                        cornerRadius = CornerRadius(0f, 80f)
                    )
                }

                // Botón atrás
                IconButton(
                    onClick = { navController.navigate("home") },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopStart)
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver",
                        tint = Color.White
                    )
                }

                // Título centrado
                Text(
                    text = "Mi Perfil",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 28.dp)
                )

                // Imagen flotante con borde blanco y sombra
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = 30.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(6.dp)
                        .shadow(10.dp, CircleShape, clip = false)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.doctor_placeholder),
                        contentDescription = "Foto de perfil",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                    )
                }
            }

            // Espacio para evitar solapamiento
            Spacer(modifier = Modifier.height(70.dp))

            // 🔸 Tarjeta principal con nombre, correo y estadísticas
            Card(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(top = 20.dp, bottom = 28.dp)
                ) {
                    Text(
                        text = "Juan Pérez",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color(0xFF222222)
                    )
                    Text(
                        text = "juan.perez@email.com",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider(thickness = 0.8.dp, color = Color(0xFFE3E3E3))
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        PerfilStat("24", "Citas Totales")
                        PerfilStat("2", "Próximas")
                        PerfilStat("22", "Completadas")
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // 🔹 Secciones con información personal
            PerfilSection("Información Personal") {
                InfoRow(Icons.Default.Call, "Teléfono", "+51 987 654 321", Color(0xFF00CBA9))
                InfoRow(Icons.Default.Place, "Ubicación", "Lima, Perú", Color(0xFF6C63FF))
                InfoRow(Icons.Default.DateRange, "Fecha de Nacimiento", "15/03/1990", Color(0xFF9C27B0))
                InfoRow(Icons.Default.Favorite, "Tipo de Sangre", "O+", Color(0xFFE53935))
            }

            // 🔹 Cuenta
            PerfilSection("Cuenta") {
                OptionRow(Icons.Default.Person, "Editar Perfil", Color(0xFF00CBA9))
                OptionRow(Icons.Default.Security, "Privacidad y Seguridad", Color(0xFF6C63FF))
                OptionRow(Icons.Default.Notifications, "Notificaciones", Color(0xFF9C27B0))
            }

            // 🔹 Salud
            PerfilSection("Salud") {
                OptionRow(Icons.Default.History, "Historial Médico", Color(0xFF00CBA9))
                OptionRow(Icons.Default.FavoriteBorder, "Alergias y Condiciones", Color(0xFFE53935))
            }

            // 🔹 Soporte
            PerfilSection("Soporte") {
                OptionRow(Icons.AutoMirrored.Filled.Help, "Centro de Ayuda", Color(0xFFFF6F00))
                OptionRow(Icons.Default.Settings, "Configuración", Color(0xFF757575))
            }

            // 🔴 Botón cerrar sesión
            OutlinedButton(
                onClick = { /* Acción de cerrar sesión */ },
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFFE53935)),
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.Logout,
                    contentDescription = "Cerrar sesión",
                    tint = Color(0xFFE53935)
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    "Cerrar Sesión",
                    color = Color(0xFFE53935),
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun PerfilStat(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF007AFF))
        Text(label, color = Color.Gray, fontSize = 13.sp)
    }
}

@Composable
fun PerfilSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(vertical = 12.dp)) {
            Text(
                text = title,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
            content()
        }
    }
}

@Composable
fun InfoRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    value: String,
    color: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Icon(icon, contentDescription = title, tint = color, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(title, fontSize = 13.sp, color = Color.Gray)
            Text(value, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun OptionRow(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, color: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = title, tint = color, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Text(title, fontWeight = FontWeight.Medium)
        }
        Icon(
            Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}
