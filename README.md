
# AlgaDelivery

**Última modificación:** 18/03/2026  
**Creado:** 2026

---

## Descripción

**AlgaDelivery** es un conjunto de servicios **Backend** que expone APIs REST para la gestión de **deliveries** desarrolladas durante el curso **AlgaWorks - Ignição Microsserviços**.

Los servicios forman parte de una arquitectura basada en microservicios y están integrados con componentes de infraestructura como **descubrimiento de servicios**, **enrutamiento**, **base de datos PostgreSQL** y **mensajería con Kafka**.

---

## Servicios Backend

### Courier-Management

Servicio encargado de la gestión de **repartidores (couriers)**.

### Delivery-Tracking

Servicio encargado de la gestión y seguimiento de **entregas (deliveries)**.

---

## Arquitectura

El sistema está compuesto por los siguientes servicios:

- **Eureka Server** — Descubrimiento dinámico de servicios.
- **Spring Cloud Gateway** — Enrutamiento dinámico de servicios.
- **PostgreSQL** — Base de datos utilizada por los servicios backend.
- **pgAdmin** — Herramienta de administración de la base de datos.
- **Apache Kafka** — Plataforma de mensajería para comunicación entre servicios.

---

## Servicios e Integraciones


### Eureka Server

Servidor de descubrimiento de servicios.

**Servicio:** `Service-Registry`

```
http://localhost:8761/
```

---

### Spring Cloud Gateway

Servidor de enrutamiento de servicios.

**Servicio:** `Gateway`

```
http://localhost:9999/
```

---

### Base de Datos

Bases de datos **PostgreSQL** configuradas mediante `docker-compose.yml`.

**Base de datos:** `deliverydb`

**URL de conexión JDBC**

```
jdbc:postgresql://localhost:5432/deliverydb
```
**Base de datos:** `courierdb`

**URL de conexión JDBC**

```
jdbc:postgresql://localhost:5432/courierdb
```

**Herramienta de administración (pgAdmin)**

```
http://localhost:8083/login
```

---

### Kafka

Servidor de mensajería utilizado en la arquitectura de microservicios.

**Servicio:** `Apache Kafka`

```
http://localhost:8084/
```

---

## Endpoints disponibles

Una vez iniciado el sistema, los endpoints son expuestos a través del **API Gateway**:

```
GET http://localhost:9999/api/v1/deliveries?size=1&page=0
GET http://localhost:9999/api/v1/couriers
...
```

Dependiendo de la versión del servicio, pueden existir endpoints adicionales para operaciones **CRUD**.

---

## Postman Collection

Para facilitar las pruebas de la API se incluye una colección de Postman **Algadelivery Delivery Tracking and Courier Management API**.

**Colección**

```
Docs/postman-collection.yml
```

---

## Ejecución del proyecto

### Requisitos

- Java 21
- Maven
- Docker Desktop
- Docker Compose

### Infraestructura (BD + Kafka)

Los servicios de infraestructura se levantan mediante:

```bash
docker compose up -d
```

---

## Origen del proyecto

Este proyecto fue desarrollado siguiendo el curso:

**AlgaWorks - Ignição Microsserviços**

https://app.algaworks.com/meus-cursos/ignicao-microsservicos

---

## Git

### Repositorio

https://github.com/arellano84/AlgaDelivery
