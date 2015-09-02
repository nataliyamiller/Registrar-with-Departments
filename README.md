# To Do List - with database

##### A university registrar. September 1, 2015.

#### By **Nataliya Bareeva-Miller and  Diana Holland**

## Description

Administrators can add students to courses, and courses to students.

## Setup

* Please have all Java developer tools ready, including the JDK
* You'll need Gradle or some other way to run and compile Java
* This app uses Spark and Velocity for coordinating its front end
* You may use the database included with this file. Otherwise, create your own using the following information:

**In PSQL:**

CREATE DATABASE university_registrar;
\c university_registrar;
CREATE TABLE courses (id SERIAL PRIMARY KEY, course_name VARCHAR(50), course_number VARCHAR(15));
CREATE TABLE students (id SERIAL PRIMARY KEY, name VARCHAR(50), enroll_date VARCHAR(25));
CREATE TABLE courses_students (id SERIAL PRIMARY KEY, course_id INT, student_id INT);
CREATE DATABASE university_registrar_test WITH TEMPLATE university_registrar;

## Technologies Used

This app is written in Java with a little help from Bootstrap.

### Legal

Copyright (c) 2015 **Nataliya Bareeva-Miller and  Diana Holland**

This software is licensed under the MIT license.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
