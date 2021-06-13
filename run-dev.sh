#!/bin/bash

docker-compose up --force-recreate --build -d

docker-compose exec ip-service mvn clean
docker-compose exec ip-service mvn package
docker-compose exec ip-service java -jar target/ip-1.jar
