# Student-Management_System
Student Management System !!!
# Student Management System

## Overview

Student Management System is a Java-based console application that helps manage student records using MySQL database integration through JDBC.

The application allows users to perform CRUD operations (Create, Read, Update, Delete) on student records efficiently.

---

## Features

- Add Student
- View All Students
- Search Student by ID
- Update Student Details
- Delete Student
- MySQL Database Integration
- JDBC Connectivity
- Menu-Driven Console Interface

---

## Technologies Used

- Java
- JDBC
- MySQL
- OOP Concepts
- VS Code

---

## Database Schema

### Database

```sql
CREATE DATABASE student_db;
```

### Table

```sql
CREATE TABLE students(
    id INT PRIMARY KEY,
    name VARCHAR(100),
    mark DOUBLE
);
```

---

## Project Structure

```
StudentManagementSystem/
│
├── StudentManagementSystem.java
├── DBConnection.java
├── mysql-connector-j-9.7.0.jar
└── README.md
```

---

## Setup Instructions

### 1. Clone Repository

```bash
git clone <repository-url>
```

### 2. Create Database

```sql
CREATE DATABASE student_db;
USE student_db;

CREATE TABLE students(
    id INT PRIMARY KEY,
    name VARCHAR(100),
    mark DOUBLE
);
```

### 3. Configure Database Connection

Update the credentials inside `DBConnection.java`

```java
String url = "jdbc:mysql://localhost:3306/student_db";
String user = "root";
String password = "your_password";
```

### 4. Add MySQL JDBC Driver

Download MySQL Connector/J and add the JAR file to the project.

### 5. Run Application

```bash
javac StudentManagementSystem.java
java StudentManagementSystem
```

---

## Sample Menu

```text
===== STUDENT MANAGEMENT SYSTEM =====

1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit
```

---

## Sample Output

```text
Enter ID: 101
Enter Name: Josh
Enter Mark: 89

Student Added Successfully!
```

```text
----- STUDENT RECORDS -----

101 | Josh | 89.0
102 | John | 92.0
```

---

## Concepts Implemented

- Classes and Objects
- Methods
- JDBC API
- MySQL Database
- PreparedStatement
- ResultSet
- CRUD Operations
- Exception Handling

---

## Future Enhancements

- GUI using Java Swing
- Login Authentication
- Search by Name
- Export Data to Excel/PDF
- Spring Boot Integration
- REST API Development

---

## Author

Joshva Jason

Java Developer | Learning Backend Development
