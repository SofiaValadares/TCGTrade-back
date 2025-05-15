FROM maven:3.8.5-openjdk-17
USER root

WORKDIR /app

COPY . /app/

RUN sed -i -r 's@localhost@arq-api-sqlserver@i' /app/src/main/resources/application.properties

RUN cd /app && mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "/app/target/springboot-0.0.1-SNAPSHOT.jar"]