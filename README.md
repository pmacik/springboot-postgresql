# springboot-postgresql

## Quick Start
- Clone repo: https://github.com/pratikjagrut/springboot-postgresql.git

- Spin postgresql container. 

`podman run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine`

- Get an access to DB ` podman exec -it 4fc8fc174aa8 bin/bash`
  - Inside container, get into db: `psql -U postgres`
  - Create Database: `CREATE DATABASE springdb;`
  - Use created DB: `\c springdb`
  - Check tables: `\dt` (should be empty at first attempt)

- In other terminal: `cd springboot-postgresql` and run app `mvn spring-boot:run`

- Now goto Postman or you can use CURL tool to interact
  - To add entry: 
  
    `curl -H "Content-Type: application/json" -X POST http://localhost:8080/accounts/ -d '{"id": "1", "name": "Pratik jagrut", "email": "xyz@xyz.xyz"}'`
  - To get entry: 
  
    `curl http://localhost:8080/accounts/ ` or `curl -X GET http://localhost:8080/accounts/`
  - To update Entry: 
    
    `curl -H "Content-Type: application/json" -X PUT http://localhost:8080/accounts/1 -d '{"id": "1", "name": "James Bond", "email": "xyz@xyz.xyz"}'`
  - To delete entry: 
  
    `curl -X DELETE http://localhost:8080/accounts/1`
  
  - You can verify each step by running `SELECT * FROM account;` on your DB.