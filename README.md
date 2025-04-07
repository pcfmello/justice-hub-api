# JUSTICE HUB API

## Description
Justice Hub API is a RESTful service designed to streamline case management. Built with Spring Boot, Java 17, and PostgreSQL and it features Liquibase for database versioning. The API includes user management, case tracking, and defendant records, ensuring data integrity and efficient legal process tracking.

## Used Technologies
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL 
- Liquibase
- Docker

## Installation and run
1. Clone the repository:
   ```bash
   git clone https://github.com/pcfmello/justice-hub-api.git
   ```
2. Enter the project directory:
   ```bash
   cd justice-hub-api
   ```
3. Configure database in `application.properties` file and `docker-compose.yml`.  

4. Run Docker Compose to build and up database:
   ```bash
   docker-compose up -d
   ```
5. Create a new database in Postgres with the same name as in `application.properties`.  

6. Run project with Maven:
   ```bash
   mvn spring-boot:run
   ```

## Endpoints
The API offers the following endpoints:

### Users
- `POST /users` - Save a new user.
- `GET /users/email/{email}` - Find user by email.

### LegalCases
- `POST /legal-cases` - Save a new legal case.
- `GET /legal-cases/user/{userId}` - Find legal cases by user id.
- `DELETE /legal-cases/{id}` - Delete a legal case.

### Defendants
- `POST /defendants` - Save a new defendant and add it to a legal case.

## Licence
MIT

