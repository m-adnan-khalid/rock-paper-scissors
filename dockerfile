# Step 1: Use Java 21 JDK image
FROM eclipse-temurin:21-jdk-alpine

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the built jar file from your machine to the container
COPY target/rock-paper-scissors-0.0.1-SNAPSHOT.jar /app/rock-paper-scissors.jar

# Step 4: Expose port 8080 (default for Spring Boot)
EXPOSE 8585

# Step 5: Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "rock-paper-scissors.jar"]