FROM openjdk:20-jdk
COPY target/*.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]