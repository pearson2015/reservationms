package com.myhotel.reservationms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReservationmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationmsApplication.class, args);
	}

}
