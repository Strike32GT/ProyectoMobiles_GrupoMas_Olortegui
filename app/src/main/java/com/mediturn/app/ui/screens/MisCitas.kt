package com.mediturn.app.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.mediturn.app.data.model.Cita

//Primer Avance del activity Citas Fernando Mas
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MisCitas(navController: NavController) {
    var selectTab by remember { mutableStateOf(0) }
    val tabs= listOf("Proximas","Historial")

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Mis citas", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF007AFF),
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            BottomAppBar(containerColor = Color.White){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    Text("Inicio",color=Color.Gray)
                    Text("Citas",color=Color(0xFF00CBA9), fontWeight = FontWeight.Bold)
                    Text("Perfil", color = Color.Gray)
                }
            }
        }
    ){ innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .background(Color(0xFFF5F6FA))
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .background(Color.White, RoundedCornerShape(16.dp)),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        tabs.forEachIndexed { index, title ->
                            val selected = selectTab == index
                            TextButton(
                                onClick = {selectTab = index},
                                colors = ButtonDefaults.textButtonColors(
                                    containerColor = if (selected) Color(0xFF00CBA9) else Color.Transparent,
                                    contentColor = if(selected) Color.White else Color.Gray
                                ),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(4.dp)
                            ) {
                                Text(title, fontWeight = FontWeight.SemiBold)
                            }
                        }
                    }
                    when (selectTab){
                        0 ->CitasProximas()
                        1->CitasHistorial()
                    }
                }
            }
}

@Composable
fun CitasProximas() {
    val citas=listOf(
        Cita("Dr. Carlos Mendoza","Cardiología", "vie, 24 oct", "3:00 PM", "Teleconsulta"),
        Cita("Dra. María González", "Pediatría", "lun, 27 oct", "10:00 AM", "Presencial")
    )
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(citas){ cita ->
            CitaCard(cita)
        }
    }
}

@Composable
fun CitasHistorial(){
    val citas= listOf(
        Cita(
            "Dra. Anna Torres",
            "Medicina General",
            "mar, 14 oct",
            "2:00 PM",
            "Completada")
    )

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(citas){ cita ->
            CitaCard(cita,historial=true)
        }
    }
}




        @Composable
        fun CitaCard(cita: Cita, historial: Boolean = false) {
            val colorTipo = when (cita.tipo){
                "Teleconsulta" -> Color(0xFF007AFF)
                "Presencial" -> Color(0xFF00CBA9)
                "Completada" -> Color.Gray
                else -> Color(0xFF007AFF)
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        text = cita.doctor,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )


                    Text(
                        text = cita.especialidad,
                        color = colorTipo,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )


                    Spacer(modifier = Modifier.height(8.dp))


                    Text(
                        text = "${cita.fecha}  |  ${cita.hora}",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )


                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .background(colorTipo.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ){
                        Text(
                            text = cita.tipo,
                            color = colorTipo,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }


                    if (!historial) {
                        Spacer(modifier = Modifier.height(14.dp))


                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)){
                            Button(
                                onClick = {/**/},
                                colors = ButtonDefaults.buttonColors(containerColor = colorTipo),
                                shape = RoundedCornerShape(30.dp),
                                modifier = Modifier.height(36.dp)
                            ) {
                                Text(
                                    text = "unirse",
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp
                                )
                            }

                            OutlinedButton(
                                onClick = {/**/},
                                shape = RoundedCornerShape(30.dp),
                                border = BorderStroke(1.dp,Color(0xFFB0B0B0)),
                                modifier = Modifier.height(36.dp)
                            ) {
                                Text(
                                    "mensaje",
                                    color = Color.Black,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    } else {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Completada",
                            color = colorTipo,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }



