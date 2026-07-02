# Interview API Boilerplate

Spring Boot starter project for backend API interview rounds.

## Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Validation
- Spring Data JPA
- PostgreSQL driver

## Run locally

```bash
mvn spring-boot:run
```

Set `DB_PASSWORD` before starting if you want to override the bundled database password.

## Included boilerplate

- Project structure for controller, service, repository, dto, entity, and config layers
- PostgreSQL configuration
- JWT auth

## Auth endpoints

- `POST /api/v1/auth/register`
- `POST /api/v1/auth/token`

Use the returned JWT as `Authorization: Bearer <token>` for protected endpoints.