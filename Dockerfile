# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set Environment variable
ENV DB_URL=jdbc:mysql://host.docker.internal:3306/gokaptureAssignment
ENV DB_USERNAME=root
ENV DB_PASSWORD=root

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/BlogApi-0.0.1-SNAPSHOT.jar /app/BlogApi.jar


# Run the application
ENTRYPOINT ["java", "-jar", "/app/BlogApi.jar"]
