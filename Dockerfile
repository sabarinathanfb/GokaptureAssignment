# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/BlogApi-0.0.1-SNAPSHOT.jar /app/BlogApi.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/BlogApi.jar"]
