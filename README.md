# JDBC Database Access Project using DAO Pattern (Data Access Object)

This project aims to demonstrate database access using the Java programming language and the JDBC (Java Database Connectivity) API. The DAO (Data Access Object) design pattern has been implemented manually to facilitate interaction with the database.

## JDBC (Java Database Connectivity)

JDBC (Java Database Connectivity) is a Java API that provides an interface for interacting with relational databases. It allows developers to connect to a database, execute SQL queries, and efficiently retrieve and update data. JDBC is independent of the underlying database and offers a set of classes and interfaces for performing database operations.

## DAO (Data Access Object) Design Pattern

The DAO (Data Access Object) design pattern is a design pattern that separates the data access logic from the rest of the application. It provides a high-level abstraction for accessing and manipulating data in a database. The goal of the DAO pattern is to isolate the business logic from the specific database implementation, making the code more modular, flexible, and easier to maintain.

The DAO consists of interfaces that define data access operations (such as insert, update, delete, and query) and implementation classes that provide the concrete logic for interacting with the database. With the DAO pattern, database operations are encapsulated in DAO objects, which can be easily used by the main application.

## Prerequisites

Make sure you have the following requirements before running the project:

- Installed JDK (Java Development Kit)
- Compatible database (e.g., MySQL, PostgreSQL, Oracle)
- JDBC driver specific to the chosen database
- Java development environment (e.g., Eclipse, IntelliJ IDEA) or a text editor

## Database Configuration

1. Create an empty database on your database server.
2. Copy and paste the contents of the `database.sql` file into your database to create the tables and insert sample data.

Make sure to replace the example values with relevant data for your case.

## Project Setup

1. Download or clone the project into your Java development environment.
2. Import the project into your Java development environment.

## JDBC Driver Configuration

1. Add the JDBC driver JAR file specific to the chosen database to the project's classpath.
2. Verify that the JDBC driver is correctly configured in the database connection class.

## Contribution

Feel free to contribute improvements to this project by following these steps:

1. Fork the repository.
2. Create a branch for your new feature (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a pull request in the original repository.
