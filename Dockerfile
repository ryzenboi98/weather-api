FROM openjdk:11
COPY target/weather-api.jar weather-api.jar
ENTRYPOINT ["java", "-jar","/weather-api.jar"]