#!/bin/bash

kubectl delete -f kubernetes.yaml
mvn clean package
docker build -t camunda-kafka-project .
docker tag camunda-kafka-project:latest kirankumarhm/camunda-kafka-project:latest
docker push kirankumarhm/camunda-kafka-project:latest

kubectl apply -f kubernetes.yaml
