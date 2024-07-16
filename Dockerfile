FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/casino-romania*.jar .

RUN mv casino-romania*.jar app.jar

CMD ["java", "-jar", "app.jar"]