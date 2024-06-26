# info_company_test
his project is a Spring application configured to work with PostgreSQL for storing primary information about companies and their reports, and MongoDB for storing detailed report information.

## Project structure
#### N-tier architecture with Spring

+ @Controller: the presentation tier
+ @Service: the application logic tier
+ @Repository: the data tier 

## Endpoints
+ POST: /register
+ POST: /login
+ POST: /companies
+ GET: /companies
+ GET: /companies/{id}
+ PATCH: /companies/{id}
+ DELETE: /companies/{id}
+ POST: /reports
+ GET: /reports/{id}
+ GET: /reports/company/{id}
+ PATCH: /reports/{id}
+ DELETE: /reports/{id}
+ POST: /report_details
+ GET: /report_details/{id}
+ GET: /report_details/report/{id}
+ PATCH: /report_details/{id}
+ DELETE: /report_details/{id}

## Used technologies
+ Java 11
+ Spring  
+ Spring Data JPA
+ Hibernate
+ Spring Data MongoDB
+ Liquibase
+ Spring Security
+ Docker
+ PostgreSQL
+ MongoDB

## Requirements
+ Docker
+ Docker Compose

## You can use this project
+ clone this project
+ build Docker images: docker-compose build
+ start containers: docker-compose up
+ authenticate: url: http://localhost:8081/login username: admin password: admin 
+ access the application: http://localhost:8081
+ stop and remove all containers: docker-compose down
