FROM ubuntu:latest
RUN apt-get update
RUN apt update
RUN apt-get install default-jdk -y

WORKDIR /app

COPY target/math_calc-0.1.jar app/MathApp.jar

# Command to run the Java application
ENTRYPOINT ["java", "-jar", "app/MathApp.jar"]

