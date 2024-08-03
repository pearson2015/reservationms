FROM openjdk:21
COPY ./target/reservationms-0.0.1-SNAPSHOT.jar /reservationms.jar
CMD ["java", "-jar", "/reservationms.jar"]