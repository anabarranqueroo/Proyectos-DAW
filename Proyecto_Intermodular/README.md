*Esta es la carepta para guardar todas las versiones del proyecto EmpreScore*

# EmpreScore

**EmpreScore** es una aplicación web inspirada en Trustpilot que permite a usuarios registrados valorar y reseñar empresas, y a administradores moderar el contenido.

---

## 🛠️ Tecnologías utilizadas

### Backend
- **Spring Boot** — Framework principal de Java para crear APIs REST. Se encarga de arrancar el servidor, gestionar las dependencias y configurar la seguridad.
- **MVC (Modelo-Vista-Controlador)** — Patrón de arquitectura usado en el proyecto:
  - **Modelo**: entidades como `Usuario`, `Empresa`, `Reseña` y `Categoria`
  - **Controlador**: clases como `AuthController` o `EmpresaController` que reciben peticiones HTTP y devuelven respuestas JSON
  - **Vista**: el frontend Angular, ya que el backend solo devuelve datos
- **JPA (Java Persistence API)** — Capa que conecta Java con la base de datos. Permite trabajar con objetos Java en vez de escribir SQL manualmente. Spring Data JPA genera las consultas automáticamente a partir del nombre de los métodos.
- **MySQL** — Base de datos relacional donde se almacenan todos los datos. Se ejecuta a través de XAMPP localmente.

### Frontend
- **Angular** — Framework de JavaScript para construir la interfaz de usuario como una SPA (Single Page Application). La página no se recarga completa al navegar, sino que Angular actualiza solo las partes necesarias. Se comunica con el backend mediante peticiones HTTP a los endpoints REST.
- **HTML y CSS** — Lenguajes base para estructurar y estilizar las páginas.
- **Bootstrap** — Librería de CSS con componentes visuales prediseñados como botones, formularios, tablas y tarjetas, permitiendo un diseño responsive y profesional.

---

## 🧰 Recursos

| Herramienta | Uso |
|-------------|-----|
| **VSCode** | Editor de código para backend y frontend |
| **XAMPP** | Servidor MySQL local durante el desarrollo |
| **GitHub** | Control de versiones y almacenamiento del código |
| **Navegador** | Entorno donde el usuario interactúa con la aplicación |

---

## 🏗️ Arquitectura del Backend
```
Cliente (Angular)
       ↓ HTTP Request
   Controller        → Recibe la petición y llama al servicio
       ↓
    Service          → Contiene la lógica de negocio
       ↓
   Repository        → Consulta la base de datos via JPA
       ↓
    MySQL            → Almacena los datos
       ↑
   Model/Entity      → Define la estructura de las tablas
```

La seguridad con **Spring Security** actúa antes de que la petición llegue al Controller, verificando que el usuario esté autenticado y tenga el rol necesario para acceder al endpoint.

---

## 🔐 Seguridad

- Cifrado de contraseñas con **BCrypt**
- Autenticación con **Spring Security**
- Roles de usuario: **ADMIN**, **EMPRESA**, **USER**
- Endpoints protegidos por rol
- DTOs para no exponer datos sensibles como contraseñas

---

## 📦 Estructura del proyecto
```
src/main/java/com/emprescore/
├── config/         → Configuración de seguridad e inicialización de datos
├── controller/     → Endpoints REST
├── dto/            → Objetos de transferencia de datos
├── model/          → Entidades JPA
├── repo/           → Repositorios Spring Data
└── service/        → Lógica de negocio
```
