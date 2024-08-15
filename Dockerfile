FROM openjdk:17
COPY ./target/reservationms.jar /reservationms.jar
CMD ["java", "-jar", "/reservationms.jar"]