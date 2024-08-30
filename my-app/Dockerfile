FROM openjdk:17
LABEL authors="mohamedogleh"

WORKDIR /app

COPY target/my-app-0.0.2.jar  app/greeting.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","app/greeting.jar"]