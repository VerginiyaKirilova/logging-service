# 🎨 Logging Service
## 1. Overview
The Logging Service is a Spring Boot microservice, part of the larger Color Psychology project — a web design application that explains the psychological meaning of colors.

Originally created as a static HTML/CSS website, the main project was later migrated to Spring Boot (Maven) and enhanced with a color search feature. The Logging Service complements it by recording every search request, enabling analytics and user behavior tracking.

The service stores:
- The searched color
- The performed action (e.g., `SEARCH_COLOR`)
- The timestamp of the request
- The username (or `"anonymous"` for guest users)

**Project evolution:**
- Static website → project in HTML/CSS.
- Migration → Spring Boot Maven application with dynamic search.
- Extension → Added this microservice to log search actions.
- Deployment → Docker locally, then AWS (EC2 + RDS).

---

## 2. Tech Stack
- Java 17
- Spring Boot
- MySQL 8.0 (AWS RDS)
- Maven
- Docker & Docker Compose
- AWS EC2 (microservice hosting)
- AWS RDS (database hosting)

---

## 3. Architecture

   [ Frontend: Color Psychology Website ]
   |
   v
   [ Main Spring Boot Application ]
   |
   v
   [ Logging Service (Spring Boot) ]
   |
   v
   [ MySQL Database (AWS RDS) ]

---

## 4. Features
- REST API for logging search actions
- Persistent storage in AWS-hosted MySQL
- Local development possible via Docker
- Automatic table creation with JPA

**Example log entry:**
```json
{
  "id": 2,
  "action": "SEARCH_COLOR",
  "message": "Търсене на цвят: Червено",
  "timestamp": "2025-08-06T11:09:17.554409",
  "username": "anonymous"
}
```

## 5. Installation & Running Locally
   Step 1 — Clone the repository

```bash
git clone https://github.com/VerginiyaKirilova/logging-service.git
cd logging-service
```

Step 2 — Build the project

```bash

mvn clean package
```

Step 3 — Start with Docker Compose

```bash

docker compose up --build -d
```
Step 4 — Access the service

```bash

http://localhost:8081/api/logs
```
## 6. Configuration
Environment variables:

| Variable                 | Description                         |
|--------------------------|-----------------------------------|
| SPRING_DATASOURCE_URL    | JDBC connection URL (local/AWS RDS) |
| SPRING_DATASOURCE_USERNAME | Database username                 |
| SPRING_DATASOURCE_PASSWORD | Database password                 |


Example .env file:

SPRING_DATASOURCE_URL=jdbc:mysql://logging-db.c14u8ckmcbgc.eu-central-1.rds.amazonaws.com:3306/logging_db?serverTimezone=UTC
SPRING_DATASOURCE_USERNAME=admin
SPRING_DATASOURCE_PASSWORD=your_password


## 7. API Examples
Create a log entry:

```bash
curl -X POST http://localhost:8081/api/logs \
-H "Content-Type: application/json" \
-d '{
  "action": "SEARCH_COLOR",
  "message": "Търсене на цвят: Червено",
  "username": "anonymous"
}'
```
Get all log entries:

```bash
curl http://localhost:8081/api/logs
```

## 8. Deployment to AWS
   Microservice: Hosted on AWS EC2 (Dockerized)

Database: AWS RDS (MySQL 8.0)

Networking: Security groups configured for API and MySQL ports

Scalability: Can be replicated to multiple instances via Docker