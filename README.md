
# College Management System

## Overview
This collection of Java classes simulates a simple yet functional college management system. It manages aspects such as courses, students, and academic records through a series of interconnected classes, each responsible for specific facets of the college's operations.

## Classes Description

### College.java
Manages courses and student enrollments within a college.
- **Usage**:
  ```java
  College college = new College("College Name");
  college.addCourse(new Course("Course ID", "Course Name", Credits));
  ```

### CollegeDemo.java
Demonstrates the use of the `College` class through various examples.
- **Usage**:
  ```java
  CollegeDemo demo = new CollegeDemo();
  demo.runDemo();
  ```

### Course.java
Represents a single course within the college.
- **Usage**:
  ```java
  Course course = new Course("Course ID", "Course Name", Credits);
  ```

### CourseTaken.java
Links students with the courses they have taken and their grades.
- **Usage**:
  ```java
  CourseTaken courseTaken = new CourseTaken(student, course, "Grade");
  ```

### ListIterator.java'
Provides iterator functionality for custom list structures.
- **Usage**:
  ```java
  ListIterator<Course> iterator = new ListIterator<>(courseList);
  ```

### Node.java
Represents a node in a linked list used in various data structures.
- **Usage**:
  ```java
  Node<Course> node = new Node<>(new Course("Course ID", "Course Name", Credits));
  ```

### Student.java
Manages a student's ID, name, and the courses they are enrolled in.
- **Usage**:
  ```java
  Student student = new Student("Student ID", "Student Name");
  student.addCourse(courseTaken);
  ```

## Requirements
- Java 8 or higher
- IDE that supports Java (e.g., IntelliJ IDEA, Eclipse)

## How to Compile and Run
Compile the Java classes and execute the `CollegeDemo.java` to see how the system works:
```bash
javac *.java
java CollegeDemo
```
