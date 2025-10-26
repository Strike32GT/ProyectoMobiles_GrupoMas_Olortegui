package com.mediturn.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun BottomNavBar(navController: NavController, currentRoute: String) {
    NavigationBar(containerColor = Color.White) {
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = {
                if (currentRoute != "home") navController.navigate("home") {
                    popUpTo("home") { inclusive = false }
                }
            },
            icon = { Icon(Icons.Default.Search, contentDescription = "Inicio") },
            label = { Text("Inicio") }
        )

        NavigationBarItem(
            selected = currentRoute == "citas",
            onClick = {
                if (currentRoute != "citas") navController.navigate("citas") {
                    popUpTo("home") { inclusive = false }
                }
            },
            icon = { Icon(Icons.Default.CalendarToday, contentDescription = "Citas") },
            label = { Text("Citas") }
        )

        NavigationBarItem(
            selected = currentRoute == "perfil",
            onClick = {
                if (currentRoute != "perfil") navController.navigate("perfil") {
                    popUpTo("home") { inclusive = false }
                }
            },
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Perfil") },
            label = { Text("Perfil") }
        )
    }
}
