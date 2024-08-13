FROM openjdk:20-slim-buster


ADD target/personas-0.0.1-SNAPSHOT.jar personas.jar

# Make port 8080 available to the world outside this container
EXPOSE 8084

# Run the jar file
ENTRYPOINT ["java", "-jar", "personas.jar"]