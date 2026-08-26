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

## JDBC Fundamentals

The JDBC practice project focuses on database connectivity and core JDBC operations using PostgreSQL.

### Learned

- JDBC database connectivity with `DriverManager`
- `Connection`, `Statement`, and `ResultSet`
- `executeQuery()` and `executeUpdate()`
- CRUD operations: `INSERT`, `SELECT`, `UPDATE`, `DELETE`
- `PreparedStatement` and parameterized SQL
- Batch processing with `addBatch()` and `executeBatch()`
- Transaction management with `commit()` and `rollback()`
- `DatabaseMetaData` and `ResultSetMetaData`
- Try-with-resources for JDBC resource management
- Maven dependency management for the PostgreSQL JDBC driver

### Project Structure

```text
jdbc-practice/
├── pom.xml
└── src/
    └── main/
        └── java/
            ├── Main.java
            ├── ConnectionDemo.java
            ├── StatementDemo.java
            ├── CrudDemo.java
            ├── PreparedStatementDemo.java
            ├── BatchDemo.java
            ├── TransactionDemo.java
            └── MetadataDemo.java
            
```         

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
```

## Hibernate Fundamentals

The Hibernate practice project covers ORM fundamentals, JPA entity mapping, persistence, HQL, entity lifecycle, persistence context, transactions, relationships, and fetch strategies using PostgreSQL.

### Hibernate Setup

- Maven project setup
- Hibernate ORM dependency configuration
- PostgreSQL JDBC driver
- `hibernate.cfg.xml`
- Database connection and dialect configuration
- `SessionFactory` creation
- `Session` management
- `SessionFactory` lifecycle and resource management

### JPA Entity Mapping

- `@Entity`
- `@Id`
- `@GeneratedValue`
- `@Column`
- `@Table`
- Entity-to-table mapping
- Field-to-column mapping
- Generated primary keys

### Session & Transactions

- `SessionFactory`
- `Session`
- `Transaction`
- `beginTransaction()`
- `commit()`
- `rollback()`
- Transaction boundaries
- Basic transaction failure handling

### Entity Lifecycle

- Transient state
- Persistent state
- Detached state
- `persist()`
- `detach()`
- Entity state transitions
- Dirty checking of persistent entities

### CRUD Operations

- `persist()` for inserting entities
- `find()` for retrieving entities
- `getReference()` for obtaining entity references
- Updating persistent entities
- Automatic updates through dirty checking
- `remove()` for deleting entities

### HQL

- HQL `SELECT`
- `WHERE` conditions
- Parameterized HQL queries
- `LIKE`
- `ORDER BY`
- Aggregate functions
- `COUNT()`
- `AVG()`
- HQL `JOIN`
- `JOIN FETCH`

### Query API

- `createQuery()`
- Typed HQL queries
- `setParameter()`
- `getResultList()`
- `getSingleResult()`

### Persistence Context

- Persistence context
- First-level cache
- Entity identity within a persistence context
- Dirty checking
- `flush()`
- `refresh()`
- `clear()`
- `detach()`
- Synchronization between entities and the database

### Entity Relationships

- Entity relationships and foreign keys
- `@OneToMany`
- `@ManyToOne`
- `mappedBy`
- Relationship ownership
- Cascade operations
- Bidirectional relationships
- Collection mapping
- Foreign-key based associations

### Fetch Strategies

- `FetchType.LAZY`
- `FetchType.EAGER`
- Lazy loading
- Explicit initialization of lazy associations
- `JOIN FETCH`
- Difference between lazy and eager loading

### Exception Handling

- Hibernate exception handling
- Transaction failure handling
- Rollback on operation failure
- Handling invalid entity operations
- Resource cleanup with try-with-resources

### Project Structure

```text
hibernate-practice/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   ├── ConfigurationDemo.java
│       │   ├── CrudDemo.java
│       │   ├── EntityLifecycleDemo.java
│       │   ├── ExceptionDemo.java
│       │   ├── FetchTypeDemo.java
│       │   ├── HibernateUtil.java
│       │   ├── HqlDemo.java
│       │   ├── Laptop.java
│       │   ├── Main.java
│       │   ├── PersistenceContextDemo.java
│       │   ├── RelationshipDemo.java
│       │   ├── Student.java
│       │   └── TransactionDemo.java
│       └── resources/
│           └── hibernate.cfg.xml