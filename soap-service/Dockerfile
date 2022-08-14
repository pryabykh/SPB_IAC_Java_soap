FROM amazoncorretto:8

WORKDIR /app

COPY . .

RUN ./mvnw install

VOLUME /tmp

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/soap-service-0.0.1-SNAPSHOT.jar"]