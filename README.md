# Aplicación Android para Juegos Gratis

Este repositorio contiene una aplicación nativa de Android diseñada para visualizar videojuegos gratuitos.

## Secciones de la Aplicación

1. **Vista de Lista**: 
   - Muestra una lista de videojuegos disponibles.
   - Permite buscar por título y categoría.

2. **Vista de Detalles**: 
   - Muestra información detallada de un videojuego específico.
   - Permite editar los valores del videojuego y eliminarlo de la lista.

## Detalles Técnicos

La aplicación fue desarrollada siguiendo los fundamentos básicos de la programación orientada a objetos y aplicando los principios SOLID. Además, se utilizaron las siguientes bibliotecas disponibles en los repositorios de Android:

## Bibliotecas Utilizadas

- **Jetpack Compose**: Framework moderno de UI declarativa que permite construir interfaces de usuario de manera eficiente y reactiva.
- **Hilt**: Biblioteca de inyección de dependencias basada en Dagger que simplifica la gestión de dependencias en Android.
  - `hilt.android`: Contenedor de inyección de dependencias para Android.
  - `hilt.navigation.compose`: Integración con Compose para inyección en ViewModels.
  - `hilt.android.compiler`: Proveedor de anotaciones para la generación de código de Hilt.
- **Room**: Biblioteca de persistencia de datos que simplifica el manejo de bases de datos locales en Android.
  - `room.runtime`, `room.ktx`: Funcionalidades principales para el acceso a datos.
  - `room.compiler`: Proveedor de anotaciones para generar código relacionado con Room.
- **Retrofit (Gson Converter)**: Cliente HTTP para consumir APIs RESTful y convertir respuestas JSON a objetos Kotlin usando Gson.
- **DataStore**: Solución moderna para almacenar datos clave-valor de manera segura y eficiente en dispositivos Android.
- **Coil**: Biblioteca ligera y eficiente para cargar y mostrar imágenes en aplicaciones Android, con soporte nativo para Jetpack Compose.
- **Material Components (Material3)**: Conjunto de componentes de UI basados en Material Design 3 para crear interfaces consistentes y atractivas.
- **JUnit**: Marco de pruebas unitarias para garantizar la calidad del código.
- **Espresso**: Herramienta para realizar pruebas automatizadas de UI en Android.
- **Compose BOM**: Base de gestión de versiones para todas las dependencias relacionadas con Compose.
- **Compose UI Tooling**: Herramienta para previsualizar y depurar interfaces de usuario creadas con Compose.
- **Lifecycle Runtime KTX**: Extensiones para gestionar de forma más sencilla el ciclo de vida de componentes en Android.
- **Activity Compose**: Extensiones de Activity para facilitar la integración con Jetpack Compose.
- **Core KTX**: Extensiones de Kotlin para simplificar tareas comunes en Android.
- **UI Test JUnit4**: Herramienta para pruebas de interfaces en Compose.
- **Javax Inject**: Proveedor de anotaciones para gestionar la inyección de dependencias sin frameworks adicionales.

Con estas bibliotecas, la aplicación se desarrolla utilizando las mejores prácticas de Android, asegurando un diseño moderno, eficiente y escalable.
