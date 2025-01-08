# SprintPlanner

SprintPlanner is a sprint and task management application designed to help users efficiently plan, track, and complete their sprints and task efficiently. Built with Spring Boot, this project demonstrates the use of Front Controller architecture, JSP for views, and various features like validation, Spring Security, and database integration.

---

## Features
# Web App Concepts:
- **Request and Response Lifecycle**
- **Forms and Data Submission**
- **Session Management**
- **User Authentication and Authorization**

# Spring MVC Architecture:
- **Dispatcher Servlet** for central request handling.
- **Model, View, and Controller (MVC)** separation.
- **View Resolvers** for dynamic JSP rendering.
- **Validations** for user inputs.

# Spring Boot:
- **Simplified setup** using Starters.
- **Automatic configuration** for integrated frameworks.
- **Embedded server** for hassle-free deployment.

---

- **Front Controller Architecture**: A centralized controller manages the flow of the application.
- **Login Page**: Secure user authentication with basic Spring Security and a custom encoder.
- **Manage To-Do and Sprints**: Create, view, edit, and delete tasks and sprints.
- **Session vs Model vs Request**: Demonstrates proper use of these scopes in Spring MVC.
- **Dynamic JSP Views**: Display and manage data using JSP with JSTL.
- **Sprint Table with Bootstrap Styling**: Responsive UI for displaying sprints using Bootstrap CSS.
- **Form Validations**: Ensures user inputs are valid before processing.
- **H2 Database Integration**: Stores all application data persistently.

---

---

## Key Concepts

### Front Controller Architecture
- All HTTP requests are routed through a central dispatcher, ensuring a unified entry point for the application.

### Login and Security
- User authentication using **Spring Security**.
- Custom password encoder for secure credential's management.

### JSP and JSTL
- JSP (Java Server Pages) is used to render dynamic content.
- JSTL (JavaServer Pages Standard Tag Library) simplifies logic in JSP files.

### Bootstrap and WebJars
- Integrated Bootstrap for responsive design using **WebJars** for version control and easy integration.

### H2 Database
- A lightweight, in-memory database used for storing tasks and sprints.
- Data persistence is handled using Spring Data JPA.

---
## Troubleshooting JSP 404 Errors in Spring Boot

If you encounter a `404 Not Found` error or the Whitelabel Error Page when trying to load a JSP page in a Spring Boot application, refer to the following Stack Overflow discussion for solutions and best practices:

