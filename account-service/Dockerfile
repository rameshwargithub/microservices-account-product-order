
FROM openjdk:17-jdk

COPY target/account-service.jar /usr/app/

WORKDIR /usr/app

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "account-service.jar"]
