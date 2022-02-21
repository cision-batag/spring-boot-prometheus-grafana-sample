FROM maven:3.8.4-jdk-11
ADD . /app
WORKDIR /app
RUN mvn clean package
CMD mvn spring-boot:run
