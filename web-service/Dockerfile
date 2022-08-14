FROM amazoncorretto:8

WORKDIR /app

COPY . .

RUN ./mvnw install

VOLUME /tmp

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "target/web-service-0.0.1-SNAPSHOT.jar"]