# Java Backend Fundamentals

A hands-on learning repository documenting my journey through Java backend development.
This repository contains small practice projects and experiments covering core Java backend technologies, persistence, web development, and the Spring ecosystem.

## Learning Roadmap

The projects are organized as individual learning modules:

- JDBC
- Servlets
- Hibernate
- Spring Core
- Spring Java Configuration
- Spring XML Configuration
- Spring JDBC
- Spring Data JPA
- Spring MVC
- Spring Boot

## Projects

| Project | Topics |
|---|---|
| `jdbc-practice` | JDBC, database connections, SQL, CRUD |
| `servlet-practice` | Servlets, HTTP, Tomcat, request/response |
| `hibernate-practice` | Hibernate ORM, entities, sessions, persistence |
| `spring-java-configuration` | Spring IoC and Java-based configuration |
| `spring-xml-configuration` | Spring IoC and XML-based configuration |
| `spring-jdbc` | Spring JDBC and database access |
| `spring-data-jpa-demo` | Spring Data JPA and repository abstraction |
| `spring-boot-mvc-demo` | Spring Boot, MVC, controllers, web applications |

## Servlet Fundamentals

### Learned

- Embedded Tomcat
- Servlet registration and URL mapping
- Context path vs servlet path
- HTTP request and response
- `HttpServletRequest`
- `HttpServletResponse`
- `doGet()`, `doPost()`, `doPut()`, `doDelete()`
- Servlet lifecycle: `init()` and `destroy()`

### Example

The Servlet practice project uses embedded Tomcat and maps:

```text
http://localhost:8080/greetings/hello