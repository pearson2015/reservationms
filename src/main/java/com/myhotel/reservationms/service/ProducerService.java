package com.myhotel.reservationms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myhotel.reservationms.dto.Message;
import com.myhotel.reservationms.entity.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProducerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //kafka-topics --bootstrap-server localhost:9092 --topic notification_topic --create --partitions 3 --replication-factor 1
    //kafka-topics --bootstrap-server localhost:9092 --list
    //kafka-console-consumer --bootstrap-server localhost:9092 --topic notification_topic --from-beginning
    @Value("${system.notificationTopic}")
    private String notificationTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String key, String value) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(notificationTopic, key, value);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                logger.info(String.format("Produced event to topic %s: key = %-10s value = %s", result.getRecordMetadata().topic(), key, value));
            } else {
                ex.printStackTrace(System.out);
            }
        });

    }

    public void sendMessage(Reservation reservation) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Message message = new Message();
            message.setEmail(reservation.getEmail());
            message.setMessage("Reservation done successfully");
            message.addData("price", reservation.getPrice());
            message.addData("roomType", reservation.getRoomType());
            message.addData("roomNumber", reservation.getRoomNumber());
            message.addData("reservationStatus", reservation.getReservationStatus());
            sendMessage("ReservationNotification", objectMapper.writeValueAsString(message));
        } catch(Exception e) {
            logger.error("Error while sending message to Kafka", e);
        }
    }

}
