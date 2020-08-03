# Install Java
FROM openjdk:14-jdk-slim
# Build
CMD ["./gradlew", "build"]
ARG JAR_FILE=build/libs/*.jar
# Change the jar file name to app.jar for ease of use
COPY ${JAR_FILE} app.jar
# Run the application. Springboot runs on port 8080 by default
ENTRYPOINT ["java","-jar","/app.jar"]