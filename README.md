# MOVIE REST API
Date: 2022-08-19  
Author: Emma Kang

## Requirement
* REST or GraphQL
* Support to create,read,update,and delete movies
* Support to search movies by title
* Support to anonymously like/dislike a movie
* Each movie supports title,description,release year,duration,rating
* Integration with SQL based database

## Environment 
* Java v15
* Spring Boot v2.7.3
* Hibernate v6.1.2.Final
* Relational Database: PostgreSQL
* Development IDE: IntelliJ 

To run application locally, Local database should be set up.  
`docker run -d -p 5432:5432 --name movie_local -e POSTGRES_PASSWORD=localdb123 postgres`
`psql -U postgres`
`CREATE DATABASE movie_local`


