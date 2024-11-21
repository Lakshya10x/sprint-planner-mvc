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




