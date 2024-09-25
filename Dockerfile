FROM ubuntu:latest
RUN apt-get update
RUN apt update
RUN apt-get install default-jdk -y

COPY . .
# Compile the Java file
RUN javac Main.java

# Command to run the Java application
CMD ["java", "Main"]




