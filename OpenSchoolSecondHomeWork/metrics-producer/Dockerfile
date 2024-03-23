FROM openjdk:17-jdk-alpine
COPY ./target/metrics-producer-0.0.1-SNAPSHOT.jar metrics-producer.jar
EXPOSE 8081
CMD ["java","-jar","metrics-producer.jar"]