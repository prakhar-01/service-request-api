# 🚀 Service Request Management API — Spring Boot Backend

A Spring Boot REST API project that works like a **digital service/complaint register system** where service requests can be created, tracked, updated, and deleted.

Built using layered architecture with Controller → DTO → Service → Repository → JPA → MySQL.

---

# 📌 Project Idea (Simple Explanation)

Think of this system like a **service center office register**:

* Customer submits service request
* Reception checks the form
* Manager applies rules
* Clerk records it
* Register stores it

This backend API performs the same flow digitally using Spring Boot.

---

# 🏗️ Architecture (Layered Design)

```
CLIENT (Postman / App)
        |
        v
Controller Layer
(ServiceRequestController)
        |
        v
DTO Layer
(ServiceRequestCreateDto)
        |
        v
Service Layer
(ServiceRequestServiceImpl)
        |
        v
Repository Layer
(ServiceRequestRepository)
        |
        v
JPA / Hibernate
(Object ↔ SQL Mapping)
        |
        v
MySQL Database
(service_requests table)
```

---

# 🔄 Request Flow Example (Create Request)

```
POST /api/requests
        |
        v
Controller receives JSON
        |
        v
DTO validates input
        |
        v
Service applies rules
  - status = OPEN
  - createdAt timestamp
        |
        v
Repository.save()
        |
        v
Hibernate → INSERT SQL
        |
        v
MySQL stores record
        |
        v
JSON response returned
```

---

# 🧱 Tech Stack

* Java 21
* Spring Boot 3.x
* Spring Web (REST)
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Jakarta Validation
* Postman (testing)

---

# 📂 Project Structure

```
com.prakhar.servicerequest
 ├── controller
 │    └── ServiceRequestController
 ├── dto
 │    └── ServiceRequestCreateDto
 ├── entity
 │    └── ServiceRequest
 ├── repository
 │    └── ServiceRequestRepository
 ├── service
 │    ├── ServiceRequestService
 │    └── ServiceRequestServiceImpl
 └── ServiceRequestApiApplication
```

---

# 🌐 REST API Endpoints

## ➕ Create Request

```
POST /api/requests
```

Body:

```json
{
  "customerName": "Amit",
  "serviceType": "Fiber Install",
  "priority": "HIGH",
  "assignedTo": "Team-A"
}
```

---

## 📋 Get All Requests

```
GET /api/requests
```

---

## 🔍 Get By ID

```
GET /api/requests/{id}
```

---

## ✏️ Update Status

```
PUT /api/requests/{id}/status?status=CLOSED
```

---

## ❌ Delete Request

```
DELETE /api/requests/{id}
```

---

# ✅ Features Implemented

* REST API CRUD operations
* Layered architecture
* DTO pattern
* Input validation (@NotBlank)
* Business logic in service layer
* Auto timestamp handling
* JPA-based persistence
* Automatic table creation
* MySQL integration
* Postman tested APIs

---

# 🧪 Validation Example

If required fields are empty → API returns:

```
400 Bad Request
```

Handled using DTO + @Valid annotations.

---

# ⚙️ Local Setup Instructions

## 1️⃣ Create Database

```sql
CREATE DATABASE service_db;
```

---

## 2️⃣ Configure application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/service_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 3️⃣ Run Application

Run:

```
ServiceRequestApiApplication
```

Server starts on:

```
http://localhost:8080
```

---

# 🧪 Test Using Postman

Use the endpoints listed above to test:

* create
* fetch
* update
* delete

---

# 🎯 Learning Outcomes

This project demonstrates:

* Spring Boot backend development
* Clean layered architecture
* DTO + validation pattern
* JPA & Hibernate ORM
* REST API design
* Database integration
* API testing workflow

---

# 🗣️ Interview Explanation (Short Version)

I built a Spring Boot layered REST API that manages service requests like a digital complaint register. The controller handles endpoints, DTO validates input, service applies business rules, repository persists using JPA, and MySQL stores the data.

---

# 📌 Status

Core backend system complete ✅
Ready for enhancements like:

* Swagger docs
* Global exception handler
* Pagination
* Authentication
* Dockerization

---
