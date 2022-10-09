FROM openjdk:17-jdk
ADD target/*.jar service-registry.jar
EXPOSE 9191
ENTRYPOINT ["java", "-jar", "service-registry.jar"]
