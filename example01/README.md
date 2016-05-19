# Simple Spring Boot Web App

This example showcase how to develop a simple web application using Spring Boot.
It's using [`ratpack-spring-boot`](https://ratpack.io/) to handle HTTP requests and `spring-boot-starter-jdbc` for raw
SQL database access.

This project doesn't use complex concepts like `spring-webmvc` and JPA on purpose.
It's goal is to show how simple a Spring Boot application can be.

This project uses a mixture of unit and integration tests.
Therefore it's using two PostgresSQL databases: one for running the application and one for running the tests.

A [`docker-compose.yml`](docker-compose.yml) file manages the necessary databases.

To start them use:
> docker-compose up -d
