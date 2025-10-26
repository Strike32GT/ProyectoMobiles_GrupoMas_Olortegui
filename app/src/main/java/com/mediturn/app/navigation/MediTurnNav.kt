package com.mediturn.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mediturn.app.ui.screens.CreateAccountMediTurn
import com.mediturn.app.ui.screens.Especialidad
import com.mediturn.app.ui.screens.HomeMediTurn
import com.mediturn.app.ui.screens.DoctorDetailScreen
import com.mediturn.app.ui.screens.LoginMediTurn
import com.mediturn.app.ui.screens.MisCitas
import com.mediturn.app.ui.screens.Perfil
import com.mediturn.app.ui.screens.DoctorsScreen

//Navegacion
@Composable
fun MediTurnNav() {
    val navController= rememberNavController()
    NavHost(
        navController=navController,
        startDestination = "login" //Inicio de la app
    ){
        composable("login"){ LoginMediTurn(navController) }
        composable("create"){ CreateAccountMediTurn(navController) }
        composable("especialidad"){ Especialidad(navController) }
        composable("citas"){ MisCitas(navController) }
        composable("perfil"){ Perfil(navController) }
        composable("home"){ HomeMediTurn(navController) }
        composable("detail") { DoctorDetailScreen(navController) }
        composable("doctors") { DoctorsScreen(navController) }


    }
}