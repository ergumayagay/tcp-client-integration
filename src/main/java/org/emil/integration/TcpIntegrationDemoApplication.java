package org.emil.integration;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("tcp-config.xml")
public class TcpIntegrationDemoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TcpIntegrationDemoApplication.class, args);
		 
	}
	
	@Bean
	public CommandLineRunner run(Gateway gateway) {
		return args -> {
			
			String result = gateway.send("this is a message");
			
			System.out.println(result);
			
		};
	}
}
