ARG jar_file=counterpart-app.jar
FROM openjdk:17-jdk-slim
ARG jar_file
COPY target/counterpart-0.0.1-SNAPSHOT.jar ${jar_file}
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "counterpart-app.jar"]