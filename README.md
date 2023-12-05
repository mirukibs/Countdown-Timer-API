# Countdown Timer Application

**[Project Description]**

The Countdown Timer Application is a Spring Boot-based web application that allows users to create and manage countdown events for various occasions. Users can set event names, dates, and times, view countdowns for upcoming events, and receive push notifications as reminders.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Countdown Timer Application is designed to help users keep track of important upcoming events by providing a user-friendly interface to create, manage, and receive reminders for those events. Whether it's a wedding, a birthday, or any significant event, this application ensures that you never miss a special moment.

## Features

- **Event Creation**: Users can create countdown events by specifying event names, dates, and times.
- **Countdown Display**: The application calculates and displays countdowns in days, hours, minutes, and seconds for each event.
- **Event List**: Users can view a list of upcoming events and access event details.
- **Past Event Archive**: Past events are archived for reference.
- **Push Notifications**: Users receive push notifications a specified number of days before each event.
- **User Authentication**: Implement user accounts for secure event management.

## Technologies Used

- **Java**: Programming language for backend development.
- **Spring Boot**: Framework for building Java applications.
- **Spring Data JPA**: For database interactions.
- **MySQL (or your preferred relational database)**: For data storage.
- **Firebase Cloud Messaging (FCM)**: For sending push notifications (or your preferred push notification service).
- **Swagger**: For API documentation.

## Getting Started

### Prerequisites

- [Java Development Kit (JDK)](https://adoptopenjdk.net/) 11 or higher.
- [MySQL](https://www.mysql.com/) or your preferred relational database.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/countdown-timer.git
   ```

2. Navigate to the project directory:

   ```bash
   cd countdown-timer
   ```

3. Configure the database settings in `application.properties` or `application.yml`.

4. Build and run the Spring Boot application:

   ```bash
   ./mvnw spring-boot:run
   ```

   Alternatively, you can package the application and run the JAR file:

   ```bash
   ./mvnw clean package
   java -jar target/countdown-timer-0.1.jar
   ```

## API Documentation

The API documentation is available at `http://139.59.4.136:8080/swagger-ui/index.html#/`.


## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and test thoroughly.
4. Create a pull request describing your changes.

## License

This project is licensed under the [MIT License](LICENSE).

---

© 2023 [Kibwana Miruru](https://github.com/mirukibs)
