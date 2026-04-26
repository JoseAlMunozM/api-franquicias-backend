# 📦 API Franquicias 

API desarrollada en **Spring Boot** para la gestión de franquicias, sucursales y productos, permitiendo el control de inventario por sucursal.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Hibernate

---

## 🧱 Arquitectura

El proyecto sigue una arquitectura en capas:


Controller → Service → Repository → Database


Separación por dominio:

- Franquicia
- Sucursal
- Producto

---

## 📌 Funcionalidades

### 🏢 Franquicias
- Crear franquicia
- Actualizar nombre de franquicia

### 🏬 Sucursales
- Crear sucursal asociada a franquicia
- Actualizar nombre de sucursal

### 📦 Productos
- Crear producto en sucursal
- Eliminar producto de sucursal
- Actualizar nombre de producto
- Actualizar stock de producto

### 📊 Reportes
- Obtener el producto con mayor stock por sucursal dentro de una franquicia

---

## 🔥 Endpoints principales

### Franquicias

POST /franquicias
PUT /franquicias/{id}


### Sucursales

POST /franquicias/{id}/sucursales
PUT /sucursales/{id}


### Productos

POST /sucursales/{id}/productos
PUT /productos/{id}
DELETE /sucursales/{idSucursal}/productos/{idProducto}
PUT /productos/{id}/stock


### Reporte

GET /franquicias/{id}/top-productos


---

## 🗄️ Base de datos

El proyecto utiliza **MySQL**.

### Configuración en `application.properties`

▶️ Ejecución del proyecto
1. Clonar repositorio
2. Entrar al proyecto
cd api-franquicias
3. Ejecutar aplicación
mvn spring-boot:run
🧪 Pruebas

Para ejecutar pruebas:

mvn test

Se incluyen pruebas unitarias para los controladores usando MockMvc.
