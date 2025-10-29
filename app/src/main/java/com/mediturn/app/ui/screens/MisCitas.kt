package com.mediturn.app.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mediturn.app.data.model.Cita
import com.mediturn.app.viewmodel.CitaViewModel
import java.time.LocalDate
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider


//Primer Avance del activity Citas Fernando Mas
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MisCitas(navController: NavController,
             citaViewModel: CitaViewModel=viewModel()
) {
    var selectTab by remember { mutableStateOf(0) }
    val tabs= listOf("Proximas","Historial")

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Mis Citas",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.background(
                    Brush.linearGradient(
                        listOf(Color(0xFF007AFF), Color(0xFF00CBA9))
                    )
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
                    TabRow(
                        selectedTabIndex = selectTab,
                        containerColor = Color.White,
                        contentColor = Color(0xFF00CBA9),
                        indicator = {},
                        divider = {}
                    ){
                        tabs.forEachIndexed { index, title ->
                            Tab(
                                selected = selectTab == index,
                                onClick = { selectTab = index },
                                text = {
                                    Text(
                                        text = title,
                                        fontWeight = FontWeight.SemiBold,
                                        color = if(selectTab == index)
                                        Color(0xFF00CBA9) else Color.Gray
                                        )
                                       }
                            )
                        }
                    }

                    when (selectTab){
                        0 ->CitasProximas(viewModel = citaViewModel)
                        1->CitasHistorial(viewModel  = citaViewModel)
                    }
                }
            }
}

@Composable
fun CitasProximas(viewModel: CitaViewModel) {
    val citas by viewModel.citas.collectAsState()
    val cargando by viewModel.cargando.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadCitas()
    }

    if(cargando) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator(color = Color(0xFF00CBA9))
        }
    } else if (citas.isEmpty()){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text("No hay citas proximas", color = Color.Gray)
        }
    } else {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(citas){ cita ->
                CitaCard(cita)
            }
        }
    }
}

@Composable
fun CitasHistorial(viewModel: CitaViewModel){
    val citas by viewModel.citas.collectAsState()
    val cargando by viewModel.cargando.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadCitas()
    }

    val historial = citas.filter { cita ->
        try {
            val fechaCita= LocalDate.parse(cita.fecha ?:"")
            fechaCita.isBefore(LocalDate.now())
        }catch (e: Exception){
            false
        }
    }

    if(cargando){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator(color = Color(0xFF00CBA9))
        }
    }else if(historial.isEmpty()){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text("No hay citas en el historial", color = Color.Gray)
        }
    }else{
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(historial){ cita ->
                CitaCard(cita, historial=true)
            }
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
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {

            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFEAEAEA)),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = Color.Gray,
                    modifier = Modifier.size(35.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)){
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

                Row(verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(14.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        cita.fecha ?:"Sin fecha",
                        color = Color.Gray,
                        fontSize = 13.sp
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(14.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        cita.hora, color = Color.Gray, fontSize = 13.sp
                    )
                }

                Spacer(modifier = Modifier.width(2.dp))

                Row(verticalAlignment = Alignment.CenterVertically){
                    val icon= if(cita.tipo == "Teleconsulta")
                        Icons.Default.Call
                    else
                        Icons.Default.Place

                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint=colorTipo,
                        modifier = Modifier.size(14.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = cita.tipo,
                        color = colorTipo,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .background(colorTipo.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
            }

            if (!historial) {
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(6.dp)){

                    Button(
                        onClick = {/**/},
                        colors = ButtonDefaults.buttonColors(containerColor = colorTipo),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .height(36.dp)
                            .width(102.dp)
                    ) {
                        Text(
                            "Unirse",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    OutlinedButton(
                        onClick = {/**/},
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp,Color.LightGray),
                        modifier = Modifier
                            .height(36.dp)
                            .width(102.dp)
                    ) {
                        Text("Mensaje", fontSize = 14.sp, color = Color.Black)
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



