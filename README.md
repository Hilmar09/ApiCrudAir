# Air Quality Recommendation and Education Platform

## Description

The Air Quality Recommendation and Education Platform is an application that allows users to register and share recommendations based on the air quality of a specific city. Users can view the current air quality and read recommendations from other users who have been in the city, providing an educational and awareness platform about air quality.

## CRUD Functionality

The application provides the following CRUD functionalities for user recommendations:

- **Create**: Allow users to add new recommendations based on air quality.
- **Read**: Allow users to view existing recommendations and the current air quality of different cities.
- **Update**: Allow users to edit their previously added recommendations.
- **Delete**: Allow users to delete their recommendations.

## Additional Features

- **Authentication for users and administrators**: Allow users to register and log in to add, update, or delete recommendations.
- **Filters to search and categorize recommendations**: Allow users to search recommendations by city, air quality, and other relevant criteria.
- **Notifications about new recommendations and air quality alerts**: Notify users about new recommendations and significant changes in air quality.

## Application Architecture

The application is divided into two main components:

### Backend (Spring Boot)

The backend handles the business logic and data persistence. The technologies and dependencies used include:

- **Spring Web**: To build the REST API.
- **Spring Data JPA**: For data persistence management.
- **Spring Security**: For user authentication and authorization.
- **H2 Database (or MySQL)**: For the database.
- **Lombok**: To reduce boilerplate code.
- **Spring Boot DevTools**: To facilitate development.

#### Project Configuration

1. **Create a new Spring Boot project** using Spring Initializr.
2. **Select the following dependencies**: Spring Web, Spring Data JPA, Spring Security, H2 Database (or MySQL), Lombok, Spring Boot DevTools.
3. **Configure the `application.properties` file** for database connection and security settings.
4. **Implement JPA entities** for recommendations and users.
5. **Create REST controllers** to handle CRUD operations and authentication.
6. **Implement services and repositories** for business logic and data access.
7. **Configure Spring Security** to handle authentication and authorization.


## Testing

Extensive testing has been conducted on both the backend and frontend to ensure the functionality and stability of the application.

### Backend

- **Unit and integration tests** using JUnit and Mockito.
- **Tests for REST controllers** to verify CRUD operations and authentication.





