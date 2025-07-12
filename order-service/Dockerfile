
FROM openjdk:17-jdk

COPY target/order-service.jar /usr/app/

WORKDIR /usr/app

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "order-service.jar"]
