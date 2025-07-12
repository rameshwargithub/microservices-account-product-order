
FROM openjdk:17-jdk

COPY target/product-service.jar /usr/app/

WORKDIR /usr/app

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "product-service.jar"]
