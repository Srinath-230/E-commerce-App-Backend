# Stage 1: Build the application using a Maven and OpenJDK 17 image
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file to download dependencies
COPY pom.xml .

# Copy the source code
COPY src ./src

# Build the project, skipping tests
RUN mvn clean package -DskipTests

# Stage 2: Create a smaller, final image for deployment
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the 'build' stage
# The JAR file is created in the /app/target directory
COPY --from=build /app/target/*.jar app.jar

# Expose the port your Spring Boot application runs on
EXPOSE 9090

# Command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
