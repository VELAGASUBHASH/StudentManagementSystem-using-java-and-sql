📌 Overview
This is a simple Java console-based application that connects to a MySQL database to manage student records.
It demonstrates how to:

Connect Java to MySQL using JDBC.

Perform CRUD operations (Create, Read, Search) on a database.

Use Java’s Scanner for console input.

🛠 Features
Add new students with name, age, and grade.

View all students in the database.

Search students by ID.

Simple text-based interface (no color formatting).

🏗 Technologies Used
Java 24 (JDK)

MySQL 8.x (Database)

MySQL Connector/J 9.3 (JDBC Driver)

Visual Studio Code (IDE)

📂 Project Structure
Java Project/
│── mysql-connector-j-9.3.0.jar    # MySQL JDBC driver
│── StudentManagement.java         # Main source code
│── StudentManagement.class        # Compiled Java bytecode
⚙️ Setup Instructions
1️⃣ Create Database in MySQL
CREATE DATABASE school_db;
USE school_db;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    grade VARCHAR(10) NOT NULL
);
2️⃣ Download MySQL Connector/J
Download from: MySQL Connector/J Download

Choose Platform Independent (ZIP).

Extract and place the .jar file in your project folder.

3️⃣ Compile & Run the Program
In Command Prompt or PowerShell, navigate to your project folder:

javac -cp ".;mysql-connector-j-9.3.0.jar" StudentManagement.java
java  -cp ".;mysql-connector-j-9.3.0.jar" StudentManagement

📖 Usage
When you run the program, you will see:
sql Connected to the database!

1. Add Student
2. View Students
3. Search Student by ID
4. Exit

Choose an option by typing its number.


Output:
<img width="503" height="395" alt="image" src="https://github.com/user-attachments/assets/3296448f-98e1-4d99-8584-80dd30c2664d" />
<img width="860" height="257" alt="image" src="https://github.com/user-attachments/assets/b5f74b2e-8fc6-4d81-80c3-362747c3b2eb" />
<img width="822" height="365" alt="image" src="https://github.com/user-attachments/assets/eb216a5a-09bb-4e09-9ee9-34c4f9a1204d" />
<img width="849" height="662" alt="image" src="https://github.com/user-attachments/assets/8b76ad79-d804-491b-a565-aad4f72f5229" />
