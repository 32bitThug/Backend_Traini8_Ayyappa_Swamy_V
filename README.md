
# Training Center API

## Overview
This is a Spring Boot application that provides APIs to manage training centers. The application allows users to add, retrieve, and filter training centers based on different criteria.

## Technologies Used
- **Java 17**
- **Spring Boot 3.4.4**
- **MySQL**
- **Git**

## Prerequisites
Before running the project, ensure you have the following installed:
- **Java 17+**
- **Maven 3+**
- **MySQL** (or another database of choice)
- **Git**
- **IntelliJ IDEA** or any preferred IDE

## Setup Instructions

### 1. Clone the Repository
```sh
git clone https://github.com/32bitThug/-Backend_Traini8_Ayyappa_Swamy_V.git
cd Backend_Traini8_Ayyappa_Swamy_V
```

### 2. Configure Database
1. Download MySQL Installer from official website
2. Choose "Developer Default" or "Server only" installation
3. Set root password during installation
4. Complete installation wizard
5. Open MySQL Workbench
6. Click on + to add a new connection.
7. Set the Connection Name (training-center-service).
    Hostname: localhost
    Port: 3306  
    Username: root
    Password: root
8. Click Test Connection to verify.
9. Click OK to save the connectio  

Create a MySQL database:
- open the connection 
```sql
CREATE DATABASE training-center-service;
```

Update `src/main/resources/application.properties` with your database details:
```properties
// your db connection url
spring.datasource.url=jdbc:mysql://localhost:3306/training-center-service
//your username of the connection
spring.datasource.username=root
// your password of the connection
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 3. Install Dependencies
```sh
mvn clean install
```

### 4. Run the Application
```sh
mvn spring-boot:run
```
The application will start on **http://localhost:8080**. Use Postman or cURL to test APIs.

## API Endpoints

### 1. Get All Training Centers
```http
GET http://localhost:8080/training-center/all
```
Response:
```json
[
    {
        "id": 1,
        "centerName": "TechTrainingHub",
        "centerCode": "Tv11235asagb",
        "address": {
            "detailedAddress": "sfds",
            "city": "Delhi",
            "state": "Sa",
            "pinCode": "500063"
        },
        "studentCapacity": 200,
        "coursesOffered": [
            "DSA",
            "Spring Boot",
            "Py",
            "Cloud Computing"
        ],
        "createdOn": 1743096000,
        "email": "contacttechtra@ining.com",
        "phoneNo": "5345445449"
    },
]
```

### 2. Add a Training Center
```http
POST http://localhost:8080/training-center
Content-Type: application/json
```
Request Body:
```json
{
  "centerName": "Tech Training Hub",
  "centerCode": "TCH123456789",
  "address": {
    "detailedAddress": "123, ABC Street",
    "city": "Hyderabad",
    "state": "Telangana",
    "pinCode": "500001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot", "Python", "Cloud Computing"],
  "email": "contact@techtraining.com",
  "phoneNo": "9876543210"
}

```

### 3. Get Training Centers by Filters
```http
GET http://localhost:8080/training-center/filter?city=Hyderabad&state=Telangana
```

## Handling Validation Errors
If validation fails (e.g., missing fields), the API returns a **400 Bad Request** response with an appropriate message.




