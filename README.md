# microservices-account-product-order

A simple microservices-based system built using Java, Spring Boot, Docker, and Swagger. This project demonstrates basic CRUD functionality for three services and containerization using Docker.

# Project Structure
This is a multi-module Maven project consisting of:

account-service: Manages user accounts (H2 in-memory DB)

product-service: Manages product listings (MongoDB)

order-service: Manages orders (MySQL)

# Tech Stack
Java 17

Spring Boot 3+

Spring Web, Spring Data JPA, Spring Data MongoDB

Docker & Docker Compose

OpenAPI (Swagger UI)

H2, MySQL, MongoDB

# Build & Run Lifecycle
1. ## Clean and Build All Microservices
From the root directory, run:

bash
Copy
Edit
mvn clean install

2. ## Dockerize Each Microservice
Navigate to each microservice folder and build Docker images:

bash
Copy
Edit
cd account-service
docker build -t account-service-img .

cd ../product-service
docker build -t product-service-img .

cd ../order-service
docker build -t order-service-img .

3. ## Run Containers
Make sure MongoDB and MySQL are running. You can use Docker Compose or run them manually:

bash
Copy
Edit
# MongoDB
docker run -d -p 27017:27017 --name mongodb mongo

# MySQL
docker run -d -p 3306:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=orders mysql


# run on Docker:

bash
Copy
Edit
docker run -d -p 8081:8081 --name account-service account-service-img
docker run -d -p 8080:8080 --name product-service product-service-img
docker run -d -p 8082:8082 --name order-service order-service-img
# Service Endpoints
Microservice	Base URL	Description
User Service	http://localhost:8081/account-apis	CRUD for user accounts
Product Service	http://localhost:8080/product-apis	CRUD for products
Order Service	http://localhost:8082/order-apis	CRUD for orders

# API Documentation (Swagger UI)
Each microservice includes Swagger UI for API testing and documentation:

User Service: http://localhost:8081/account-apis/swagger-ui.html

Product Service: http://localhost:8080/product-apis/swagger-ui.html

Order Service: http://localhost:8082/order-apis/swagger-ui.html

# Service Communication
Order Service makes REST calls to the User Service to validate user data before processing orders.

Use RestTemplate or WebClient in Order Service to call:
GET http://localhost:8081/account-apis/account/{userId}

# Health Checks (Bonus)
Each microservice has a basic health check endpoint:

http
Copy
Edit
GET /actuator/health
You can enable this by adding in application.properties:

properties
Copy
Edit
management.endpoints.web.exposure.include=health
# Testing Instructions
Build the services.

Run MongoDB and MySQL.

Start containers for each microservice.

Use Swagger UI or Postman to test each API.

Test inter-service communication by creating a user, then placing an order with that user ID.

# Source Code Structure (Sample)


microservices-account-product-order/
├── account-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── product-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── order-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
└── pom.xml (parent)

# Author
Rameshwar Prasad Meena
Backend Java Developer | Spring Boot | REST API | Docker
