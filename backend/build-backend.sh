#!/bin/bash
cd atm-service/
mvn clean package
cd ../
cd auth-service/
mvn clean package
cd ../
