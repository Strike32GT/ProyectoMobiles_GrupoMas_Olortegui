package com.mediturn.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mediturn.app.ui.screens.CreateAccountMediTurn
import com.mediturn.app.ui.screens.Especialidad
import com.mediturn.app.ui.screens.HomeMediTurn
import com.mediturn.app.ui.screens.LoginMediTurn
import com.mediturn.app.ui.screens.DoctorsScreen
import com.mediturn.app.ui.screens.DoctorDetailScreen
import com.mediturn.app.ui.screens.MisCitas
import com.mediturn.app.ui.screens.Perfil

//Navegacion
@Composable
fun MediTurnNav() {
    val navController= rememberNavController()
    NavHost(
        navController=navController,
        startDestination = "home"
    ){
        composable("login"){ LoginMediTurn(navController) }
        composable("create"){ CreateAccountMediTurn(navController) }
        composable("especialidad"){ Especialidad(navController) }
        composable("citas") { MisCitas(navController) }
        composable("perfil"){ Perfil(navController) }
        composable(
            route = "doctors?query={query}",
            arguments = listOf(
                navArgument("query") {
                    nullable = true
                    defaultValue = null
                }
            )
        ) { backStackEntry ->
            val query = backStackEntry.arguments?.getString("query")
            DoctorsScreen(navController = navController, initialQuery = query)
        }
        composable("detail") { DoctorDetailScreen(navController) }
        composable("home"){ HomeMediTurn(navController) }
    }
}