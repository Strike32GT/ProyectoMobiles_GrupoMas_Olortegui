# ProyectoMobiles_GrupoMas_Olortegui

🏥 Proyecto: MediTurn – Citas Médicas

Curso: Aplicaciones Móviles con Android (Kotlin + Jetpack Compose)
Duración: 6 días
Equipo: Grupo Más – Olortegui

🚀 Visión del Proyecto

MediTurn es una aplicación móvil diseñada para gestionar citas médicas de forma rápida y confiable. Permite buscar médicos por especialidad, agendar consultas (presenciales o teleconsulta) y mantener un registro claro de las citas del paciente.
Su propósito es mejorar la accesibilidad a servicios de salud mediante una interfaz moderna, intuitiva y segura, centrada en la experiencia del usuario.

🧠 Público Objetivo

Personas entre 18 y 60 años, con acceso a dispositivos móviles, que buscan consultas médicas rápidas y organizadas sin necesidad de desplazarse o realizar largas esperas.

📱 Historias de Usuario

#### 🩺 HU01 – Buscar médicos por nombre o especialidad  
**Como:** paciente  
**Quiero:** buscar médicos por nombre o especialidad  
**Para:** encontrar fácilmente al profesional adecuado  
**Prioridad:** Alta  
**Criterio de aceptación:** El buscador muestra resultados que coinciden con la búsqueda.

---

#### 💊 HU02 – Ver especialidades médicas destacadas  
**Como:** paciente  
**Quiero:** ver especialidades médicas destacadas  
**Para:** acceder rápidamente sin escribir  
**Prioridad:** Media  
**Criterio de aceptación:** Se muestran botones o tarjetas con íconos y nombres de especialidades.

---

#### 👨‍⚕️ HU03 – Ver detalle de un médico  
**Como:** paciente  
**Quiero:** visualizar el detalle del médico (nombre, experiencia, modalidad, tarifa, calificación)  
**Para:** decidir si agendo una cita  
**Prioridad:** Alta  
**Criterio de aceptación:** Al tocar un médico, se despliega su información completa.

---

#### 📅 HU04 – Agendar una cita  
**Como:** paciente  
**Quiero:** seleccionar fecha, hora y tipo de consulta  
**Para:** recibir atención en el horario que elija  
**Prioridad:** Alta  
**Criterio de aceptación:** El formulario valida los campos y confirma la cita.

---

#### 🕒 HU05 – Ver próximas citas y unirse a teleconsultas  
**Como:** paciente  
**Quiero:** ver mis próximas citas y unirme a teleconsultas  
**Para:** asistir sin complicaciones  
**Prioridad:** Alta  
**Criterio de aceptación:** Se muestran botones “Unirse” o “Cancelar” en citas próximas.

---

#### 📋 HU06 – Ver historial de citas  
**Como:** paciente  
**Quiero:** revisar el historial de mis citas completadas  
**Para:** llevar un seguimiento de mis atenciones anteriores  
**Prioridad:** Media  
**Criterio de aceptación:** En la pestaña “Historial” se muestran citas con estado “Completada”.

---

#### 👤 HU07 – Editar información personal  
**Como:** paciente  
**Quiero:** editar mi información personal (nombre, teléfono, ubicación, tipo de sangre)  
**Para:** mantener mis datos actualizados  
**Prioridad:** Media  
**Criterio de aceptación:** La pantalla de perfil permite modificar los datos correctamente.

---

#### 💬 HU08 – Recibir consejos y recordatorios  
**Como:** paciente  
**Quiero:** recibir consejos de salud y recordatorios  
**Para:** mantener hábitos saludables y no olvidar mis citas  
**Prioridad:** Baja  
**Criterio de aceptación:** Se muestra un bloque “Consejo del día” en la pantalla principal.

## 🧩 Flujo General del Proyecto

1. **Inicio (Home):** Pantalla con buscador, especialidades y botones de acceso.  
2. **Doctores:** Lista de médicos cargados desde la base de datos.  
3. **Detalle del Médico:** Información ampliada del profesional.  
4. **Mis Citas:** Próximas citas y citas pasadas con filtros por fecha.  
5. **Perfil:** Datos personales, estadísticas y opciones de cuenta.  
6. **Navegación Inferior:** Menú persistente con accesos directos.

---

## 🧠 Arquitectura Funcional

- **MVVM (Model–View–ViewModel)**  
  - `Model` → Entidades y repositorios (Room)  
  - `View` → Pantallas en Compose  
  - `ViewModel` → Lógica y manejo del estado con *StateFlow*

- **Room Database:** Persistencia local para doctores y citas  
- **Jetpack Compose:** Interfaz declarativa y reactiva  
- **Navigation Compose:** Sistema de rutas entre pantallas  
- **Material3:** Estilo visual moderno

---

## 🎬 Video Pitch (5–7 minutos)

🎥 [**Ver presentación en YouTube (Pitch Final)**](https://youtu.be/YEp0QA5TWrI?si=P0JKo04ypbyDsluU)

> Explicación general del flujo, pantallas principales y base de datos funcional (Room + Compose).

---


## 🎬 Dia 2: demostracion del Proyecto

[![Ver video en YouTube](https://img.youtube.com/vi/bxe31nS2u7Y/hqdefault.jpg)](https://www.youtube.com/watch?v=bxe31nS2u7Y)

> 🎥 **Demo de MediTurn:** navegación principal.



## 🎨 Prototipo en Figma

👉 [**Ver diseño interactivo en Figma**](https://www.figma.com/make/DJzsTLblD6YXjbmJ5kXgoq/MediTurn-Mobile-Design?fullscreen=1)




## 🛠️ Herramientas y Tecnologías

| Herramienta | Descripción |
|--------------|-------------|
| <img src="https://upload.wikimedia.org/wikipedia/commons/7/74/Kotlin_Icon.png" width="30"/> **Kotlin** | Lenguaje principal para el desarrollo Android. |
| <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/jetpackcompose/jetpackcompose-original.svg" width="30"/> **Jetpack Compose** | Framework moderno para interfaces declarativas. |
| <img src="https://upload.wikimedia.org/wikipedia/commons/3/33/Figma-logo.svg" width="30"/> **Figma** | Diseño y prototipado UI/UX. |
| <img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" width="30"/> **GitHub** | Control de versiones y colaboración. |


---

## 🏁 Release Final

📦 **Versión:** v1.0  
🗓️ **Fecha:** Octubre 2025  
🔗 [**Repositorio GitHub**](https://github.com/Strike32GT/ProyectoMobiles_GrupoMas_Olortegui)


---

✅ **Resumen del Release v1.0:**  
Primera versión funcional de *MediTurn*: búsqueda de médicos, gestión de citas, detalle del profesional y pantalla de perfil, todo implementado con **Jetpack Compose + Room Database**.