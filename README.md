# Multi-Database Aggregation Service

This Spring Boot service aggregates user data from multiple databases and provides a single endpoint (`GET /users`) for accessing this data.

### Prerequisites
- Docker & Docker Compose

### Running the Application

1. Build and run the application with Docker Compose:
   ```bash
   docker compose -f docker-compose.yml up
   ```
    
- Spring Boot application at port 8080
- Two instances of Postgres database at ports 5432 and 5433
- Two instances of Oracle database at ports 1521 and 1522
- Two liquibase instances to run the database migrations for Postgres and Oracle databases
- Migration scripts for Postgres and Oracle databases are located in `changelog` directory
 
   
2. Access the application at `http://localhost:8080/users`.


3. Documentation can be accessed at `http://localhost:8080/swagger-ui.html`.

### Stopping the Application

To stop the application, press `Ctrl+C` in the terminal where the application is running, and then run:
```bash
docker compose -f docker-compose.yml down
```