[Spring Boot JSP 404 Whitelabel Error Page](https://stackoverflow.com/questions/43847924/spring-boot-jsp-404-whitelabel-error-page)


## Spring MVC Front Controller - Dispatcher Servlet

It is a Spring MVC implementation of the Model-2 Front Controller Pattern

### How does dispatcher servlet works ?

It is the one which access the "Front Controller"
So, all the requests are received by "Dispatcher Servlet".

A. Receive HTTP Request
B. Processes HTTP Request -> (To process, it's use model,view & controller (MVC))
    B1. Identifies correct Controller method
        - Based on request URL
    B2. Executes Controller method
        - Returns Model & View name
    B3. Identifies correct view
        - By using "View Resolver", configuring prefix and suffix
    B4. Executes View
C. Return HTTP Response (View/JSP sent back as a response to the browser)

At a high level, this is the entire flow which happens for each request.

---
## Meaning of Encoded and Decoded in Password Context:
### Encoding:

Encoding is a process of converting data (like a password) into a different format so it can be safely transmitted or stored. It’s not meant for security but to ensure compatibility between systems.
Example: When you send a password over a network, it might be encoded in Base64 to avoid issues with special characters.
Example:

Original password: MyP@ssword123
Encoded in Base64: TXlQQHNzd29yZDEyMw==
If you decode this back, you'll get MyP@ssword123 again.

### Decoding:

Decoding is the process of converting the encoded data back to its original form.
Important: Encoding and decoding don’t protect your password from attackers because they can reverse the process if they know the encoding method.
More Secure Concept: Hashing (Not Reversible)
In password handling, hashing is commonly used instead of encoding:

Hashing converts a password into a unique, fixed-length string.
Hashing cannot be reversed (unlike encoding).
Example: Using the SHA-256 algorithm:
Original: MyP@ssword123
Hashed: c04d1a2b93b8fa49c3f8a86e9a7a1d1e6d12c92...
Even if someone gets the hashed value, they can’t easily reverse it to find the original password.

### Summary:
Encoding/Decoding: Changes the format for compatibility, but is reversible.
Hashing: Secures passwords by making them impossible to reverse, which is what websites usually use for storing passwords.

## Configuring H2 Database Persistence in Spring Boot

By default, Spring Boot configures H2 in **in-memory mode**, meaning all data is lost when the application stops. To make the H2 database persistent, you can switch it to a **file-based mode**.

## Steps to Make H2 Persistent in Spring Boot

### 1. Update `application.properties` 

Configure the H2 database to use file-based storage.

#### For `application.properties`:

```properties
spring.datasource.url=jdbc:h2:file:~/data/spring_app_db
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.hibernate.ddl-auto = update

```

### Additional Options for JDBC URL:

- `DB_CLOSE_ON_EXIT=FALSE`: Prevents the database from closing when the application stops.
- `AUTO_SERVER=TRUE`: Allows multiple connections to the database.

`spring.datasource.url=jdbc:h2:file:~/data/spring_app_db;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE`

## MySQL Database Configuration

### 1. **Database URL**
- **Property:** `spring.datasource.url`
- **Description:** Specifies the JDBC URL for the MySQL database connection.
- **Value:** `jdbc:mysql://localhost:3307/sprints`
    - `localhost`: Refers to the database host (local machine in this case).
    - `3307`: The port number where the MySQL server is running.
    - `sprints`: The name of the database being used.

### 2. **Database Username**
- **Property:** `spring.datasource.username`
- **Description:** Defines the username required to connect to the MySQL database.
- **Value:** `sprints-user`

### 3. **Database Password**
- **Property:** `spring.datasource.password`
- **Description:** Specifies the password associated with the database user for authentication.
- **Value:** `dummysprints`

---

## Hibernate Configuration

### 1. **Hibernate Dialect**
- **Property:** `spring.jpa.properties.hibernate.dialect`
- **Description:** Configures the Hibernate dialect to match the database being used. It optimizes Hibernate's SQL generation for the specified database.
- **Value:** `org.hibernate.dialect.MySQL8Dialect`

### 2. **DDL Auto**
- **Property:** `spring.jpa.hibernate.ddl-auto`
- **Description:** Defines how Hibernate should handle database schema updates.
    - Possible values:
        - `none`: No action is performed.
        - `update`: Updates the schema without dropping existing data.
        - `create`: Drops and creates the schema at startup.
        - `create-drop`: Drops the schema at startup and shutdown.
    - **Value in this case:** `update`

---

## Notes
- Ensure that the MySQL server is running on the specified host and port.
- Replace the placeholder values for `username` and `password` with the actual credentials in a production environment.
- Use environment variables or externalized configuration to manage sensitive data like database credentials securely.

## Launch MySQL Using Docker

To run a MySQL database container using Docker, execute the following command:

```bash
docker run --detach \
  --env MYSQL_ROOT_PASSWORD=dummypassword \
  --env MYSQL_USER=sprints-user \
  --env MYSQL_PASSWORD=dummysprints \
  --env MYSQL_DATABASE=sprints \
  --name mysql \
  --publish 3307:3306 \
  mysql:8-oracle
```

### Accessing the Database Using MySQL Shell

### Install MySQL Shell
Ensure MySQL Shell is installed on your system. Refer to the [MySQL Shell Installation Guide](https://dev.mysql.com/doc/mysql-shell/en/) for installation instructions.

### Connect to the Database
Use the following command to connect to the MySQL database:

```bash
\connect sprints-user@localhost:3307
```

### Select the Database
Switch to the `sprints` database:
```bash
\use sprints
```

### Query the Database
Run the following SQL query to fetch data from the sprints table:

```bash
select * from sprints;
```
