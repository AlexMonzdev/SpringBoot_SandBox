
# SandBox para Spring Framework

Este proyecto tiene como objetivo aprender, mejorar y practicar habilidades clave en el desarrollo backend utilizando Java y el Spring Framework. En particular, se enfoca en:

Controladores REST: Diseño y manejo de endpoints HTTP para interactuar con la lógica del negocio y los datos de manera eficiente y estructurada.

- **Inversión de Dependencias (Dependency Injection)**: Aplicación de este principio para lograr un código más desacoplado, modular y fácil de mantener, utilizando las herramientas que ofrece Spring Framework.
- **Inversión de Control (Inversion of Control - IoC)**: Comprensión y práctica del patrón IoC, delegando la responsabilidad de creación y gestión de objetos al contenedor de Spring.
El proyecto simula una base de datos con una lista en memoria, lo que permite centrarse en los conceptos fundamentales de la arquitectura y el desarrollo de APIs sin complejidad adicional de integración con sistemas externos.

# 📚 Book Management API

Este proyecto es una API REST sencilla para gestionar una colección de libros, desarrollada como parte de un trabajo universitario. Simula una base de datos utilizando una lista en memoria para demostrar conceptos de desarrollo backend con **Spring Boot**.

## 🚀 Características

- **CRUD Completo**: Permite crear, leer, actualizar y eliminar libros.
- **Gestión por ISBN**: Cada libro se identifica de manera única con su ISBN.
- **Validación básica**: Previene duplicados y asegura consistencia de datos.
- **Simulación de base de datos**: Usa una lista en memoria para almacenar los libros.

## 📂 Estructura del Proyecto

Aquí tienes la estructura en formato **Markdown (.md)** bien presentada:


## 📂 Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

```
src/main/java/com/alexmonzon/sandbox_app
├── Book.java                 # Clase modelo para representar libros
├── BookRepository.java       # Interfaz del repositorio de libros
├── InMemoryBookRepository.java # Implementación en memoria del repositorio
├── BookControler.java        # Controlador REST para manejar las solicitudes HTTP
├── SandboxAppApplication.java # Clase principal para arrancar la aplicación
```

### Descripción de los Archivos

- **`Book.java`**: Clase que define la estructura de un libro con atributos como `isbn`, `title`, y `author`. Incluye métodos `getter` y `setter`.

- **`BookRepository.java`**: Interfaz que define los métodos para interactuar con los datos de los libros, incluyendo operaciones como búsqueda, guardado, eliminación y actualización.

- **`InMemoryBookRepository.java`**: Implementación en memoria del repositorio de libros. Almacena los libros en una lista estática y realiza las operaciones definidas en la interfaz `BookRepository`.

- **`BookControler.java`**: Controlador REST que expone los endpoints HTTP para gestionar los libros. Implementa operaciones como:
  - Obtener todos los libros (`GET /books/`)
  - Obtener un libro por ISBN (`GET /books/{isbn}`)
  - Crear un libro (`POST /books`)
  - Actualizar un libro (`PUT /books/{isbn}`)
  - Eliminar un libro (`DELETE /books/{isbn}`)

- **`SandboxAppApplication.java`**: Clase principal que arranca la aplicación utilizando el framework Spring Boot.

🏆 Créditos

Desarrollado por **Alejandro Monzón** como parte de un proyecto académico.











