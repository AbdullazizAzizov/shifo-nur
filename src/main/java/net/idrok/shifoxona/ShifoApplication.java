package net.idrok.shifoxona;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ShifoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShifoApplication.class, args);

	}

	
	// @Scheduled(fixedDelay = 1000)
	// public void tekshirish(){
	// 	System.out.println("ishladi: " + LocalDateTime.now().getNano());
	// }

}
