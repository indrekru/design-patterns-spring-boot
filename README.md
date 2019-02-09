# Design patterns in spring boot
This repository is a simple spring boot application, that demonstrates a few design patterns:

* Singleton
* Controller
* Factory
* Strategy
* Proxy
* Observer

## Running

This demo application retrieves contact phone numbers from 2 different bank's websites (more banks can be added) with specific implementations per bank and offers a nice interface to hide the specifics.

1. Run `mvn install` from the root
2. Run `mvn spring-boot:run`
3. Open browser and go to http://localhost:8080/api/v1/banks and you should see the results

Also check out Spring Boot 2 Oauth2 resource server example: https://github.com/indrekru/spring-boot-2-oauth2-resource-server
