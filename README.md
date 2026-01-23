# [E-commerce Backend]

![Java](https://img.shields.io/badge/Java-17-orange) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green) ![Docker](https://img.shields.io/badge/Docker-Enabled-blue)

## 📋 Description
RESTful API for inventory and purchase order management. This project simulates a real backend environment handling stock concurrency, transactions, and data persistence.

## 🚀 Tecnologías
* **Language:** Java 17/21
* **Framework:** Spring Boot 3
* **Database:** PostgreSQL
* **Containerization:** Docker & Docker Compose
* **Testing:** JUnit 5 & Mockito

## ⚙️ Architecture
The system uses a layered architecture (Controller -> Service -> Repository) following SOLID principles.

## 🛠️ Installation and Execution (With Docker)
This project is Dockerized to facilitate deployment.

1. Clone the repository:
```bash
git clone [https://github.com/alan-villarreal-dev/ecommerce-backend.git](https://github.com/alan-villarreal-dev/ecommerce-backend.git)
```
2. Run with Docker Compose:
```bash
docker-compose up --build
```
3. The API will be available at: `http://localhost:8080/api`

## 🧪 Run Tests
To run unit tests:
```bash
./mvnw test