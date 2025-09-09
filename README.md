# Hotel-Rating-Microservice

**Author:**Shivraj Singh Chouhan 
**GitHub:** [shivaysinghchouhan](https://github.com/shivaysinghchouhan)  

**Project Type:** Microservices Architecture  
**Technology Stack:** Java 8, Spring Boot 2.5.2, Kafka, REST API  

**Description:**  
This project is a **Hotel Review and Rating System**. Users can submit reviews and ratings for hotels. **Kafka** is implemented for **order and notification communication**. The project is based on a **multi-microservice architecture** to handle different functionalities independently.  

---

## Features
- Users can add reviews and ratings for hotels  
- Kafka-based communication for orders and notifications  
- Multi-service architecture:  
  - **UserService, HotelService, ReviewService, OrderService, NotificationService**  
- **API Gateway** for routing requests  
- Central **ServerConfiguration** and **ServiceRepository** for shared configurations  

---

## Microservices Structure

| Service Name            | Description |
|-------------------------|-------------|
| **ApiGateway**           | Routes requests to the appropriate microservices |
| **HotelService**         | Manages hotel information and data |
| **UserService**          | Handles user registration and authentication |
| **ReviewService**        | Manages hotel reviews and ratings |
| **OrderService**         | Handles hotel bookings/orders |
| **NotificationService**  | Sends notifications to users |
| **ServerConfiguration**  | Central configuration for all microservices |
| **ServiceRepository**    | Shared repository configurations |

---

## Technologies Used
- **Java 8**  
- **Spring Boot 2.5.2**  
- **Apache Kafka** for messaging  
- **Maven** for dependency management  
- **REST APIs** for communication  

---

## Getting Started

### Prerequisites
- Java 8 installed  
- Apache Kafka running (locally or remotely)  
- Maven installed  

### Steps to Run
1. Clone the repository:
   ```bash
      https://github.com/shivaysinghchouhan/Hotel-Rating-Microservice.git
