package com.mediturn.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BottomNavBar(navController: NavController, currentRoute: String) {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 6.dp
    ) {
        val selectedColor = Color(0xFF00CBA9)
        val unselectedColor = Color(0xFF606060)
        val indicatorColor = Color(0x1A00CBA9)

        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { navController.navigate("home") },
            icon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Inicio"
                )
            },
            label = { Text("Inicio") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor,
                indicatorColor = indicatorColor
            )
        )

        NavigationBarItem(
            selected = currentRoute == "citas",
            onClick = { navController.navigate("citas") },
            icon = {
                Icon(
                    Icons.Default.CalendarToday,
                    contentDescription = "Citas"
                )
            },
            label = { Text("Citas") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor,
                indicatorColor = indicatorColor
            )
        )

        NavigationBarItem(
            selected = currentRoute == "perfil",
            onClick = { navController.navigate("perfil") },
            icon = {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = "Perfil"
                )
            },
            label = { Text("Perfil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor,
                indicatorColor = indicatorColor
            )
        )
    }
}