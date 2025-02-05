# Spring Boot Kubernetes Microservices

This project demonstrates a microservices architecture using Spring Boot, Kubernetes, and RabbitMQ.

## Services

The project consists of the following services:

- **Cards Service**
- **Loans Service**
- **Accounts Service**

## Configuration

Each service has its own configuration file located in the `src/main/resources` directory:

- `cards/src/main/resources/application.yml`
- `loans/src/main/resources/application.yml`
- `accounts/src/main/resources/application.yml`

### Common Configuration

- **Server Port**: Each service runs on a different port.
- **Spring Profiles**: All services use the `prod` profile.
- **Datasource**: H2 in-memory database is used for all services.
- **Management Endpoints**: All endpoints are exposed.

## Running RabbitMQ

To run RabbitMQ, use the following Docker command:

```sh
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0-management
````
## KeyCloak

To run KeyCloak, use the following Docker command:

```sh
docker run -p 7080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.1.0 start-dev
```

### Redis

To run Redis, use the following Docker command:

```sh
docker run --name redis-container -p 6379:6379 redis
```

