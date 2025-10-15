# Task Management Web Application

## Overview
Task Management Web Application is a Spring Boot-based RESTful API that allows users to manage personal tasks efficiently. It supports creating, updating, deleting, and retrieving tasks, including filtering by status, overdue tasks, sorting by due date, and viewing deleted tasks. The application uses MySQL for persistent storage and integrates Swagger for API documentation and testing.

## Features
- Create, update, and delete tasks (soft delete)
- Retrieve all tasks or a specific task by ID
- Filter tasks by status (PENDING, COMPLETED)
- Retrieve overdue tasks
- Sort tasks by due date
- View all deleted tasks
- Swagger UI for interactive API documentation

## Technologies Used
- Java 18
- Spring Boot
- Spring Data JPA
- MySQL
- Springdoc OpenAPI / Swagger
- Maven
- H2 Database (optional for in-memory testing)
- RESTful API

## Database Configuration
MySQL database configuration in `application.properties`:
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

## API Endpoints
- `POST /api/v1/tasks` - Create a new task
- `GET /api/v1/tasks` - Retrieve all tasks
- `GET /api/v1/tasks/{id}` - Retrieve a task by ID
- `GET /api/v1/tasks/status?status=PENDING/COMPLETED` - Retrieve tasks by status
- `GET /api/v1/tasks/overdue` - Retrieve overdue tasks
- `PUT /api/v1/tasks/{id}` - Update a task by ID
- `DELETE /api/v1/tasks/{id}` - Soft delete a task
- `GET /api/v1/tasks/sort` - Retrieve tasks sorted by due date
- `GET /api/v1/tasks/deleted` - Retrieve all deleted tasks

## Swagger API Documentation
Access the Swagger UI to explore and test the APIs:

`http://localhost:8080/swagger-ui.html`

## Setup Instructions
1. Clone the repository.
2. Configure MySQL database and update `application.properties` with your credentials.
3. Build the project using Maven:
4. Run the application:
5. Access Swagger UI at `http://localhost:8080/swagger-ui.html` to test the APIs.

## License
This project is licensed under the MIT License.
