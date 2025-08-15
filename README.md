E-commerce App Backend API
This is a a fully functional RESTful API for a simple e-commerce application. It was built using modern Java and the Spring Boot framework.

Features
CRUD Operations: Complete functionality to Create, Read, Update, and Delete products.

RESTful Endpoints: Well-defined API endpoints for all operations.

Database: Uses an in-memory H2 database for local development and a Dockerized build for cloud deployment.

Version Control: Project is managed with Git and hosted on GitHub.

Technologies Used
Java 17

Spring Boot 3.5.4

Maven

Spring Data JPA

H2 Database

Render (for deployment)

Deployment
This application is deployed on Render and can be accessed at the following public URL:

https://e-commerce-backend-api-1c2f.onrender.com

How to Run Locally
Clone this repository to your local machine.

Ensure you have JDK 17 installed.

Navigate to the project's root directory in your terminal.

Run the application using the Maven Wrapper:
./mvnw spring-boot:run

The application will be available at http://localhost:9090.

API Endpoints
All endpoints are publicly accessible for this version.

Products API (/api/products)
Method

Endpoint

Description

GET

/api/products

Retrieve a list of all products.

GET

/api/products/{id}

Retrieve a single product by ID.

POST

/api/products

Add a new product to the database.

PUT

/api/products/{id}

Update an existing product by ID.

DELETE

/api/products/{id}

Delete a product by ID.

