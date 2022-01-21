# Cinema app 

That application is designed to easily manage authentication and authorization of users and allow them to buy tickets for cinema.
Users and admins have different permissions.
That was achieved by implementing Spring Security.
Application also was designed considering REST principles.


### Implemented functionality

- registration, authentication and authorization 
- completing orders with multiple tickets
- shopping cart implementation
- filter movie sessions by date, time and films
- creating, deleting and patching all Entities via DAO

and many more

## Project structure

### Project is composed of 3 layers: 

1) DAO: MySQL database that contains all data and regulates with Hibernate. 
2) Service: grants logic to process data from DAO.  
3) Controller: responsible for navigation and communication with client. Regulates by Spring API.

### Relation between Entities is similar to table below 

<img src="src/images/ticket-app-diagram.png" width="800" alt="12">

## Roles and Authorization

One of that projects main feature is roles and their importance. 
Unauthorized user only have access to POST:/register 

Admins are able to do such requests:
- POST:/cinema-halls
- POST:/movies 
- POST:/movie-sessions
- GET:/users/by-email
- PUT:/movie-sessions/**
- DELETE:/movie-sessions/**

Endpoints that could be accessed by users:
- POST:/orders/complete
- GET:/orders 
- GET:/shopping-carts/by-user
- PUT:/shopping-carts/movie-sessions

Both user and admin have access to these endpoints:
- GET:/cinema-halls
- GET:/movies
- GET:/movie-sessions/available
- GET:/movie-sessions/**

## Technologies

- Java 11
- Tomcat 9.0.50
- Hibernate 
- MySQL
- Spring: Spring Core, Spring Security, Spring WEB
- Postman 
- Maven

## How to run project

1. Java 11.0.12 version recommended
2. Tomcat 9.0.50 must be installed and configured
3. MySQL 8.0.27 and it's workbench must be installed
4. configure db.properties to access database
5. Run project

User with email - "admin@mail.ua", password - "admin123" and role - "ADMIN" is already created in DataInitializer class.
As well as user with email - "user@mail.ua", password - "user123" and role - "USER".

###### Some data like movies, sessions and other could be initialized in "src/main/java/cinema/config/DataInitializer".