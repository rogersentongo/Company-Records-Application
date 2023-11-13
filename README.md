# 
# <h1 align="center"> Company-Records-Application </h1>
___ 
<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
    <a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.4-brightgreen.svg" />
</a>

---

<p align="left">

## Overview

Company Records Backend Application is a Spring Boot-based backend system using microservices architecture to provide CRUD operations on 3 services. Includes an API gateway server, configuration server and Messaging between services amongst other features. User can post information to all three services and retrieve it all from a single API gateway

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java 21
- **Database:** MySQL
- **Build Tool:** Maven
- **Documentation:** SpringDoc OpenAPI (Swagger UI)

## For a list of APIs Used and to make HTTP requests
- For the Department Service http://localhost:8080/swagger-ui/index.html#/
- For the Employee Service http://localhost:8081/swagger-ui/index.html#/
- For the Organization Service http://localhost:8083/swagger-ui/index.html#/
- In order to use the API gateway use http://localhost:9191/api/

## NOTE: PLEASE RUN THE INDIVIDUAL APPLICATIONS IN THE FOLLOWING ORDER
- SERVICE-REGISTRY
- CONFIG-SERVER
- DEPARTMENT-SERVICE
- ORGANIZATION-SERVICE
- EMPLOYEE-SERVICE
- API-GATEWAY

## Dependencies Used

The project utilizes the following dependencies:

- **Spring Boot Starter Data JPA**: Simplifies database access using Spring Data repositories.

- **Spring Boot Starter Web**: Provides support for building web applications, including RESTful APIs.

- **MySQL Connector/J (Runtime Dependency)**: The MySQL JDBC driver for connecting to MySQL databases.

- **Project Lombok (Optional)**: A library for reducing boilerplate code, such as getters and setters.

- **Spring Boot Starter Test (For Testing)**: Provides support for testing Spring Boot applications.

- **spring-cloud-starter-netflix-eureka-server**: Provides configuration and set up of Service Registry for the microservices.

- **spring-cloud-config-server**: Provides configuration and set up of Configuration server to handle application properties for different services.

- **spring-cloud-starter-gateway**: Provides configuration and set up of API gateway to handle requests from client side to all services.

- **spring-boot-starter-webflux**: Provides WebClient library used to configure and process messaging between services in the application.

- **Springdoc OpenAPI (Swagger UI)**: Adds Swagger UI for documenting and testing API endpoints.

- **Spring Boot Starter Validation**: Includes validation support for request data binding and response data rendering.

- **Other Dependencies:** Various other dependencies are included in the `pom.xml` file for specific functionalities, such as Jackson for JSON serialization, Spring Web for web-related features, and more.

Please refer to the project's `pom.xml` file for a comprehensive list of all dependencies and their respective versions.


## Project Structure

The project follows a clean and organized structure:

- **Main Application Class:** `DepartmentServiceApplication.java, EmployeeServiceApplication.java, OrganizationServiceApplication.java` serve as the entry point for each service application.
- **Entities/DTO:** The application includes Entities and DTO for each Service application
- **Configuration Server:** The `application.properties` file configures the database connection and Spring Data JPA properties. The Application uses a configuration server to store and update each service's configuration.
- **Service-Registry Server:** The application uses a service registry to help the Gateway API handle HTTP requests
- **API-Gateway server:** The application uses an API-Gateway server to handle requests from a client side application towards all the Services.
- **Messaging:** The application uses Spring WebClient to handle messaging between services.
- **Controller Classes:** These classes define and document the RESTful API endpoints for each Service.
- **Service Classes:** Business logic is implemented in service classes, ensuring separation of concerns.
- **Repository Interfaces:** Spring Data JPA repository interfaces manage data access to the underlying database.



## Database Details

The Application utilizes a separate MySQL database for each services to persist data for each service.

- **Database Engine:** MySQL


### Database Configuration

The database connection properties can be found in the `application.properties` file on the configuration repo of the configuration server:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/service_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```

Make sure to replace `your_username` and `your_password` with your actual MySQL credentials and also to replace `service_database` with appropriate database name for your service. 





