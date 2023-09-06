package com.igor.boot.fullstackApp;

import com.vaadin.flow.server.PWA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@PWA(
		name = "Accounting",
		shortName = "ACC"
)
public class FullstackAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackAppApplication.class, args);
	}

}
