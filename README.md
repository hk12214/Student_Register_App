
Student Registration Servlet Application

A simple Java Servlet web application that allows users to register students into a database and view all registered students in a table.

Features

Register a student with Name, Email, and Year

View all registered students in an HTML table

Data is stored persistently in a relational database

Technologies Used

Java (Servlets, JDBC)

HTML & CSS

Apache Tomcat

MySQL 

Application Endpoints

1. Register Student

POST /Register

Accepts student details from an HTML form

Validates input

Saves the student into the database

Form Fields

Name

Email

Year

2. View All Students

GET /ShowAll.

Fetches all student records from the database

Displays them in an HTML table (Name, Email, Year)

Database Schema

Table Name: students
	
Column	Type		Constraints

id	INT		Primary Key, Auto Increment

name	VARCHAR(100)	Not Null

email	VARCHAR(100)	Not Null, Unique
year	INT	Not Null


Setup Instructions

Clone the repository

Create the database and students table

Update database credentials in the project

Deploy the project on Apache Tomcat

Open the application in a browser

Project Structure (Simplified)

Register.java – Handles student registration

ShowAll.java – Displays all students

Register.jsp – Student registration form

ShowAll.jsp – Student list view

Output

Successful registration stores student data in the database

/ShowAll displays all registered students in a table

