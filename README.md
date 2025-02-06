# Spring Boot Kubernetes Microservices

This project demonstrates a microservices architecture using Spring Boot, Kubernetes, and RabbitMQ.

## Services

The project consists of the following services:

- **Cards Service**
- **Loans Service**
- **Accounts Service**
- **Config Server**
- **Eureka Server**
- **Gateway Server**

## Configuration

Each service has its own configuration file located in the `src/main/resources` directory:

- `cards/src/main/resources/application.yml`
- `loans/src/main/resources/application.yml`
- `accounts/src/main/resources/application.yml`
- `configserver/src/main/resources/application.yml`
- `eurekaserver/src/main/resources/application.yml`
- `gatewayserver/src/main/resources/application.yml`

### Common Configuration

- **Server Port**: Each service runs on a different port.
- **Spring Profiles**: All services use the `qa` profile.
- **Datasource**: H2 in-memory database is used for all services.
- **Management Endpoints**: All endpoints are exposed.

## Running RabbitMQ

To run RabbitMQ, use the following Docker command:

```sh
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0-management
```

## Minikube

```sh
minikube start
kubectl port-forward svc/loans 8090:8090
```