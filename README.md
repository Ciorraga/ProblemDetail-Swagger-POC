# ProblemDetail-Swagger-POC

Proof of concept of a Spring Boot 3 application that demonstrates exception handling with RFC 9457 `ProblemDetail` responses and Swagger UI documentation.

## Tech Stack

- Java 21
- Spring Boot 3.5.13
- Spring Web
- springdoc OpenAPI / Swagger UI
- Maven

## Purpose

This repository is a small reference project to show:

- how custom exceptions can be translated into HTTP `ProblemDetail` responses
- how Spring Boot 3 exposes the native `org.springframework.http.ProblemDetail` model
- how to inspect those responses through Swagger UI

## Endpoints

- `GET /badRequest`
- `GET /notFound`
- `GET /unauthorized`
- `GET /internalServerError`

Each endpoint throws a different exception so the global exception handler can return the corresponding `ProblemDetail` payload.

For simplicity, this POC intentionally returns a minimal `ProblemDetail` body with:

- `title`
- `status`
- `detail`
- `instance`

The `type` field is intentionally omitted because this project does not define a dedicated problem type catalog.

## Running Locally

From the project root:

```bash
mvn spring-boot:run
```

The application is available at `http://localhost:8080` and Swagger UI at `http://localhost:8080/swagger-ui.html`.
