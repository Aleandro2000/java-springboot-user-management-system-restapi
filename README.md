# User Management CRUD API

A simple Spring Boot project that provides a **CRUD REST API** for
managing users.\
The project uses **Spring Boot, Spring Data JPA, Hibernate Validation,
PostgreSQL, and Docker**.

------------------------------------------------------------------------

## Features

-   Create a user\
-   Retrieve all users\
-   Retrieve a user by ID\
-   Update a user\
-   Delete a user\
-   Input validation (email, phone, required fields)\
-   Standardized JSON responses

------------------------------------------------------------------------

## Tech Stack

-   **Java 17**\
-   **Spring Boot 3**\
-   **Spring Data JPA**\
-   **PostgreSQL**\
-   **Hibernate Validator**\
-   **Docker & Docker Compose**

------------------------------------------------------------------------

## API Endpoints

Base URL: `/api/v1/user`

  Method   Endpoint         Description
  -------- ---------------- -------------------------
  GET      `/list`          Get all users
  GET      `/{id}`          Get user by ID
  POST     `/create`        Create a new user
  PUT      `/update/{id}`   Update an existing user
  DELETE   `/delete/{id}`   Delete user by ID

------------------------------------------------------------------------

## Run with Docker

Build and run with Docker Compose:

``` bash
docker-compose up --build
```

API will be available at:\
`http://localhost:8080/api/v1/user`

Database will be available at:\
`localhost:5432` (Postgres)

------------------------------------------------------------------------

## Example Response

``` json
{
  "success": true,
  "message": "User created successfully",
  "data": {
    "id": 1,
    "fullName": "John Doe",
    "email": "john@example.com",
    "phoneNumber": "+1234567890",
    "description": "Test user"
  }
}
```