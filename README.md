Spring Boot, MySQL, JPA, Hibernate , Swagger,JaCoCo ,flyway Rest API Tutorial

Build Restful CRUD API for Request Tracking System using Spring Boot, Mysql, JPA and Hibernate.
Requirements

    Java - 1.8.x

    Maven - 3.x.x

    Mysql - 5.x.x

Steps to Setup

1. Clone the application

git clone https://github.com/AkhileshPandey300/RequestTracking.git

2. Create Mysql database

create database TrackingSystem

3. Change mysql username and password as per your installation

    open src/main/resources/application.properties

    change spring.datasource.username and spring.datasource.password as per your mysql installation

4. Build and run the app using maven

mvn package
java -jar target/RequestTracking-1.0.0.jar

Alternatively, you can run the app without packaging it using -

mvn spring-boot:run

The app will start running at http://localhost:8888/Tracking.
Explore Rest APIs

The app defines following End Points.

POST /accounts/

GET /accounts/

PUT /accounts/{id}

GET /accounts/{firstName}/{lastName}

POST /contacts/

POST /servicerequests

GET /servicerequests/{srnumber}

PUT /servicerequests/{srnumber}

GET /servicerequests/{specs}

GET /servicerequests

POST /servicerequests/activity

You can test them using postman or you can use swagger interface at given URL.

http://localhost:8888/Tracking/swagger-ui.html
