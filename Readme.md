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

##Summary:
Encoding/Decoding: Changes the format for compatibility, but is reversible.
Hashing: Secures passwords by making them impossible to reverse, which is what websites usually use for storing passwords.
