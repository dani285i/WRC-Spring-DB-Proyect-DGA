# Documentación de la API REST WRC 2025

Este proyecto usa una API REST para la gestión del World Rally Championship 2025. Se ha desarrollado como práctica para Desenvolvemento Web en Contorno Servidor, utilizando Spring Boot, siguiendo una arquitectura lo más limpia posible.

## Tecnologías utilizadas

- Java 21  
- Spring Boot 3.4.0
- Spring Web (para la API REST)
- Spring Data JPA (para la persistencia de datos)
- MySQL Driver (conexión con la base de datos)
- MapStruct (mapeo entre entidades y DTO)
- Lombok (reducción de código repetitivo)

## Características principales

Incorporé:

- CRUD completo en más de tres controladores.
- Relaciones JPA 1:N (Rally–Tramo) y N:M con atributos extra (Inscripción).
- Uso de DTO mediante records de Java.
- Implementación de mapeadores con MapStruct.
- Empleo de objetos de valor mediante `@Embeddable` (MotorInfo, CoordenadasGPS, Dni y LicenciaFia).
- Carga inicial de datos mediante el archivo `data.sql` con información real del WRC 2025.

---

## Endpoints

### Gestión de coches 

### Ejemplo: (`/api/coche`)

Permite administrar los vehículos, sus especificaciones técnicas y sus asignaciones.

| GET | `/api/coche` | Obtiene la lista completa de coches.
| GET | `/api/coche/{id}` | Obtiene la información detallada de un coche.
| POST | `/api/coche/save` | Crea un nuevo coche. | Datos del coche y los identificadores del equipo, piloto y patrocinador.
| PUT | `/api/coche/{id}` | Actualiza un coche existente.
| DELETE | `/api/coche/eliminar/{id}` | Elimina un coche.

### Ejemplo de cuerpo JSON (POST/PUT)

```json
{
  "modelo": "Toyota GR Yaris Rally1",
  "dorsal": 69,
  "motor": "1.6L Turbo Híbrido",
  "categoria": "RALLY1",
  "potenciaCv": 530.0,
  "parMotorNm": 500.0,
  "cilindradaCc": 1600,
  "esHibrido": true,
  "idEquipo": 1,
  "idPiloto": 1,
  "idPatrocinador": 1
}