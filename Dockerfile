FROM openjdk:8-jre-alpine
COPY ./target/ ./
CMD ["Java", "-jar", "/121121-0.0.1-SNAPSHOT.jar"]