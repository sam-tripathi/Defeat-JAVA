# Sample Spring Boot Application using PostgreSQL:

Structure:
```java
class Student {
    private Long id;
    private String name;
    private int age;
    private LocalDate dob;
    private String email;
}
```
Student Class with Primary Key Id for PostgreSQL.

API Endpoints:
- **GET /api/v1/student**: Get Array of Students
- **POST /api/v1/student**: Create a new student and store in Database
- **DELETE /api/v1/student/:studentId**: Delete a student with Id
- **PUT /api/v1/student/:studentId**: Alter Student information with Id

Built using the **MVCS** architechture.
Code split into Model, Controller and Service.

### Install
- Clone the repo to local machine using `git clone git@github.com:sam-tripathi/Defeat-JAVA.git`
- `cd` into **SIMPLE PROJECTS/SpringSample**
- Open Project in IntelliJ and install depenedencies from pom.xml
- Replace **username** and **password** in **src/main/resources/application.properties** with your database credentials
- Start Server by pressing `Ctrl + Shift + F10`

Test using **Insomnia / Postman REST Client**

___

Credits [Spring Boot Tutorial by Amigoscode](https://www.youtube.com/watch?v=9SGDpanrc8U)
