# Use the official OpenJDK 17 slim image as the base image
FROM openjdk-17-jdk-slim

# Copy the Spring Boot application JAR file to the container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# Specify the entry point for the container to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]