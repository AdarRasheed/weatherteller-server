# weatherteller-server

## Project Description

This is a spring boot application that gathers weather information of a city periodically, with a user defined delay in minutes.
It uses [OpenWeather](https://openweathermap.org/) to poll current weather information using its current weather API key generated with an account on the platform.
It also populates cities data from a csv file into an in-memory H2 database on project initialization, and offers that data and weatherstamps data with API's to be consumed by portal-application.
It offers the Temperature in Celcius along with recorded and reported timestamps for the individual weatherstamp records for a city.
 

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 4](https://maven.apache.org)

## Running the application locally

There are several ways to run this application on your local machine. One way is to execute the `main` method in the `com.assignmento.weathertellerserver.WeathertellerServerApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Port for the application

```shell
8080
```
