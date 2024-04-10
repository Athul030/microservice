# Microservices Architecture with Spring Boot

Welcome to my microservices architecture project built with Spring Boot! 🚀

## Overview

This project consists of multiple services written in Spring Boot, communicating over HTTP using Spring Cloud OpenFeign. 
We utilize Netflix Eureka Server as our registry service, with microservices acting as Eureka clients. 
The API Gateway is implemented using Spring Cloud Gateway.

## Eureka Dashboard

You can monitor the health and status of our microservices by visiting [http://localhost:8761].
Here, you'll find the Spring Eureka dashboard, displaying instances currently registered with Eureka along with their statuses.

## Usage

To interact with our microservices, you can use Postman or any other HTTP client to send requests to [http://localhost:8083], 
which serves as the API Gateway address.



## Getting Started

To run the project locally, follow these steps:

1. Clone the repository.
2. Navigate to the root directory.
3. Run `./mvnw clean install` to build the project.
4. Start each microservice using `./mvnw spring-boot:run` command.
5. Access the Eureka dashboard and API Gateway address as mentioned above.

## Contributing

We welcome contributions from the community! Feel free to open issues or submit pull requests to help improve this project.


