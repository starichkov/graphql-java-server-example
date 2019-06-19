# GraphQL Java usage example

## MongoDB

I have used official [Docker image](https://hub.docker.com/_/mongo) for MongoDB 3.6 (Xenial).

1. First, installed MongoDB client for my Linux Mint:

  ```
  sudo apt install mongodb-clients
  ```

1. Started MongoDB in the Docker container:

  ```
  sudo docker pull mongo:3.6.13-xenial
  sudo docker run --name mongo-3.6 -d -p 127.0.0.1:27017:27017 mongo:3.6.13-xenial
  ```

1. Cleanup

  ```
  sudo docker container stop mongo-3.6
  sudo docker container rm mongo-3.6
  ```

## Running

1. Launch `GraphQLSpringBootApplication`

1. Get all links stored in the database:

  ```http request
  GET http://localhost:8080/graphql?query={allLinks{url, description}}
  Accept: */*
  Cache-Control: no-cache
  ```

1. Add new link to the MongoDB database:

  ```http request
  POST http://localhost:8080/graphql
  Content-Type: application/json

  {
    "query": "mutation createLink($url: String!, $desc: String!){createLink(url: $url, description: $desc) { url, description } } ",
    "variables": {
      "url": "http://dot.com",
      "desc": "Dot Com"
    }
  }
  ```

### Tutorials used
* Based on [HowToGraphQL](https://www.howtographql.com/graphql-java)'s tutorial for Java
* Spring Boot MongoDB configuration [example](https://www.journaldev.com/18156/spring-boot-mongodb)
* Spring Boot Application startup events [example](http://blog.netgloo.com/2014/11/13/run-code-at-spring-boot-startup/)
