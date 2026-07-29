# Siranush's Kitchen — Backend ⚙️🍂

Backend del proyecto individual **Siranush's Kitchen**, una plataforma web para preservar y compartir recetas armenias tradicionales.


### 🔄 Conexión Full Stack
Este repositorio contiene la lógica del lado del servidor y la base de datos. Para ver la interfaz de usuario, visita el repositorio del cliente:
* 🖥️ **Frontend:** [Siranush's Kitchen — Frontend](https://github.com/SiuzannaVach/siranush-kitchen-frontend.git)
* ⚙️ **Backend & API:** [Siranush's Kitchen — Bakend](https://github.com/SiuzannaVach/siranush-kitchen-backend.git )(Spring Boot + PostgreSQL)
Desarrollado en el marco del bootcamp de Factoria F5 (Cohorte 9, Barcelona).

## 📝 Descripción

API REST desarrollada con **Spring Boot**, que permite consultar el catálogo público de recetas y, para el rol de administrador, gestionar el ciclo de vida completo de cada receta (crear, editar y eliminar).

## 🏗️ Arquitectura

El proyecto sigue una arquitectura en capas típica de Spring Boot:

```
com.siuzanna
 ├── config/       # Configuración global y reglas de seguridad
 ├── controller/   # Endpoints de la API (reciben datos del Frontend)
 ├── dto/          # Objetos de transferencia de datos limpios
 ├── mapper/       # Traductor automático entre Model y DTO
 ├── model/        # Entidades de la base de datos (Receta, Usuario, Categoría)
 ├── repository/   # Comunicación directa con la base de datos PostgreSQL
 └── service/      # Lógica de negocio y procesamiento de datos (Imágenes)

```

**Flujo de una petición:**
Frontend ⇄ Controller ⇄ Service ⇄ Repository ⇄ PostgreSQL (Base de Datos)
└─ (Mapper) ⇄ DTO ⇄ Frontend



## 🛠️Stack tecnológico

- Java 21
- Spring Boot 3.3.0
- Spring Data JPA
- Spring Security (Autenticación con Basic Auth)
- PostgreSQL
- Lombok
- Maven

## Roles y permisos

| Rol | Permisos |
|---|---|
| **USER** | Consultar el catálogo de recetas y el detalle de cada una (solo lectura) |
| **ADMIN** | Crear, editar y eliminar recetas |

> 💡La cuenta de administrador se crea automáticamente al arrancar la aplicación por primera vez (`DataInitializer`).

## Endpoints principales

| Método | Endpoint | Acceso |
|---|---|---|
| GET | `/api/recipes` | Público |
| GET | `/api/recipes/{id}` | Público |
| POST | `/api/recipes` | Solo ADMIN |
| PUT | `/api/recipes/{id}` | Solo ADMIN |
| DELETE | `/api/recipes/{id}` | Solo ADMIN |
| POST | `/api/auth/register` | Público (registro de nuevos usuarios USER) |


## 🔓 Configuración de CORS
El backend incluye la configuración de CORS necesaria en la seguridad para permitir y procesar de forma segura las peticiones entrantes desde el servidor de desarrollo del Frontend (`http://localhost:5173`).

## 🚀 Configuración y Uso Local

1. Crear una base de datos PostgreSQL llamada `siranush_kitchen`.
2. Configurar las variables de entorno en tu sistema o IDE: `DB_USERNAME` y `DB_PASSWORD`. El archivo `application.properties` ya está preparado para leerlas de forma segura.
3. Ejecutar la clase principal `SiranushKitchenApplication.java` o correr el comando `mvn spring-boot:run` en la terminal.
4. La aplicación creará automáticamente las tablas y el usuario administrador inicial.

## 🧪 Testing

El proyecto incluye tests unitarios ubicados en `src/test/java`, incluyendo la verificación del mapeo de datos (`RecipeMapperTest`).


## 👩‍💻 Autora

Siuzanna Vachaganian