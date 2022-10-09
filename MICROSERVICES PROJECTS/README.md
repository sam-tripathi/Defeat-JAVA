PROJECT STRUCTURE
-
---

This is Project Folder Structure For Microservices Application
- api-gateway
- discovery-client
- user-service
- department-service

---


You can add your service on this project and registry service into
(`dicovery-client/src/main/resources/application.yml`) in folder discovery client

```yml
spring:
  application:
    name: SERVICE-REGISTRY
  cloud:
    gateway:
      routes:
        - id: <SERVICE-ID>  #Input ur service ID Here
          uri: lb://<SERVICE-ID> #Input ur service ID Here
          predicates:
            - Path=/<API_PATH>/** #Input ur service Api Url Here
```