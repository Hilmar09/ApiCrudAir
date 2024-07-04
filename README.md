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

- **Authentication for users**: Allow users to register and log in to add, update, or delete recommendations.
- **Filters to search and categorize recommendations**: Allow users to search recommendations by city, air quality, and other relevant criteria.
- **Notifications about new recommendations and air quality alerts**: Notify users about new recommendations and significant changes in air quality.

## Application Architecture

The application is divided into two main components:

### Backend (Spring Boot)

The backend handles the business logic and data persistence. The technologies and dependencies used include:

- **Spring Web**: To build the REST API.
- **Spring Data JPA**: For data persistence management.
- **MySQL Database**: For the database.
- **Spring Boot DevTools**: To facilitate development.

#### Project Configuration

clone the repository
configure the database Mysql with a database named user


1. **clone the repository** `using git clone https://github.com/Hilmar09/ApiCrudAir.git`
2. **configure the database Mysql**: with a database named user
3. **runs the project**
  
## Testing

Extensive testing has been conducted on both the backend and frontend to ensure the functionality and stability of the application.

### Backend

- **Unit and integration tests** using JUnit and Mockito.
- **Tests for REST controllers** to verify CRUD operations and authentication.

## Use the API

- **To get the users** request get to `/user`.
- **Request a user** by their id `/user/{id}`.
- **Add new user** `/user` by POST with Json 
`{
  "firstName: "name",
  "lastName": "lastname",
  "allergic": true,
  "email": "email@email.com",
  "password": "examplePassWord"
}`.
- **Delete a user** by their id `/user/{id}`.
- **To modify** request PUT with the Jason pass id:
 `{
    "id": 2,
    "firstName": "null",
    "lastName": "null",
    "email": "javier@gmail.com",
    "allergic": true,
    "password": "49"
  }`
