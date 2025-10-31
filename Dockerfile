# Use official lightweight Java 17 JDK image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot jar into the container
COPY target/buyacar-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 to host
EXPOSE 8080

# Command to run the jar
ENTRYPOINT ["java","-jar","app.jar"]
