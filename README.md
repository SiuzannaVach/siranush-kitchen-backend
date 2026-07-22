# Siranush's Kitchen — Backend

Backend del proyecto individual **Siranush's Kitchen**, una plataforma web para preservar y compartir recetas armenias tradicionales.

Desarrollado en el marco del bootcamp de Factoria F5 (Cohorte 9, Barcelona).

## Descripción

API REST desarrollada con **Spring Boot**, que permite consultar el catálogo público de recetas y, para el rol de administrador, gestionar el ciclo de vida completo de cada receta (crear, editar y eliminar).

## Arquitectura

El proyecto sigue una arquitectura en capas típica de Spring Boot:

```
com.siuzanna
├── model/          Entidades JPA (Recipe, User, Category)
├── repository/      Acceso a datos con Spring Data JPA
├── dto/             Objetos de transferencia de datos (RecipeDTO, RegisterRequest)
├── mapper/          Conversión entre entidades y DTOs (RecipeMapper)
├── controller/      Endpoints REST (RecipeController, AuthController)
├── config/          Configuración de seguridad (SecurityConfig, DataInitializer, CustomUserDetailsService)
└── service/         Lógica auxiliar (FileStorageService)
```

**Flujo de una petición:**
Controller → Service → Repository → Entity (base de datos) → Mapper → DTO → respuesta al cliente.


## Stack tecnológico

- Java 21
- Spring Boot 3.3.0
- Spring Data JPA
- Spring Security (autenticación con Basic Auth)
- PostgreSQL
- Lombok
- Maven

## Roles y permisos

| Rol | Permisos |
|---|---|
| **USER** | Consultar el catálogo de recetas y el detalle de cada una (solo lectura) |
| **ADMIN** | Crear, editar y eliminar recetas |

La cuenta de administrador se crea automáticamente al arrancar la aplicación por primera vez (`DataInitializer`).

## Endpoints principales

| Método | Endpoint | Acceso |
|---|---|---|
| GET | `/api/recipes` | Público |
| GET | `/api/recipes/{id}` | Público |
| POST | `/api/recipes` | Solo ADMIN |
| PUT | `/api/recipes/{id}` | Solo ADMIN |
| DELETE | `/api/recipes/{id}` | Solo ADMIN |
| POST | `/api/auth/register` | Público (registro de nuevos usuarios USER) |

## Configuración local

1. Crear una base de datos PostgreSQL llamada `siranush_kitchen`
2. Configurar `src/main/resources/application.properties` con tus credenciales locales (usuario, contraseña, URL de conexión)
3. Ejecutar la clase `Main.java`
4. La aplicación creará automáticamente las tablas y el usuario administrador

## Testing

El proyecto incluye tests unitarios ubicados en `src/test/java`, entre ellos la verificación de la correcta conversión entre `Recipe` y `RecipeDTO` (`RecipeMapperTest`).

## Autora

Siuzanna Vachaganian