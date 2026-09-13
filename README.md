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
│       │   ├── springcore.Laptop.java
│       │   ├── Main.java
│       │   ├── PersistenceContextDemo.java
│       │   ├── RelationshipDemo.java
│       │   ├── Student.java
│       │   └── TransactionDemo.java
│       └── resources/
│           └── hibernate.cfg.xml
```
## Spring Core Fundamentals

The Spring Core practice project focuses on the Spring IoC container, dependency injection, bean configuration, component scanning, dependency resolution, bean scopes, and bean lifecycle management.

### Spring Setup

- Maven project setup
- Spring Context dependency
- `ApplicationContext`
- `AnnotationConfigApplicationContext`

### Inversion of Control (IoC)

- Inversion of Control
- Spring IoC container
- Object creation and dependency management by Spring
- `BeanFactory`
- `ApplicationContext`
- Difference between `BeanFactory` and `ApplicationContext`

### Dependency Injection

- Dependency Injection
- Constructor Injection
- Setter Injection
- Field Injection
- Dependency resolution by type

### Configuration

- `@Configuration`
- `@Bean`
- `@ComponentScan`
- Component Scanning
- Explicit bean configuration
- Difference between `@Bean` and `@Component`

### Stereotype Annotations

- `@Component`
- `@Service`
- `@Repository`
- `@Controller`
- Role of specialized stereotype annotations
- Automatic bean detection through component scanning

### Dependency Resolution

- `@Autowired`
- `@Qualifier`
- Resolving multiple beans of the same type
- `@Primary`
- Constructor-based dependency resolution
- Setter-based dependency resolution
- Qualifier placement on injection points

### Bean Scopes

- Singleton scope
- Prototype scope
- One singleton instance per `ApplicationContext`
- New prototype instance for each bean request
- Request scope — web-specific
- Session scope — web-specific

### Bean Lifecycle

- Bean instantiation
- Constructor execution
- Initialization phase
- `@PostConstruct`
- Bean usage
- `@PreDestroy`
- Bean destruction
- ApplicationContext startup and shutdown

### ApplicationContext Lifecycle

- Creating the `ApplicationContext`
- Bean creation during context startup
- Dependency injection
- Bean initialization
- Application execution
- Closing the `ApplicationContext`
- Bean destruction during context shutdown
- `context.close()`

### Project Structure
```text
spring-core/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── springcore/
                ├── AppConfig.java
                ├── IoCDemo.java
                ├── DependencyInjectionDemo.java
                ├── SetterInjectionDemo.java
                ├── FieldInjectionDemo.java
                ├── ComponentDemo.java
                ├── QualifierDemo.java
                ├── PrimaryDemo.java
                ├── BeanScopeDemo.java
                ├── BeanLifecycleDemo.java
                ├── ApplicationContextLifecycleDemo.java
                ├── StereotypeAnnotationsDemo.java
                └── BeanAnnotationDemo.java
```

## Spring XML Configuration

The Spring XML configuration practice project focuses on XML-based bean configuration, dependency injection, autowiring, bean scopes, lifecycle management, and modular XML configuration.

### XML Bean Configuration

- XML-based Spring bean configuration
- `ClassPathXmlApplicationContext`
- `<bean>` definitions
- Bean IDs and class mapping
- XML namespaces and schema configuration

### Dependency Injection

- Constructor Injection using `<constructor-arg>`
- Setter Injection using `<property>`
- Dependency references using `ref`
- Literal value injection using `value`
- Difference between `ref` and `value`

### XML Autowiring

- XML autowiring
- `autowire="byType"`
- Automatic dependency resolution by type
- Setter-based autowiring

### Bean Scopes

- Singleton scope
- Prototype scope
- One singleton instance per `ApplicationContext`
- New prototype instance for each bean request
- Request scope — web-specific
- Session scope — web-specific

### Bean Lifecycle

- Bean instantiation
- Initialization using `init-method`
- Bean usage
- Destruction using `destroy-method`
- ApplicationContext shutdown
- Singleton vs prototype destruction behavior

### Modular XML Configuration

- `<import>` for importing XML configuration files
- Splitting bean definitions across multiple configuration files
- Central configuration with imported module configurations

### Project Structure
```text
spring-xml-configuration/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── springxml/
        │       ├── XmlConfigDemo.java
        │       ├── XmlConstructorInjectionDemo.java
        │       ├── XmlSetterInjectionDemo.java
        │       ├── XmlAutowireDemo.java
        │       ├── XmlValueInjectionDemo.java
        │       ├── XmlScopeLifecycleDemo.java
        │       └── XmlImportDemo.java
        └── resources/
            ├── applicationContext.xml
            ├── constructor-config.xml
            ├── setter-config.xml
            ├── autowire-config.xml
            ├── value-config.xml
            ├── scope-lifecycle-config.xml
            ├── common-config.xml
            └── main-config.xml
```