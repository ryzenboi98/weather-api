FROM openjdk:8-alpine
COPY weather-api.jar weather-api.jar
ENTRYPOINT ["java", "-jar","/weather-api.jar"]
