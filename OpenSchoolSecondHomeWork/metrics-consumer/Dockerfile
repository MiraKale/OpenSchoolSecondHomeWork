FROM openjdk:17-jdk-alpine
COPY ./target/metrics-consumer-0.0.1-SNAPSHOT.jar metrics-consumer.jar
EXPOSE 8081
CMD ["java","-jar","metrics-consumer.jar"]