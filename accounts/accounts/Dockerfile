#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

MAINTAINER maxxbank.com

COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]